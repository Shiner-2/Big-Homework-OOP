package com.example.hhd;

import java.io.File;
import java.util.ArrayList;

public class DatabaseDictionary extends Dictionary {
    public DatabaseDictionary() {

    }

    public DatabaseDictionary(File file) {
        import_from_file(file);
    }

    private void import_from_file(File file) {

    }

    @Override
    public void insert(Word word) {

    }

    @Override
    public boolean delete(Word word) {
        return false;
    }

    @Override
    public ArrayList<Word> search(String target) {
        return new ArrayList<>();
    }

    @Override
    public boolean contains(String word_target) {
        return false;
    }
}
