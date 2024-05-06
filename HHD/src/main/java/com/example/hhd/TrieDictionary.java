package com.example.hhd;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Random;

public class TrieDictionary extends Dictionary {

    private final Trie trie = new Trie();
    private Random rand = new Random();

    public TrieDictionary() throws IOException {
        File file = new File("src/main/resources/data/anhviet109K.txt");
        import_from_file(file);
    }

    public TrieDictionary(File file) throws IOException {
        import_from_file(file);
    }

    public void import_from_file(File file) throws IOException {
        for (Word w : Helper.getWordFromFile(file)) {
            insert(w);
        }
    }

    @Override
    public void insert(Word word) {
        trie.insert_word(word);
    }

    @Override
    public boolean delete(Word word) {
        return trie.delete_word(word);
    }

    @Override
    public ArrayList<Word> search(String target) {
        return trie.search_word(target, 20);
    }

    public ArrayList<Word> allWordList() {
        return trie.search_all_word("");
    }
    @Override
    public boolean contains(String s) {
        return trie.find_word(s);
    }

    @Override
    public Word randomWord() {
        ArrayList<Word> allWord = allWordList();
        ArrayList<Word> words = new ArrayList<>();

        for (Word w : allWord) {
            if (w.getWord().chars().allMatch(Character::isLetter)) {
                words.add(w);
            }
        }

        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public Word randomWord(int length) {
        ArrayList<Word> allWord = allWordList();
        ArrayList<Word> words = new ArrayList<>();

        for (Word w : allWord) {
            if (w.getWord().chars().allMatch(Character::isLetter) && w.getWord().length() == length) {
                words.add(w);
            }
        }

        return words.get(rand.nextInt(words.size()));
    }
}
