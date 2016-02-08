package nl.hanze.web.ola;

import java.io.File;

public class AcceptGiroProcessor {

    private String inputDir;
    private String outputDir;
    private String metaDir;

    public AcceptGiroProcessor(String inputDir, String outputDir, String metaDir) {
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        this.metaDir = metaDir;
    }

    public void process() throws Exception {
        File[] files = new File(inputDir).listFiles();

        AcceptGiroPdf pdf = new AcceptGiroPdf(metaDir, outputDir);
        AcceptGiroFileRemover remover = new AcceptGiroFileRemover(inputDir);

        for (File file : files) {
            if(file.isFile() && getFileExtension(file).toLowerCase().equals("ola")) {

                System.out.println("[processor] found file " + file.getName());
                try {
                    AcceptGiro acceptGiro = AcceptGiroFileReader.readOla(file.getAbsolutePath());
                    System.out.println("[processor] extracted acceptgiro data");
                    System.out.println(acceptGiro);

                    System.out.println("[processor] creating .pdf");
                    pdf.createPdf(acceptGiro);
                }
                catch (Exception e) {
                    System.out.println("[processor] Something went wrong");
                    System.out.println("[error] " + e.getMessage());
                }
                finally {
                    System.out.println("[processor] removing .ola file");
                    remover.remove(file.getName());
                }
            }
        }
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
}
