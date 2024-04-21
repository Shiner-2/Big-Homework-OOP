package com.example.hhd;

import kotlin.text.Charsets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Helper {
    /**
     * Get file extension
     * @param file .
     * @return file extension
     */
    public static String get_extension(File file) {
        if (file.isDirectory()) {
            return ""; // no extension
        }
        String name = file.getName();
        int pos = name.lastIndexOf('.');

        if (pos >= 0) {
            return name.substring(pos + 1);
        }
        return ""; // no extension
    }

    /**
     * Get word from lines.
     * @param lines : the lines
     * @return word
     */
    public static Word getWordFromLines(List<String> lines) {
        if (lines.isEmpty()) {
            return null;
        }

        String word = "";
        for (int i = 1; i < lines.get(0).length(); i++) {
            if (lines.get(0).charAt(i) == ' ')
                break;
            word += lines.get(0).charAt(i);
        }

        return new Word(word, String.join("\n", lines));
    }

    public static void showWord(String word) {
        System.out.println(word); // bold + header font
    }

    public static void showPronunciation(String pronunciation) {
        System.out.println(pronunciation); // sound button
    }

    public static void showType(String type) {
        System.out.println(type); // italic type
    }

    public static void showMeaning(String meaning, int index) {
        System.out.println("\t" + index + ". " + meaning);
    }

    public static void showExample(String example, String meaning) {
        System.out.println("\t\tex. " + example + " : " + meaning);
    }

    public static void showWordDefinition(Word Eword) {
        String word = Eword.getWord(), definition = Eword.getDefinition();

        List<String> lines = new ArrayList<>(List.of(definition.split("\n")));

        System.out.println(definition);
        showWord(word);

        for (int i = 0, count_meaning = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            switch (line.charAt(0)) {
                case '@': // word
                    if (line.charAt(line.length() - 1) == '/') {
                        // pronunciation
                        showPronunciation(line.substring(line.indexOf('/')));
                    }
                    break;
                case '*': // type
                    count_meaning = 0; // number of meaning in same type
                    showType(line.substring(1).strip());
                    break;
                case '-': // meaning
                    showMeaning(line.substring(1).strip(), ++ count_meaning);
                    break;
                case '=': // example
                    int separator = line.indexOf('+');
                    String example = line.substring(1, separator - 1);
                    String meaning = line.substring(separator + 1);
                    showExample(example, meaning);
                    break;
                default:
                    System.out.println(line);
                    throw new RuntimeException("can't read word definition, wrong format!");
            }
        }
    }

    public static List<Word> getWordFromFile(File file) throws IOException {
        List<Word> result = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        for (String line : Files.readAllLines(Path.of(file.getPath()), Charsets.UTF_8)) {
            lines.add(line);
            if (line.isEmpty()) {
                Word w = getWordFromLines(lines);
                if (w != null) {
                    result.add(w);
                }
                lines.clear();
            }
        }

//        System.out.println(result.get(0).getWord());
//        System.out.println(result.get(0).getDefinition());
        return result;
    }

    public static ArrayList<String> getRecentWord(File file) {
        return new ArrayList<>();
    }
}
