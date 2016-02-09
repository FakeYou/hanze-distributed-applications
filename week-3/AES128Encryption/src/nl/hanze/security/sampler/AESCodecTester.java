package nl.hanze.security.sampler;

import nl.hanze.security.AESCodec;

public class AESCodecTester {
  
    public static void main(String[] args) {

        // make new codecs.
        // Two constructors: one with key, other without key.
        // In the latter case, use setKey(String key) before using encode or decode else exception is thrown

        AESCodec a1=new AESCodec("quA$$_pl0L8L%gW5");
        AESCodec a2=new AESCodec();

        try {
            // encode message in CBC mode
            String s=a1.encode("EEN GECODEERD BERICHT");
            // write hex coded string
            System.out.println(s);
            // decode message
            String t=a1.decode(s);
            // write decoded string
            System.out.println(t);

            // encode same message with different key
            a2.setKey("0L_*saGk^)RkF5q");
            s=a2.encode("NOG EEN GECODEERD BERICHT");
            // write hex coded string
            System.out.println(s);
            // decode message
            t=a2.decode(s);
            // write decoded string
            System.out.println(t);

            // encoding with empty key is possible
            a1.setKey("");
            s=a1.encode("WEDEROM EEN GECODEERD BERICHT");
            // write hex coded string
            System.out.println(s);
            // decode message
            t=a1.decode(s);
            // write decoded string
            System.out.println(t);

            // and encoding an empty message
            s=a1.encode("");
            // write hex coded string
            System.out.println(s);
            // decode message
            t=a1.decode(s);
            // write decoded string
            System.out.println(t);

            // finally a hash error is thrown if hash of message is not OK
            s=a1.encode("");
            // write hex coded string
            System.out.println(s);
            // mess with message -> replace all f in e
            s=s.replace('f','e');
            // decode message
            t=a1.decode(s);
            // write decoded string
            System.out.println(t);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}