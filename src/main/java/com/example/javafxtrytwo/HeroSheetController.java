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

public class HeroSheetController implements Initializable {

    @FXML
    private Text hero_text_str;

    public void updateHeroinfo() {
        hero_text_str.setText("Strength: " + playerHero1.getStrength());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hero_text_str.setText("Stre");

//        updateHeroInfo();
//        hero_text_str.setText(playerHero1.getName());

//        hero_text_str.setText("Strength: " + playerHero1.getStrength());




    }




    private Hero playerHero1;
    private Hero PlayerHero2;
    private Hero PlayerHero3;
    private Scene fightSceneSetupScene;



    public void setToFightSceneSetup(Scene scene, Hero hero1)
    {
        fightSceneSetupScene = scene;
        playerHero1 = hero1;
    }

    public void openFightSceneSetup(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        hero_text_str.setText("Strength: " + playerHero1.getStrength());

//        System.out.println(playerHero1 + " From HeroSheet controller");
//        playerHero1.setName("new name set test");

        primaryStage.setScene(fightSceneSetupScene);
    }




    public Button button_fightscenesetup;





    public void updateHeroInfo()
    {
        hero_text_str.setText(String.valueOf(playerHero1.getStrength()));
    }




    public void displayInfo()
    {
//        playerHero1.print_hero_info();

    }

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
