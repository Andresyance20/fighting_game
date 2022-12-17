package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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



        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
    }
    // lose scene
    public void openLoseScene(ActionEvent actionEvent) {

        playerHero1 = playerHero1;
        playerHero2 = playerHero2;
        playerHero3 = playerHero3;
        heroAI = heroAI;

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

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(loseScene);
    }

    // back to fight scene




//    some troubleshooting prints
    public void inventoryButtonClick()
    {

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

        System.out.println("\n\n" + playerActiveHero.getName());

//        System.out.println("click registered for inventory");
        System.out.println(playerActiveHero + " object ID from FightScene Controller"); // print hero object id
        System.out.println("Hero HP is: " + playerActiveHero.getCurrenthp());
        playerActiveHero.setCurrenthp((int) ((playerActiveHero.getCurrenthp())-1));
        System.out.println("Hero HP is: " + playerActiveHero.getCurrenthp());

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


    @FXML
    private Label hero_player_text_name;
    @FXML
    private Label hero_ai_text_name;
    @FXML
    private Label hero_player_hp_text;
    @FXML
    private Label hero_ai_hp_text;


    public void loadFightSceneData()
    {
// we do always need this check to stay updated otherwise it won't be the correct data displayed
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
        }

        hero_player_text_name.setText("" + playerActiveHero.getName());
        hero_player_hp_text.setText("" + (playerActiveHero.getCurrenthp() + " / " + playerActiveHero.getMaxhp()));

        hero_ai_text_name.setText("" + heroAI.getName());
        hero_ai_hp_text.setText("" + (heroAI.getCurrenthp() + " / " + heroAI.getMaxhp()));


    }

//    public TextField txt_p1Hp;
//    public TextField txt_p2Hp;
    public Button button_menu;







//    i still dont know how we wanna do abilities but here is a dummy action button
    public Button button_action;
    //  see above. not sure how we want to do this (UI mockup is different)
    public Button button_abilities;

    public Button button_inventory;
    public Button button_supermove;
    public Button button_surrender;




}
