package com.rocket;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;

/**
 * Created by Lasse on 17-11-2015.
 */
public class Protocol {
    public State state;

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

    public enum State {
        WAITING,
        TRANSLATETOENGLISH,
        TRANSLATETODUTCH,
        CLOSING
    }

    public String translateEnglishToDutch(String input) {
        String[] words = input.split(" ");
        ArrayList<String> result = new ArrayList<String>();

        for(String word : words) {
            String translation = "[" + word + "]";

            for(String[] dictionary : translations) {
                if(dictionary[0].equals(word.toLowerCase())) {
                    translation = dictionary[1];
                }
            }

            result.add(translation);
        }

        return StringUtils.join(result, " ");
    }

    public String translateDutchToEnglish(String input) {
        String[] words = input.split(" ");
        ArrayList<String> result = new ArrayList<String>();

        for(String word : words) {
            String translation = "[" + word + "]";

            for(String[] dictionary : translations) {
                if(dictionary[1].equals(word.toLowerCase())) {
                    translation = dictionary[0];
                }
            }

            result.add(translation);
        }

        return StringUtils.join(result, " ");
    }

    public String protocol() {
        return this.protocol("");
    }

    public String protocol(String input) {
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
                else if(input.equals("EXIT")) {
                    output = "bye";
                    this.state = state.CLOSING;
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
}
