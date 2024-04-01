package com.example.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadFile {
    public static String[] readWordsFromFile(String fileName) {
        List<String> wordList = new ArrayList<>();

        fileName = "src/main/resources/" + fileName;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] wordsInLine = line.split("\\s+"); // Split line into words
                Collections.addAll(wordList, wordsInLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert List<String> to String[]
        String[] wordsArray = new String[wordList.size()];
        return wordList.toArray(wordsArray);
    }

}