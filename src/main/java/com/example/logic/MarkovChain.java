package com.example.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovChain {

    private HashMap<String, ArrayList<String>> markovChain1 = new HashMap<>();
    private HashMap<String, ArrayList<String>> markovChain2 = new HashMap<>();

    private final String[] words;
    public MarkovChain(String[] words) {
        this.words = words;
        markovChain1 = trainMarkovChain1(words);
        markovChain2 = trainMarkovChain2(words);
    }
    private HashMap<String, ArrayList<String>> trainMarkovChain1(String[] words) {
        HashMap<String, ArrayList<String>> markovChain = new HashMap<>();
        String lastWord = "";

        for (String word : words) {
            if (!markovChain.containsKey(lastWord)) {
                markovChain.put(lastWord, new ArrayList<>());
            }
            markovChain.get(lastWord).add(word);
            lastWord = word;
        }

        return markovChain;
    }

    private HashMap<String, ArrayList<String>> trainMarkovChain2(String[] words) {
        HashMap<String, ArrayList<String>> markovChain = new HashMap<>();
        String lastWord = "";
        String lastLastWord = "";

        for (String word : words) {
            if (!markovChain.containsKey(lastLastWord + " " + lastWord)) {
                markovChain.put(lastLastWord + " " + lastWord, new ArrayList<>());
            }
            markovChain.get(lastLastWord + " " + lastWord).add(word);
            lastLastWord = lastWord;
            lastWord = word;
        }

        return markovChain;
    }

    public String generateMarkovChain1(int count) {

        Random random = new Random();
        String lastWord = words[random.nextInt(words.length)];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(lastWord).append(" ");
            if (!markovChain1.containsKey(lastWord)) {
                lastWord = words[random.nextInt(words.length)];
            }else {
                ArrayList<String> nextWords = markovChain1.get(lastWord);
                lastWord = nextWords.get(random.nextInt(nextWords.size()));
            }
        }

        return result.toString();
    }

    public String generateMarkovChain2(int count) {

        Random random = new Random();
        String lastWord = words[random.nextInt(words.length)];
        String lastLastWord = markovChain1.get(lastWord).get(random.nextInt(markovChain1.get(lastWord).size()));
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(lastWord).append(" ");
            if (!markovChain2.containsKey(lastLastWord + " " + lastWord)) {
                lastWord = words[random.nextInt(words.length)];
                lastLastWord = markovChain1.get(lastWord).get(random.nextInt(markovChain1.get(lastWord).size()));
            }else{
                ArrayList<String> nextWords = markovChain2.get(lastLastWord + " " + lastWord);
                lastLastWord = lastWord;
                lastWord = nextWords.get(random.nextInt(nextWords.size()));
            }
        }

        return result.toString();
    }

}
