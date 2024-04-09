package com.example.hhd;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;



    public void LoadDictionary(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        fxmlLoader = new FXMLLoader(App.class.getResource("Dictionary.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public void LoadScrabble(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        fxmlLoader = new FXMLLoader(App.class.getResource("Scrabble.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Scrabble Game");
        stage.setScene(scene);
        stage.show();
    }
}
