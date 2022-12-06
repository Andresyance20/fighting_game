package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HeroSheetController {

// the scene that will display the characteristics of a specific hero.



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
        primaryStage.setScene(fightSceneSetupScene);
        System.out.println(playerHero1 + " From HeroSheet controller");
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
