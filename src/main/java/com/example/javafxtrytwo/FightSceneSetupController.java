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


public class FightSceneSetupController {

    private Scene mainScene;
    private Scene fightScene;
    private Scene heroSheetScene;
    private Hero playerHero1;
    private Hero playerHero2;
    private Hero playerHero3;
    private Hero playerActiveHero;
    private Hero heroAI;
    private HeroSheetController heroSheetControllernotfrommain;

    public boolean selectedDifficulty = false;
    public boolean selectedBackground = false;
    public boolean selectedHero = false;





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

    public void setToHeroSheet(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai, HeroSheetController heroSheetControllernotfrommain1)
    {
        heroSheetControllernotfrommain = heroSheetControllernotfrommain1;
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
        System.out.println("in class: FightSceneSetupController. ");
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


    public void openFightScene(ActionEvent actionEvent)
    {
        // logic to make sure there is an active hero before going to fightscene
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

        setToFightScene(fightScene, playerHero1, playerHero2, playerHero3, playerActiveHero, heroAI);


//        Checks in to see difficulty was set, background set, and hero set
        if (playerActiveHero.getActive() == true)
        {
            selectedHero = true;
            System.out.println(" PASS");
        }

        if (selectedDifficulty == true && selectedBackground == true && selectedHero == true)
        {



//            before going to fightscene also need to get a reference to its controller so we can load the activeHero
//            data into the fightscene
            Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            primaryStage.setScene(fightScene);
        }
        else
        {
            System.out.println("\nSelect a hero, and a difficulty, and a background");
        }



//        System.out.println("\nGrand Test Print");
//        System.out.println("in class: FightSceneSetupController. ");
//        System.out.println("Hero 1 name: " + playerHero1.getName());
//        System.out.println("Hero 1 hp: " + playerHero1.getCurrenthp());
//        System.out.println("Hero 1 active: " + playerHero1.getActive());
//
//        System.out.println("\nHero 2 name: " + playerHero2.getName());
//        System.out.println("Hero 2 hp: " + playerHero2.getCurrenthp());
//        System.out.println("Hero 2 active: " + playerHero2.getActive());
//
//        System.out.println("\nHero 3 name: " + playerHero3.getName());
//        System.out.println("Hero 3 hp: " + playerHero3.getCurrenthp());
//        System.out.println("Hero 3 active: " + playerHero3.getActive());
//
//
//        System.out.println("\nACTIVEheroobject name: " + playerActiveHero.getName());
//        System.out.println("ACTIVEheroobject hp: " + playerActiveHero.getCurrenthp());
//        System.out.println("ACTIVEheroobject active:  " + playerActiveHero.getActive());




    }

    public void openHeroSheetScene(ActionEvent actionEvent)
    {
        // add some logic to make sure there is an active hero before going to fightscene?
        if (playerHero1.getActive() == true)
        {
            System.out.println("Hero1 is: " + playerHero1.getActive());
            playerActiveHero = playerHero1;

            heroSheetControllernotfrommain.loadHeroData1();
        }
        if (playerHero2.getActive() == true)
        {
            System.out.println("Hero2 is: " + playerHero2.getActive());
            playerActiveHero = playerHero2;

            heroSheetControllernotfrommain.loadHeroData2();
        }
        if (playerHero3.getActive() == true)
        {
            System.out.println("Hero3 is: " + playerHero3.getActive());
            playerActiveHero = playerHero3;
            System.out.println(playerActiveHero.getCurrenthp());

            heroSheetControllernotfrommain.loadHeroData3();
        }


        setToHeroSheet(heroSheetScene, playerHero1, playerHero2, playerHero3, playerActiveHero, heroAI, heroSheetControllernotfrommain);

        button_inspect_heroes.setText(playerActiveHero.getName());

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(heroSheetScene);
    }



    public Button button_menu;
    public Button button_goto_fight_scene;

    public Button button_inspect_heroes;
    public Button button_set_difficulty;
    public Button button_set_map;


    @FXML
    protected void mapButtonClick() {
        selectedBackground = true;
        System.out.println("click registered for map");

        // can redraw background, need a reference to fightscene controller?
       // need one anyway to load data

        // rotate map setting (background image? or anything else) - dunno what data type it should be (prob a string)
        // that gets matched to an image background?
    }

    public String difficulty = "unselected";
    @FXML
    protected void difficultyButtonClick() {
        if (difficulty.equals("unselected"))
        {
            // if never clicked yet, set to hard so it sets to normal.
        difficulty = "hard";
        }

        // if already normal set to hard on button click
        if (difficulty.equals("normal"))
        {
            button_set_difficulty.setText("<< Hard");
            heroAI.setAiDifficulty("hard");

            System.out.println("Hard ");
            heroAI.print_hero_info();
            difficulty = "hard";
            selectedDifficulty = true;
        }
//        if already hard, set to normal on button click
        else if (difficulty.equals("hard"))
        {
            button_set_difficulty.setText("Normal >>");
            heroAI.setAiDifficulty("normal");

            System.out.println("Normal ");
            heroAI.print_hero_info();
            difficulty = "normal";
            selectedDifficulty = true;
        }
    }

}

