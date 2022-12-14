package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FightSceneController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    private Scene mainScene;
    private Scene loseScene;
    private Scene fightSceneSetup;

    private Hero playerHero1;
    private Hero playerHero2;
    private Hero playerHero3;
    private Hero playerActiveHero;
    private Hero heroAI;







    // set data
    public void setToMainMenu(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai) {
        mainScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
    }

    public void setToLoseScene(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai) {
        loseScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
    }
    // move scene
    // main menu
    public void openMainMenu(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
    }
    // lose scene
    public void openLoseScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(loseScene);
    }

    // back to fight scene




//    some troubleshooting prints
    public void inventoryButtonClick()
    {
        System.out.println("click registered for inventory");
        System.out.println(playerHero1 + " object ID from FightScene Controller"); // print hero object id
        System.out.println("Hero HP is: " + playerHero1.getCurrenthp());
        playerHero1.setCurrenthp(playerHero1.getCurrenthp()-1);
        System.out.println("Hero HP is: " + playerHero1.getCurrenthp());

//        go to inventory of the hero
    }

    public void supermoveButtonClick()
    {
        System.out.println("click registered for supermove");
//        check if charged or not
    }

    public void actionButtonClick()
    {
        System.out.println("click registered for action");
    }

    public TextField txt_p1Hp;
    public TextField txt_p2Hp;
    public Button button_menu;

//    i still dont know how we wanna do abilities but here is a dummy action button
    public Button button_action;
    //  see above. not sure how we want to do this (UI mockup is different)
    public Button button_abilities;

    public Button button_inventory;
    public Button button_supermove;
    public Button button_surrender;




}
