package com.rocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader consoleIn;

    public Client(String address, int port) {
        try {
            this.socket = new Socket(address, port);
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            this.consoleIn = new BufferedReader(new InputStreamReader(System.in));

            String response;
            String request;

            System.out.println("Connecting to server " + address + ":" + port);

            while((response = in.readLine()) != null) {
                System.out.println("Server: " + response);

                request = this.consoleIn.readLine();
                if(request != null) {
                    System.out.println("Client: " + request);
                    out.println(request);
                }
            }

        } catch (IOException e) {
            System.out.println("Could not connect to server " + address + ":" + port);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Client("localhost", 4000);
    }
}
