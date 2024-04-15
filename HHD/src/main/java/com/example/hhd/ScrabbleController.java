package com.example.hhd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ScrabbleController {
    @FXML
    private ImageView box1, box2, box3, box4, box5, box6, box7;

    private ArrayList<ImageView> boxes = new ArrayList<>();

    public void initialize() throws FileNotFoundException {
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
        boxes.add(box4);
        boxes.add(box5);
        boxes.add(box6);
        boxes.add(box7);
        startGame();
    }

    @FXML
    private void startGame() throws FileNotFoundException {
        for(ImageView i : boxes){
            String path = String.format("C:\\Users\\pnhd2\\Desktop\\OOP-UET\\Baitaplon\\Big-Homework-OOP\\HHD\\src\\main\\resources\\Scrabble\\Image\\PNG\\Blue\\letter_%c.png",getRandomTile());
            FileInputStream fis = new FileInputStream(path);
            Image img = new Image(fis);
            i.setImage(img);
        }
    }

    private char getRandomTile() {
        Random random = new Random();
        int num = random.nextInt(26) + 65;
        return (char)num;
    }

    public static void main(String[] args) {
        ScrabbleController sc = new ScrabbleController();
        System.out.println(sc.getRandomTile());
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

