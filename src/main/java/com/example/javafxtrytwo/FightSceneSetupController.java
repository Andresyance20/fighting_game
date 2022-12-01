package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FightSceneSetupController {

    private Scene mainScene;
    private Scene fightScene;
    private Hero hero1;

//  setting data
    // rename to like hero 1,2,3 and ai to be explicit/clear about names
    public void setToMainMenu(Scene scene, Hero hero)
    {
        mainScene = scene;
        hero1 = hero;
        System.out.println(hero1.getName() + " From fightSceneSetup controller");
    }

    public void setToFightScene(Scene fightSceneScene, Hero hero)
    {
        fightScene = fightSceneScene;
        hero1 = hero;
        System.out.println(hero1.getName() + " From fightSceneSetup controller");
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
        System.out.println(hero1 + " object ID from FightSceneSetup Controller"); // print hero object id

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

