package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

// think we need to initialize the text?
//    was testing initialize, if you need any data, you can load it before the view is onscreen.
//    idk that we will need to do this, but if we have issues with null data, this might be a solution so I will leave it here for now.

//    public class MainController implements Initializable {
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//    }


// the scene that will display the characteristics of a specific hero.

public class HeroSheetController {

    private Hero playerHero1;
    private Hero playerHero2;
    private Hero playerHero3;
    private Scene fightSceneSetupScene;

    public void setToFightSceneSetup(Scene scene, Hero hero1, Hero hero2, Hero hero3)
    {
        fightSceneSetupScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
    }

    public void openFightSceneSetup(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(fightSceneSetupScene);
    }




    public Button button_fight_scene_setup;



    public void loadHeroData1()
    {
        hero_text_str.setText("Strength: " + playerHero1.getStrength() + ".");
        hero_text_end.setText("Endurance: " + playerHero1.getEndurance() + ".");
        hero_text_agi.setText("Agility: " + playerHero1.getAgility() + ".");
        hero_text_name.setText("Name: " + playerHero1.getName() + ".");
        hero_text_exp.setText("Experience: " + playerHero1.getExperience() + ".");
        hero_text_money.setText("Money: " + playerHero1.getMoney() + ".");
        hero_text_victories.setText("Victories: " + playerHero1.getVictoryCount() + ".");
        hero_text_losses.setText("Losses: " + playerHero1.getLossCount() + ".");
        hero_text_hp.setText("HP: " + playerHero1.getCurrenthp() + "/" + playerHero1.getMaxhp() + ".");
        hero_text_dodge.setText("Dodge: " + playerHero1.getDodge() + "%");
        hero_text_cost_str.setText("Cost: " + (playerHero1.getStrength() * 69) + ".");
        hero_text_cost_end.setText("Cost: " + (playerHero1.getEndurance() * 69)+ ".");
        hero_text_cost_agi.setText("Cost: " + (playerHero1.getAgility() * 69)+ ".");

    }
    public void loadHeroData2()
    {}
    public void loadHeroData3()
    {}

    @FXML
    private Text hero_text_str;
    @FXML
    private Text hero_text_end;
    @FXML
    private Text hero_text_agi;
    @FXML
    private Text hero_text_name;
    @FXML
    private Text hero_text_exp;
    @FXML
    private Text hero_text_money;
    @FXML
    private Text hero_text_victories;
    @FXML
    private Text hero_text_losses;
    @FXML
    private Text hero_text_hp;
    @FXML
    private Text hero_text_dodge;
    @FXML
    private Text hero_text_cost_str;
    @FXML
    private Text hero_text_cost_end;
    @FXML
    private Text hero_text_cost_agi;










//    exp or money -> stat increase
    public void increaseStat(double experience)
    {

    }

//    not totally sure how we are linking these up, but we should/can access/manage/view the hero objects inventory from here.
    public void viewInventory()
    {

    }

//    access/view/manage abilities
    public void viewAbilities()
    {

    }

    public void inspectAspect(int buttonElement)
    {
//        display some deeper level of info about the clicked element
//        clicking the Strength stat would make a popup explaining how it is used in calculations or something.
    }


}
