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

public class FightSceneSetupController implements Initializable {

    private Scene mainScene;
    private Scene fightScene;
    private Scene heroSheetScene;
    private Hero playerHero1;
    private Hero playerHero2;
    private Hero playerHero3;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Text hero_text_str;



//  setting data
    public void setToMainMenu(Scene scene, Hero hero1, Hero hero2, Hero hero3)
    {
        mainScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;

    }

    public void setToFightScene(Scene fightSceneScene, Hero hero1, Hero hero2, Hero hero3)
    {
        fightScene = fightSceneScene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
    }

    public void setToHeroSheet(Scene scene, Hero hero1, Hero hero2, Hero hero3)
    {
        heroSheetScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
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
    }

    public void openHeroSheetScene(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        button_inspect_hero1.setText(playerHero1.getName());
        button_inspect_hero2.setText(playerHero2.getName());
        button_inspect_hero3.setText(playerHero3.getName());
        primaryStage.setScene(heroSheetScene);


    }


    public void updateHeroInfo()
    {
        hero_text_str.setText("Strength: ");
//        hero_text_str.setText("Strength: " + playerHero1.getStrength());
    }




    public Button button_menu;
    public Button button_goto_fight_scene;
    public Button button_inspect_hero1;
    public Button button_inspect_hero2;
    public Button button_inspect_hero3;
    public Button button_set_difficulty;
    public Button button_set_map;


    @FXML
    protected void inspectHeroButtonClick() {
        System.out.println("click registered for inspect hero");
        System.out.println(playerHero1 + " object ID from FightSceneSetup Controller"); // print hero object id
//        button_inspect_hero1.setText("Inspect: " + playerHero1.getName() + ".");




        // to do: open the specific hero's character sheet (information display)
    }

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

