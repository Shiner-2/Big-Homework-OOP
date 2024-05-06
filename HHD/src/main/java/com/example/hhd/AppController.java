package com.example.hhd;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    public void LoadGames(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        fxmlLoader = new FXMLLoader(App.class.getResource("Games.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Games");
        stage.setScene(scene);
        stage.show();
    }

    public void LoadDictionary(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        fxmlLoader = new FXMLLoader(App.class.getResource("Dictionary.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public void LoadTranslator(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        fxmlLoader = new FXMLLoader(App.class.getResource("Translator.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Translator");
        stage.setScene(scene);
        stage.show();
    }
}
