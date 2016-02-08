package nl.hanze.web.ola;

import java.util.Timer;
import java.util.TimerTask;

public class AcceptGiroRunner {
    public static void main(String[] args) throws Exception {
        String homeDir = System.getProperty("user.home");
        String dataDir = homeDir + "/Projects/hanze-distributed-applications/week-3/OLA/data";
        String inputDir = dataDir + "/input";
        String outputDir = dataDir + "/output";
        String metaDir = dataDir + "/meta";

        new AcceptGiroRunner(inputDir, outputDir, metaDir, 10 * 1000);
    }

    public AcceptGiroRunner(String inputDir, String outputDir, String metaDir, int interval) {

        AcceptGiroProcessor processor = new AcceptGiroProcessor(inputDir, outputDir, metaDir);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Running AcceptGiroProcessor");

                try {
                    processor.process();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(task, 0, interval);
    }
}
