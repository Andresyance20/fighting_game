package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoseSceneController {
    private Scene mainScene;
    private Scene fightScene;
    private Hero hero1;

    public void setToMainMenu(Scene scene, Hero hero) {
        mainScene = scene;
        hero1 = hero;
    }

    public void setToFightScene(Scene scene, Hero hero) {
        fightScene = scene;
        hero1 = hero;
    }

    public void openMainMenu(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
    }

    public void openFightScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(fightScene);
    }

    public Button button_losetomenu;
    public Button button_retry;
}
