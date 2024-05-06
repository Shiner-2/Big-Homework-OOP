package com.example.hhd;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WordleController implements Initializable {
    @FXML
    private Button btn;
    @FXML
    private VBox WordleContainer;
    @FXML
    private TextField WordleInput;
    private Integer sz = 5;
    private String HiddenWord = "DOGGY";
    //private TrieDictionary trie = new TrieDictionary();
    private Integer GuessCount = 0;

    public void LoadGames(Event event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Games.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Games");
        stage.setScene(scene);
        stage.show();
    }

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
            //TODO: Contains làm ntn ???
//            if(!trie.contains(in)) {
//                WordleWordController lt = new WordleWordController(getSz());
//                lt.setWord(in, HiddenWord);
//                WordleContainer.getChildren().add(lt);
//                GuessCount++;
//            } else{
//                Alert a = new Alert(Alert.AlertType.ERROR);
//                a.setTitle("Error");
//                a.setHeaderText("Invalid Word");
//                a.setContentText("Please enter an English word");
//                a.show();
//            }
        }

        if(GuessCount >= 5) {
            WordleInput.setDisable(true);
            btn.setDisable(true);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("You lose");
            a.setHeaderText("Noob");
            a.setContentText("Better luck next time");
            a.show();
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
