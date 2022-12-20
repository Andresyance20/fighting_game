package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ResultController {

    private Scene mainScene;
    private Scene fightScene;

    private Hero playerHero1;
    private Hero playerHero2;
    private Hero playerHero3;

    public void setToMainMenu(Scene scene, Hero hero1, Hero hero2, Hero hero3) {
        mainScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;

    }
    public void setToFightScene(Scene scene, Hero hero1, Hero hero2, Hero hero3)
    {
        fightScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
    }
   /* public void openMainMenu(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
    }*/
}