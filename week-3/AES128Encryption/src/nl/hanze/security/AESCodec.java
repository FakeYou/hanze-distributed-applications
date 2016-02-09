package nl.hanze.security;

public class AESCodec {
    private AESE encoder;
    private AESD decoder;
    private int[] key;
    private boolean keyset=false;

    public AESCodec() {}

    public AESCodec(String s) {
        setKey(s);
    }

    public void setKey(String s) {
        key=makeKey(s);
        keyset=true;
        encoder=new AESE(key);
        decoder=new AESD(key);
    }

    public String encode(String plain) throws Exception {
        if (!keyset) throw new Exception("Key not set");
        int[] ie=marshallCharStringToIntArray(expand(plain));
        int[] hash=SHA.hash(ie);

        int l=plain.length();
        int[] ip=new int[ie.length+8];

        // prepare for encoding
        ip[0]=l;
        ip[1]=ip[2]=0;
        for(int i=0;i<ie.length;i++)
            ip[i+3]=ie[i];
        for(int i=0;i<5;i++)
            ip[ie.length+3+i]=hash[i];

        // encode
        int[] cipher=new int[ie.length+8];
        int[] prev={0,0,0,0};
        int[] pp=new int[4];

        for(int i=0;i<ip.length/4;i++) {
            // copy plain
            for(int j=0;j<4;j++)
                pp[j]=ip[4*i+j];
            // calculate new previous
            prev=encoder.ECB(xor(pp, prev));
            // copy previous to cipher
            for(int j=0;j<4;j++)
                cipher[4*i+j]=prev[j];
        }
        return marshallIntArrayToHexString(cipher);
    }

    public String decode(String cipher) throws Exception {
        if (!keyset) throw new Exception("Key not set");
        int[] ic=unmarshallHexStringToIntArray(cipher);
        int[] ip=new int[ic.length];

        // decode
        int[] prevP;
        int[] prevC={0,0,0,0};
        int[] pc=new int[4];

        for(int i=0;i<ic.length/4;i++) {
            // copy cipher
            for(int j=0;j<4;j++)
                pc[j]=ic[4*i+j];

            prevP=xor(decoder.ECB(pc), prevC);

            for(int j=0;j<4;j++)
                prevC[j]=pc[j];

            for(int j=0;j<4;j++)
                ip[4*i+j]=prevP[j];
        }

        // now fetch orginal extended int array
        int[] ie=new int[ic.length-8];
        for(int i=0;i<ie.length;i++)
            ie[i]=ip[i+3];

        // calculate hash
        int[] hash=SHA.hash(ie);

        for(int i=0; i<5; i++)
            if (hash[i]!=ip[ip.length-5+i]) throw new Exception("Hash error");

        return unmarshallIntArrayToCharString(ie).substring(0,ip[0]);
    }

    private int[] xor(int[] a, int[] b) {
        int[] temp=new int[4];
        for(int i=0;i<4;i++)
            temp[i]=a[i]^b[i];
        return temp;
    }

    private String intToHex(int i) {
        StringBuffer temp=new StringBuffer();
        int s=28, r;
        for(int mask=0xf0000000 ; mask!=0 ;mask>>>=4, s-=4) {
            r=(i&mask)>>>s;
            switch(r) {
                case 10 : temp.append("a"); break;
                case 11 : temp.append("b"); break;
                case 12 : temp.append("c"); break;
                case 13 : temp.append("d"); break;
                case 14 : temp.append("e"); break;
                case 15 : temp.append("f"); break;
                default : temp.append(r);
            }
        }
        return temp.toString();
    }

    private int hexToInt(char c) {
        switch(c) {
            case '0' : return 0;
            case '1' : return 1;
            case '2' : return 2;
            case '3' : return 3;
            case '4' : return 4;
            case '5' : return 5;
            case '6' : return 6;
            case '7' : return 7;
            case '8' : return 8;
            case '9' : return 9;
            case 'a' : return 10;
            case 'b' : return 11;
            case 'c' : return 12;
            case 'd' : return 13;
            case 'e' : return 14;
            case 'f' : return 15;
            default  : return 0;
        }
    }

    private String expand(String s) {
        // (1) each char in string takes 16 bits space, so each int contains 2 chars
        // (2) the length of the return int array must be a multiple of 16 since
        //     we require a multiple of 512 bits for the hashing function
        // (3) the previous remarks imply that the "extended" string must contain a multiple
        //     of 32 characters. (32x16bits=512 bits)
        // We suffix the string with 32-(l%32) '*' characters
        int l=s.length();
        StringBuffer temp=new StringBuffer(s);
        for(int i=(32-(l%32))%32;i!=0;i--)
            temp.append("*");
        return temp.toString();
    }

    private int[] marshallCharStringToIntArray(String s) {
        int l=s.length();
        int[] result=new int[l/2+(l%2)];

        for(int i=0;i<l/2;i++)
            result[i]=(((int) s.charAt(2*i)) << 16) | ((int) s.charAt(2*i+1));

        if (l%2==1) result[l/2]=((int) s.charAt(l-1)) << 16;
        return result;
    }

    private String marshallIntArrayToHexString(int[] iArray) {
        if (iArray==null || iArray.length==0) return "00000000";
        StringBuffer temp=new StringBuffer();
        for(int j=0;j<iArray.length;j++)
            temp.append(intToHex(iArray[j]));
        return temp.toString();
    }

    private int[] unmarshallHexStringToIntArray(String s) {
        int l=s.length();
        if (l==0) return new int[0];
        if (l%8!=0) { // append 0 if neccessary
            StringBuffer temp=new StringBuffer(s);
            for(int j=0;j<8-(l%8);j++)
                temp.append("0");
            s=temp.toString();
            l=s.length();
        }
        int [] result=new int[l/8];

        for(int i=0;i<l/8;i++) {
            for(int j=0;j<8;j++) result[i]|=hexToInt(s.charAt(8*i+j))<<(4*(7-j));
        }
        return result;
    }

    private String unmarshallIntArrayToCharString(int[] Y) {
        StringBuffer temp=new StringBuffer();
        for(int i=0;i<Y.length;i++) {
            temp.append((char) (Y[i]>>>16));
            temp.append((char) (Y[i]&0xffff));
        }
        return temp.toString();
    }

    private int[] makeKey(String key) {
        int[] r=SHA.hash(marshallCharStringToIntArray(key));
        int[] temp=new int[4];
        for(int i=0;i<4;i++)
            temp[i]=r[i];
        return temp;
    }
}