package com.example.hhd;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EditWordViewController implements Initializable {
    @FXML
    private TextArea UserWordEnteredEdit;
    @FXML
    private TextArea UserDefinationEnteredEdit;

    Dictionary data = new TrieDictionary();
    String word = "";
    Word ww = new Word("k","k");

    public EditWordViewController() throws IOException {
        File myObj = new File("src/main/resources/data/temp.txt");
        Scanner myReader = new Scanner(myObj);
        word = myReader.nextLine();
        word = word.toLowerCase();
        Word w = new Word("hello","bye");

        ArrayList<Word> arr = new ArrayList<>();
        arr = data.search(word);

        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).getWord().equals(word)){
                w = arr.get(i);
                break;
            }
        }

        ww = w;
    }

    @FXML
    public void onSubmitEdit(Event event) {
        Word nw = new Word("","");
        nw.setWord(UserWordEnteredEdit.getText());
        nw.setDefinition(UserDefinationEnteredEdit.getText());
        System.out.println(data.contains(nw.getWord()));
        data.delete(nw);
        System.out.println(data.contains(nw.getWord()));
        data.insert(nw);
        System.out.println(data.contains(nw.getWord()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserWordEnteredEdit.setText(ww.getWord());
        UserWordEnteredEdit.setDisable(true);
        UserDefinationEnteredEdit.setText(ww.getDefinition());
    }
}
