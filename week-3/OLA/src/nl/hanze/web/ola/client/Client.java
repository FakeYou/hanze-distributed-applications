package nl.hanze.web.ola.client;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Client {
    public static void main(String[] args) throws IOException {

        OLAFile olaFile = new OLAFile(19, 56, 51,
                "1111333355557777", "P161486",
                "M", "AG", "Nanninga",
                "Testweg", "12", "9439 HW", "Achterwoude",
                "987654", "Flipje Betuwe");

        String server = "192.168.55.2";

        FTPClient ftp = new FTPClient();
        ftp.connect(server);
        ftp.enterLocalPassiveMode();
        ftp.setFileType(FTP.BINARY_FILE_TYPE);

        System.out.println("Connected to " + server + ".");
        System.out.print(ftp.getReplyString());

        InputStream inputStream = olaFile.getInputStream();
        System.out.println("uploading file");
        boolean done = ftp.storeFile("input/" + olaFile.getRef() + ".ola", inputStream);
        inputStream.close();

        if(done) {
            System.out.println("uploaded file");
        }
        else {
            System.out.println("upload failed");
        }

    }
}
