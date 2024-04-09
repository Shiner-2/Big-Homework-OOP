package com.example.hhd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DictionaryController {
    @FXML
    private TextField userInputWord;

    @FXML
    private ListView<String> recommendWord;
    @FXML
    private void onUserTyping(){
        String inputText = userInputWord.getText();
        StringBuilder queryText = new StringBuilder();
        for(int i = 0; i < inputText.length(); i++) {
            if(inputText.charAt(i)!=' '){
                queryText.append(inputText.charAt(i));
            }
        }
        // TODO: pass queryText into some search function
        recommendWord.getItems().clear();
        recommendWord.getItems().addAll(searchWords(queryText.toString()));
    }

    // TODO: replace words as a Intilize List from Data
    ArrayList<String> words = new ArrayList<>(
            Arrays.asList("test", "dog","Human", "lmao", "Fucked",
                    "Friends", "Animal", "Human", "Humans", "Bear", "Life",
                    "KYS", "Words", "222", "Bird", "Dog", "Shitt",
                    "Subscribe!", "SoftwareEngineeringStudent", "Asssssss",
                    "Keenie", "Super", "Like")
    );

    //TODO: replace searchWords function to find word more efficient
    private ArrayList<String> searchWords(String inputText){
        ArrayList<String> ans = new ArrayList<>();
        for (String s: words){
            if(s.contains(inputText)){
                ans.add(s);
            }
        }
        return ans;
    }

    public void LoadApp(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("App.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("HHD");
        stage.setScene(scene);
        stage.show();
    }
}