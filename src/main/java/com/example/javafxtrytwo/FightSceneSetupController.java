package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


// I am going to try and make this controller be the controller for HeroSheet.fxml,
// too so we don't have to see dummy/fake data on first visit
// due to not being able to change data to hero data because the hero data reference is null until first visit to scene.



public class FightSceneSetupController {

    private Scene mainScene;
    private Scene fightScene;
    private Scene heroSheetScene;
    private Hero playerHero1;
    private Hero playerHero2;
    private Hero playerHero3;
    private Hero playerActiveHero;
    private Hero heroAI;

//    public void setActiveHero()
//    {
//        if (playerHero1.getActive())
//        {
//            playerActiveHero = playerHero1;
//        }
//    }


//  setting data
    public void setToMainMenu(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai)
    {
        mainScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
    }

//    Hero activeHeroPlayer
    public void setToFightScene(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai)
    {
        fightScene = scene;
        // would be nice if this works, and we just have to write combat once for any active hero,
        // and not 3 times to specific hero 1 or hero 2 or 3
//        activeHero = activeHeroPlayer;

        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
    }

    public void setToHeroSheet(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai)
    {
        heroSheetScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
    }


    //  moving scenes/stages
    public void openMainMenu(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
    }


    public void openFightScene(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(fightScene);

        // need to call some methods and pass some parameters to it?
        // map, difficulty?
    }

    public void openHeroSheetScene(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        how to set active hero?
//        button_inspect_heroes.setText(playerHero1.getName());
        primaryStage.setScene(heroSheetScene);

    }




    public Button button_menu;
    public Button button_goto_fight_scene;

    public Button button_inspect_heroes;
    public Button button_set_difficulty;
    public Button button_set_map;



    // probably easiest for these to rotate through pre-made options on click
    @FXML
    protected void mapButtonClick() {
        System.out.println("click registered for map");

        // rotate map setting (background image? or anything else) - dunno what data type it should be (prob a string)
        // that gets matched to an image background?
    }

    @FXML
    protected void difficultyButtonClick() {
        System.out.println("click registered for difficulty");

        // rotate difficulty setting on click easy -> hard
    }

}

