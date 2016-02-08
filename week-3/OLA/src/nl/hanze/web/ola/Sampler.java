package nl.hanze.web.ola;

public class Sampler {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.home"));

        String homeDir = System.getProperty("user.home");
        String dataDir = homeDir + "/Projects/hanze-distributed-applications/week-3/OLA/data";
        String dataFile = dataDir + "/acceptgirodata.txt";

        String inputDir = dataDir + "/input";
        String outputDir = dataDir + "/output";
        String metaDir = dataDir + "/meta";

        AcceptGiroProcessor processor = new AcceptGiroProcessor(inputDir, outputDir, metaDir);
        processor.process();

//        AcceptGiro acceptGiro = new AcceptGiro(1, 123, 5,
//                "0000000000000000", "P765672",
//                AcceptGiro.Geslacht.MAN, "R", "Pipo",
//                "Scheen", "44", "9999 HW", "Gramingen",
//                "987654", "Flipje Betuwe");
//
//        System.out.println(acceptGiro);
//
////        AcceptGiroPdf pdf = new AcceptGiroPdf(dataDir, dataDir, acceptGiro);
////        pdf.createFile();
//
//        AcceptGiroFileReader reader = new AcceptGiroFileReader(dataFile);
    }
}
