
import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private static String[][] translations = {
        {"hello", "hallo"},
        {"house", "huis"},
        {"car", "auto"},
        {"tree", "boom"},
        {"dog", "hond"},
        {"bomb", "bom"},
        {"refrigerator", "koelkast"},
        {"cow", "koe"},
        {"water", "water"},
        {"bike", "fiets"}
    };

    private enum State {
        IDLE
    };

    private State state;
    private ServerSocket socket;

    public Server(int port) {
        this.state = State.IDLE;

        try {
            this.socket = new ServerSocket(port);
            System.out.println("Started server on port: " + port);
        } catch (IOException e) {
            System.out.println("Couldn't open server socket on " + port);
            System.exit(0);
        }
    }

    public static void Main() {
        new Server(4000);
    }
}

