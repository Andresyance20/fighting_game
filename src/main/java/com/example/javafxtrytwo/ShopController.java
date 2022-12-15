package com.example.javafxtrytwo;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ShopController {
    private Scene PotionShopScene;
    private Scene mainScene;
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

    // back to menu
    public void openMainMenu(ActionEvent actionEvent)
    {


        // add some logic to make sure there is an active hero before going to fightscene?
        if (playerHero1.getActive() == true)
        {
            System.out.println("Hero1 is: " + playerHero1.getActive());
            playerActiveHero = playerHero1;
        }
        if (playerHero2.getActive() == true)
        {
            System.out.println("Hero2 is: " + playerHero2.getActive());
            playerActiveHero = playerHero2;
        }
        if (playerHero3.getActive() == true)
        {
            System.out.println("Hero3 is: " + playerHero3.getActive());
            playerActiveHero = playerHero3;
            System.out.println(playerActiveHero.getCurrenthp());
        }

        setToMainMenu(mainScene, playerHero1, playerHero2, playerHero3, playerActiveHero, heroAI);

        System.out.println("\nGrand Test Print");
        System.out.println("in class: FightSceneController. ");
        System.out.println("Hero 1 name: " + playerHero1.getName());
        System.out.println("Hero 1 hp: " + playerHero1.getCurrenthp());
        System.out.println("Hero 1 active: " + playerHero1.getActive());

        System.out.println("\nHero 2 name: " + playerHero2.getName());
        System.out.println("Hero 2 hp: " + playerHero2.getCurrenthp());
        System.out.println("Hero 2 active: " + playerHero2.getActive());

        System.out.println("\nHero 3 name: " + playerHero3.getName());
        System.out.println("Hero 3 hp: " + playerHero3.getCurrenthp());
        System.out.println("Hero 3 active: " + playerHero3.getActive());

        System.out.println("\nACTIVEheroobject name: " + playerActiveHero.getName());
        System.out.println("ACTIVEheroobject hp: " + playerActiveHero.getCurrenthp());
        System.out.println("ACTIVEheroobject active:  " + playerActiveHero.getActive());



        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
    }

    public Button button_shopToMenu;
    public Button button_potionShop;
    public Button button_abilityShop;
}
