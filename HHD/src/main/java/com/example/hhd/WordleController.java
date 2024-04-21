package com.example.hhd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class WordleController implements Initializable {
    @FXML
    private VBox WordleContainer;
    @FXML
    private TextField WordleInput;
    private Integer sz = 5;

    public void onWordleBtnSubmit() {
        String in = WordleInput.getText();
        in = in.toUpperCase();
        if(in.length() != sz) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Too much letters");
            a.setContentText("Please enter " + sz.toString() + " letters!");
            a.show();
        } else{
            WordleWordController lt = new WordleWordController(getSz());
            lt.setWord(in);
            WordleContainer.getChildren().add(lt);
        }
    }

    public void setSz(Integer sz) {
        this.sz = sz;
    }

    public Integer getSz() {
        return sz;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
