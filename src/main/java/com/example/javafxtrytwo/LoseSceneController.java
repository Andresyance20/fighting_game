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
    private Hero playerHero1;
    private Hero playerHero2;
    private Hero playerHero3;
    private Hero playerActiveHero;
    private Hero heroAI;

    public void setToMainMenu(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai) {
        mainScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
    }

    public void setToFightScene(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai) {
        fightScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
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
