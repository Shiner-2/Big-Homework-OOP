package com.example.hhd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class DictionaryController implements Initializable {

    Dictionary trie;

    @FXML
    private TextField userInputWord;

    @FXML
    private ListView<Word> recommendWord;

    @FXML
    private AnchorPane showWordPane;

    private TextFlow wordDefinition = new TextFlow();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            trie = new TrieDictionary(new File("src/main/resources/data/anhviet109K.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
        recommendWord.setCellFactory(param -> new ListCell<Word>() {
            @Override
            protected void updateItem(Word item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getWord() == null) {
                    setText(null);
                } else {
                    setText(item.getWord());
                }
            }
        });
    }

    // TODO: replace words as a Initialize List from Data
    ArrayList<String> words = new ArrayList<>(
            Arrays.asList("test", "dog","Human", "lmao", "Fucked",
                    "Friends", "Animal", "Human", "Humans", "Bear", "Life",
                    "KYS", "Words", "222", "Bird", "Dog", "Shitt",
                    "Subscribe!", "SoftwareEngineeringStudent", "Asssssss",
                    "Keenie", "Super", "Like")
    );

    //TODO: replace searchWords function to find word more efficient
    private ArrayList<Word> searchWords(String inputText){
//        ArrayList<String> ans = new ArrayList<>();
//        for (String s: words){
//            if(s.contains(inputText)){
//                ans.add(s);
//            }
//        }

//        ArrayList<Word> word = trie.search(inputText);
//
//        ArrayList<String> ans = new ArrayList<>();
//        for (Word w : word) {
//            ans.add(w.getWord());
//        }
//
//        return ans;

        return trie.search(inputText);
    }

    private Stage stage;
    public void LoadApp(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Dictionary.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        scene.getStylesheets().add(this.getClass().getResource("/styles.css").toExternalForm());

        stage.setTitle("HHD");
        stage.setScene(scene);
        stage.show();
    }

    public void handleMouseClick(MouseEvent mouseEvent) throws IOException {
        System.out.println(recommendWord.getSelectionModel().getSelectedItem());

        Word currentWord = recommendWord.getSelectionModel().getSelectedItem();
        showWordPane.getChildren().clear();
        wordDefinition.getChildren().clear();
        showWordDefinition(currentWord);
        showWordPane.getChildren().add(wordDefinition);
    }

    public void showWord(String word) {
        System.out.println(word); // bold + header font

        Text tx = new Text(word + "\n");
        tx.setStyle("-fx-font: 20px \"arial,sans-serif\";");
        wordDefinition.getChildren().add(tx);
    }

    public void showPronunciation(String pronunciation) {
        System.out.println(pronunciation); // sound button

        Text tx = new Text(pronunciation + "\n");
        tx.setStyle("-fx-font: 14px \"arial,sans-serif\";");
        wordDefinition.getChildren().add(tx);

    }

    public void showType(String type) {
        System.out.println(type); // italic type

        Text tx = new Text(type + "\n");
        tx.setStyle("-fx-font: italic 14px \"arial,sans-serif\";");
        wordDefinition.getChildren().add(tx);
    }

    public void showMeaning(String meaning, int index) {
        System.out.println("\t" + index + ". " + meaning);

        Text tx = new Text("\t" + index + ". " + meaning + "\n");
        tx.setStyle("-fx-font: 14px \"arial,sans-serif\";");
        wordDefinition.getChildren().add(tx);
    }

    public void showExample(String example, String meaning) {
        System.out.println("\t\tex. " + example + " : " + meaning);

        Text tx = new Text("\t\tex. " + example + " : " + meaning + "\n");
        tx.setStyle("-fx-font: 12px \"arial,sans-serif\";");
        wordDefinition.getChildren().add(tx);
    }

    public void showPhrase(String phrase) {
        System.out.println("phrase: " + phrase);

        Text tx = new Text("phrase: " + phrase + "\n");
        tx.setStyle("-fx-font: 14px \"arial,sans-serif\";");
        wordDefinition.getChildren().add(tx);
    }

    public void showWordDefinition(Word Eword) {
        if (Eword == null) return ;
        String word = Eword.getWord(), definition = Eword.getDefinition();

        List<String> lines = new ArrayList<>(List.of(definition.split("\n")));

//        System.out.println(definition);
        showWord(word);

        for (int i = 0, countMeaning = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            switch (line.charAt(0)) {
                case '@': // word
                    if (line.charAt(line.length() - 1) == '/') {
                        // pronunciation
                        showPronunciation(line.substring(line.indexOf('/')));
                    }
                    break;
                case '!':
                    countMeaning = 0;
                    showPhrase(line.substring(1).strip());
                    break;
                case '*': // type
                    countMeaning = 0; // number of meaning in same type
                    showType(line.substring(1).strip());
                    break;
                case '-': // meaning
                    if (line.charAt(1) == ' ') {
                        showMeaning(line.substring(1).strip(), ++ countMeaning);
                    }
                    // else malformed input
                    break;
                case '=': // example
                    int separator = line.indexOf('+');
                    String example = line.substring(1, separator);
                    String meaning = line.substring(separator + 1);
                    showExample(example, meaning);
                    break;
                default:
//                    malformed input
//                    System.out.println(line);
//                    throw new RuntimeException("can't read word definition, wrong format!");
            }
        }
    }
}