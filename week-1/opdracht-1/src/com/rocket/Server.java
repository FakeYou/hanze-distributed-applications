package com.rocket;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
        TRANSLATETOENGLISH,
        TRANSLATETODUTCH
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

    private String translateEnglishToDutch(String input) {
        String[] words = input.split(" ");
        ArrayList<String> result = new ArrayList<String>();

        for(String word : words) {
            String translation = "[" + word + "]";

            for(String[] dictionary : Server.translations) {
                if(dictionary[0].equals(word.toLowerCase())) {
                    translation = dictionary[1];
                }
            }

            result.add(translation);
        }

        return StringUtils.join(result, " ");
    }

    private String translateDutchToEnglish(String input) {
        String[] words = input.split(" ");
        ArrayList<String> result = new ArrayList<String>();

        for(String word : words) {
            String translation = "[" + word + "]";

            for(String[] dictionary : Server.translations) {
                if(dictionary[1].equals(word.toLowerCase())) {
                    translation = dictionary[0];
                }
            }

            result.add(translation);
        }

        return StringUtils.join(result, " ");
    }

    private String protocol() {
        return this.protocol("");
    }

    private String protocol(String input) {
        String output;

        switch(this.state) {
            case WAITING:
                if(input.toLowerCase().equals("dutch")) {
                        output = "ready to translate from dutch to english.";
                        this.state = State.TRANSLATETODUTCH;
                    }
                else if(input.toLowerCase().equals("english")) {
                    output = "ready to translate from english to dutch.";
                    this.state = State.TRANSLATETOENGLISH;
                }
                else {
                    output = "Do you want to translate from dutch or english? (type SWITCH to switch languages)";
                }

                break;
            case TRANSLATETODUTCH:
                if(input.equals("SWITCH")) {
                    this.state = State.WAITING;
                    output = "Do you want to translate from dutch or english? (type SWITCH to switch languages)";
                }
                else {
                    output = this.translateDutchToEnglish(input);
                }

                break;
            case TRANSLATETOENGLISH:
                if(input.equals("SWITCH")) {
                    this.state = State.WAITING;
                    output = "Do you want to translate from dutch or english? (type SWITCH to switch languages)";
                }
                else {
                    output = this.translateEnglishToDutch(input);
                }

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
