package com.example.hhd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Dictionary {
    public Dictionary getDictionary_from_file(File file) throws IOException {
        if (Helper.get_extension(file).equals("txt")) {
            return new TrieDictionary(file);
        }
        if (Helper.get_extension(file).equals(".sql")) {
            return new DatabaseDictionary(file);
        }
        assert(false);
        return new Dictionary() { // empty
            @Override
            public void insert(Word word) {

            }

            @Override
            public boolean delete(Word word) {
                return false;
            }

            @Override
            public ArrayList<Word> search(String target) {
                return null;
            }

            @Override
            public boolean contains(String word_target) {
                return false;
            }
        };
    }

    public abstract void insert(Word word);

    public abstract boolean delete(Word word);

    public abstract ArrayList<Word> search(String target);

    public abstract boolean contains(String word_target);
}
