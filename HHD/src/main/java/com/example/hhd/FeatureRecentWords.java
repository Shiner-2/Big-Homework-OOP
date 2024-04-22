package com.example.hhd;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FeatureRecentWords {
    private List<String> wordList;
    private Set<String> wordSet;

    public FeatureRecentWords() {
        wordList = new ArrayList<>();
        wordSet = new HashSet<>();
    }

    public void insert(String word) {
        if (wordSet.contains(word)) {
            wordList.remove(word);
        }
        wordList.add(word);
        wordSet.add(word);

        if (wordList.size() > 100) {
            String removedWord = wordList.remove(0);
            wordSet.remove(removedWord);
        }
    }

    public void importFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                insert(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportToFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String word : wordList) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> search(String prefix) {
        List<String> result = new ArrayList<>();
        for (String word : wordList) {
            if (word.startsWith(prefix)) {
                result.add(word);
            }
        }
        return result;
    }
}
