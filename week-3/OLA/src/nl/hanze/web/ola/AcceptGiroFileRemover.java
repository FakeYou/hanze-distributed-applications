package nl.hanze.web.ola;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AcceptGiroFileRemover {
    private String baseDir;

    public AcceptGiroFileRemover(String baseDir) {
        this.baseDir = baseDir;
    }

    public void remove(String filename) {
        File file = new File(baseDir + "/" + filename);
        file.delete();
    }
}
