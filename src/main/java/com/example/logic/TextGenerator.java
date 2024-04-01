package com.example.logic;

public class TextGenerator {

    String[] hamletWords = ReadFile.readWordsFromFile("norm_hamlet.txt");
    String[] romeoWords = ReadFile.readWordsFromFile("norm_romeo.txt");
    String[] wikiWords = ReadFile.readWordsFromFile("norm_wiki_sample.txt");

    private final MarkovChain hamletChain = new MarkovChain(hamletWords);
    private final MarkovChain romeoChain = new MarkovChain(romeoWords);
    private final MarkovChain wikiChain = new MarkovChain(wikiWords);

    public TextGenerator() {}

    public String GetRandomText(String source, int length) {
        String text = "";
        switch (source) {
            case "hamlet" -> text = hamletChain.generateMarkovChain2(length);
            case "romeo" -> text = romeoChain.generateMarkovChain2(length);
            case "wiki" -> text = wikiChain.generateMarkovChain2(length);
        }
        return text;
    }
}
