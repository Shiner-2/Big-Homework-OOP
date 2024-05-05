package com.example.hhd;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class TrieDictionary extends Dictionary {

    private final Trie trie = new Trie();

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
}
