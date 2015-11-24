package com.rocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    private Socket clientSocket;

    public Server(int port) {

        System.out.println("Starting server");
        boolean listening = true;

        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Started server on port: " + port);
            while (listening) {
                new ServerThread(clientSocket = serverSocket.accept()).start();
            }

        } catch (IOException e) {
            System.out.println("Couldn't open server socket on " + port);
            System.exit(-1);
        }

    }

    public static void main(String[] args) {
        new Server(4000);
    }
}
