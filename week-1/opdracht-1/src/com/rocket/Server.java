package com.rocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
            {"bike", "fiets"},
            {"i", "ik"},
            {"am", "ben"},
            {"a", "een"},
    };

    private enum State {
        WAITING,
        TRANSLATESENTENCE,
        TRANSLATEWORD
    };

    private State state;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Server(int port) {
        this.state = State.WAITING;

        System.out.println("Starting server");

        try {
            this.serverSocket = new ServerSocket(port);
            this.clientSocket = serverSocket.accept();

            System.out.println("Started server on port: " + port);

            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println(this.protocol());

            String input;
            while((input = this.in.readLine()) != null) {
                out.println(this.protocol(input));
            }

            this.out.println("hello world");
            this.clientSocket.close();

        } catch (IOException e) {
            System.out.println("Couldn't open server socket on " + port);
            System.exit(0);
        }

    }

    private String translateWord(String word) {
        String result = "[" + word + "]";

        for(String[] translation : Server.translations) {
            if(translation[0].equals(word.toLowerCase())) {
                result = translation[1];
            }
        }

        return result;
    }

    private String translateSentence(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";

        for(String word : words) {
            result += this.translateWord(word) + " ";
        }

        return result.trim();
    }

    private String protocol() {
        return this.protocol("");
    }

    private String protocol(String input) {
        String output;

        switch(this.state) {
            case WAITING:
                if(input.toLowerCase().equals("sentence")) {
                    output = "ready to translate a sentence";
                    this.state = State.TRANSLATESENTENCE;
                }
                else if(input.toLowerCase().equals("word")) {
                    output = "ready to translate a word";
                    this.state = State.TRANSLATEWORD;
                }
                else {
                    output = "Do you want to translate a word or sentence";
                }

                break;
            case TRANSLATEWORD:
                output = this.translateWord(input);
                this.state = State.WAITING;
                break;
            case TRANSLATESENTENCE:
                output = this.translateSentence(input);
                this.state = State.WAITING;
                break;
            default:
                output = "error";
        }

        return output;
    }

    public static void main(String[] args) {
        new Server(4000);
    }
}
