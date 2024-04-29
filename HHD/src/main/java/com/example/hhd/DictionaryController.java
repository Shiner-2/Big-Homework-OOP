package com.example.hhd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class DictionaryController implements Initializable {
    @FXML
    private TextField userInputWord;
    @FXML
    private ListView<String> recommendWord;
    @FXML
    private Label definition;
    private ArrayList<Word> arr = new ArrayList<>();
    Dictionary data;

    @FXML
    private void onUserTyping(){
        String inputText = userInputWord.getText();
        arr = data.search(inputText);
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0 ; i < arr.size(); i++){
            ans.add(arr.get(i).getWord());
        }
        recommendWord.getItems().clear();
        recommendWord.getItems().addAll(ans);
        recommendWord.setOnMouseClicked(event -> {
            String selected = recommendWord.getSelectionModel().getSelectedItem();
            showdefinition(selected);
        });
    }

    private void showdefinition(String word) {
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getWord().equals(word)) {
                definition.setText(arr.get(i).getDefinition());
                return;
            }
        }
    }


    public void LoadApp(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("App.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("HHD");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            data = new TrieDictionary();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}