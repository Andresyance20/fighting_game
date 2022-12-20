package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoseSceneController {
    private Scene mainScene;
    private Scene fightScene;
    private Hero playerHero1;
    private Hero playerHero2;
    private Hero playerHero3;
    private Hero playerActiveHero;
    private Hero heroAI;
    private int money;
    private int hpPotionCount;
    private int attackPotionCount;
    private int superPotionCount;

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

        playerHero1 = playerHero1;
        playerHero2 = playerHero2;
        playerHero3 = playerHero3;
        heroAI = heroAI;

        // add some logic to make sure there is an active hero before going to fightscene?
        if (playerHero1.getActive() == true)
        {
            playerActiveHero = playerHero1;
        }
        if (playerHero2.getActive() == true)
        {
            playerActiveHero = playerHero2;
        }
        if (playerHero3.getActive() == true)
        {
            playerActiveHero = playerHero3;
        }


        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
    }

    public void openFightScene(ActionEvent actionEvent) {

        playerHero1 = playerHero1;
        playerHero2 = playerHero2;
        playerHero3 = playerHero3;
        heroAI = heroAI;

        // add some logic to make sure there is an active hero before going to fightscene?
        if (playerHero1.getActive() == true)
        {
            playerActiveHero = playerHero1;
        }
        if (playerHero2.getActive() == true)
        {
            playerActiveHero = playerHero2;
        }
        if (playerHero3.getActive() == true)
        {
            playerActiveHero = playerHero3;
        }


        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(fightScene);
    }


    @FXML
    private Label result_text;
    @FXML
    private Label result_money_text;
    @FXML
    private Label result_experience_text;

    public void loadWinScene()
    {
        result_text.setText("You Won!");
        result_experience_text.setText("Won: " + heroAI.getExperience() + " Experience");
        result_money_text.setText("Won: " + heroAI.getMoney() + " Money");
        heroAI.reset_hero_full_recovery();
        playerActiveHero.reset_hero_full_recovery();
    }

    public void loadLossScene()
    {
        result_text.setText("You lost!");
        result_experience_text.setText("");
        result_money_text.setText("");
        heroAI.reset_hero_full_recovery();
        playerActiveHero.reset_hero_full_recovery();
    }











    public Button button_losetomenu;
    public Button button_retry;
}
