package nl.hanze.security;

public class SHA {
    private SHA() {
    }

    public static int[] hash(int[] Y) {
        int l=Y.length;
        int b=(l-1)/16 + 1;

        int[][] Z=new int[b][16];
        for(int i=0;i<l;i++)
            Z[i/16][i%16]=Y[i];

        // padding, note : not quite like the standard
        for(int i=l; i<16*b;i++)
            Z[i/16][i%16]=0;

        int[] R={0x7654321, 0xfedcba98, 0x89abcdef, 0x01234567, 0x3c2d1e0f};
        for(int i=0; i<b;i++)
            Y=hash(R, Z[i]);

        return R;
    }

    public static int[] hash(int[] iReg, int[] Y) {
        int[] iRegClone=new int[5];
        int[] iW=new int[80];
        int i, j;

        for(i=0;i<16;i++) iW[i]=Y[i];
        for(;i<79;i++) iW[i]=iW[i-16] ^ iW[i-14] ^ iW[i-8] ^ iW[i-3];

        i=0;
        do {  // block 1
            for(j=0;j<5;j++) iRegClone[j]=iReg[j]; // f_t(b,c,d)=(b&c)|(~b&d)
            iReg[0]=((iRegClone[0]<<5)|(iRegClone[0]>>>27))+((iRegClone[1]&iRegClone[2])|(~iRegClone[1]&iRegClone[3]))+iRegClone[4]+iW[i]+0x5a827999;
            iReg[1]=iRegClone[0];
            iReg[2]=(iRegClone[1]<<30)|(iRegClone[1]>>>2);
            iReg[3]=iRegClone[2];
            iReg[4]=iRegClone[3];
            i++;
        } while (i<20) ;

        do {  // block 2
            for(j=0;j<5;j++) iRegClone[j]=iReg[j]; // f_t(b,c,d)=b^c^d
            iReg[0]=((iRegClone[0]<<5)|(iRegClone[0]>>>27))+(iRegClone[1]^iRegClone[2]^iRegClone[3])+iRegClone[4]+iW[i]+0x6ed9eba1;
            iReg[1]=iRegClone[0];
            iReg[2]=(iRegClone[1]<<30)|(iRegClone[1]>>>2);
            iReg[3]=iRegClone[2];
            iReg[4]=iRegClone[3];
            i++;
        } while (i<40) ;

        do {  // block 3
            for(j=0;j<5;j++) iRegClone[j]=iReg[j]; // f_t(b,c,d)=(b&c)|(b&d)|(c&d)
            iReg[0]=((iRegClone[0]<<5)|(iRegClone[0]>>>27))+((iRegClone[1]&iRegClone[2])|(iRegClone[1]&iRegClone[3])|(iRegClone[2]&iRegClone[3]))+iRegClone[4]+iW[i]+0x8f1bbcdc;
            iReg[1]=iRegClone[0];
            iReg[2]=(iRegClone[1]<<30)|(iRegClone[1]>>>2);
            iReg[3]=iRegClone[2];
            iReg[4]=iRegClone[3];
            i++;
        } while (i<60) ;

        do {  // block 4
            for(j=0;j<5;j++) iRegClone[j]=iReg[j]; // f_t(b,c,d)=b^c^d
            iReg[0]=((iRegClone[0]<<5)|(iRegClone[0]>>>27))+(iRegClone[1]^iRegClone[2]^iRegClone[3])+iRegClone[4]+iW[i]+0xca62c1d6;
            iReg[1]=iRegClone[0];
            iReg[2]=(iRegClone[1]<<30)|(iRegClone[1]>>>2);
            iReg[3]=iRegClone[2];
            iReg[4]=iRegClone[3];
            i++;
        } while (i<80) ;

        return iReg;
    }
}