package com.example.hhd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuizGameController implements Initializable {
    QuizGame gameData;

    @FXML
    private Label question;
    @FXML
    private Button choiceA, choiceB, choiceC, choiceD;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            gameData = new QuizGame();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setQuestion();
    }

    private int questionCounter = 0;
    private int score = 0;
    private static final int questionMax = 10;

    public void initGame() {
        gameData.setGame();
    }
    Question currentQuestion;
    public void setQuestion() {
        ++ questionCounter;
        Question q = gameData.getQuestion();
        currentQuestion = q;
        question.setText(q.getQuestion());
        question.setWrapText(true);
        String[] choices = q.getChoices();
        choiceA.setText(choices[0]);
        choiceB.setText(choices[1]);
        choiceC.setText(choices[2]);
        choiceD.setText(choices[3]);
    }

    @FXML
    public void handleChoiceA(ActionEvent event) {
        if (choiceA.getText().equals(currentQuestion.getAnswer())) {
            System.out.println("Correct answer");
            score ++;
        } else {
            System.out.println("Wrong answer");
        }
        setQuestion();
    }

    @FXML
    public void handleChoiceB(ActionEvent event) {
        if (choiceB.getText().equals(currentQuestion.getAnswer())) {
            System.out.println("Correct answer");
            score ++;
        } else {
            System.out.println("Wrong answer");
        }
        setQuestion();
    }

    @FXML
    public void handleChoiceC(ActionEvent event) {
        if (choiceC.getText().equals(currentQuestion.getAnswer())) {
            System.out.println("Correct answer");
            score ++;
        } else {
            System.out.println("Wrong answer");
        }
        setQuestion();
    }

    @FXML
    public void handleChoiceD(ActionEvent event) {
        if (choiceD.getText().equals(currentQuestion.getAnswer())) {
            System.out.println("Correct answer");
            score ++;
        } else {
            System.out.println("Wrong answer");
        }
        setQuestion();
    }
}