package com.example.hhd;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.io.File;

public class TrieDictionary extends Dictionary {

    private final Trie trie = new Trie();

    public TrieDictionary() {

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
        return trie.search_word(target, 10);
    }

    @Override
    public boolean contains(String s) {
        return trie.find_word(s);
    }
}