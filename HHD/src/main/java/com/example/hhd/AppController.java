package com.example.hhd;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Arrays;

public class AppController{
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
}