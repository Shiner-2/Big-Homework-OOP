package com.example.hhd;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class WordleWordController extends VBox {
    @FXML
    private HBox WordleWordContainer;
    private Integer sz;

    public WordleWordController(Integer sz) {
        this.sz = sz;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "wordle-word.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    public void setWord(String s) {
        for(int i = 0 ; i < sz; i++) {
            WordleLetterController lt = new WordleLetterController();
            lt.setLetter(String.valueOf(s.charAt(i)));
            WordleWordContainer.getChildren().add(lt);
        }
    }
}
