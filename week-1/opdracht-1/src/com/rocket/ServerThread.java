package com.rocket;

import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
    private Socket socket = null;
    private Protocol protocol;
    private PrintWriter out;
    private BufferedReader in;

    public ServerThread(Socket socket) {
        super("ServerThread");
        this.socket = socket;
    }

    public void run() {
        this.protocol = new Protocol();
        this.protocol.state = Protocol.State.WAITING;

        try {
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println(this.protocol.protocol());

            String input;
            while((input = this.in.readLine()) != null) {
                if(this.protocol.state == Protocol.State.CLOSING) {
                    socket.close();
                    break;
                }

                out.println(this.protocol.protocol(input));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
