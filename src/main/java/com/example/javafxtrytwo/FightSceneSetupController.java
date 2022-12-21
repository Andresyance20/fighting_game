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
    private int money;
    private int hpPotionCount;
    private int attackPotionCount;
    private int superPotionCount;
    private HeroSheetController heroSheetControllernotfrommain;
    private FightSceneController fightSceneControllernotfrommain;

    public boolean selectedDifficulty = false;
    public boolean selectedBackground = false;
    public boolean selectedHero = false;





//  setting data
    public void setToMainMenu(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai, int money, int hpCount, int attackCount, int superCount)
    {
        mainScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
        this.money = money;
        hpPotionCount = hpCount;
        attackPotionCount = attackCount;
        superPotionCount = superCount;
    }

//    Hero activeHeroPlayer
    public void setToFightScene(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai, FightSceneController fightSceneControllernotfrommain1, int money, int hpCount, int attackCount, int superCount)
    {

        fightSceneControllernotfrommain = fightSceneControllernotfrommain1;
        fightScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
        this.money = money;
        hpPotionCount = hpCount;
        attackPotionCount = attackCount;
        superPotionCount = superCount;
    }

    public void setToHeroSheet(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai, HeroSheetController heroSheetControllernotfrommain1, int money, int hpCount, int attackCount, int superCount)
    {
        heroSheetControllernotfrommain = heroSheetControllernotfrommain1;
        heroSheetScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
        this.money = money;
        hpPotionCount = hpCount;
        attackPotionCount = attackCount;
        superPotionCount = superCount;
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
        }

        System.out.println("Potions:");
        System.out.println("HP: " + hpPotionCount + " Attack: " + attackPotionCount + " Super: " + superPotionCount);

        setToMainMenu(mainScene, playerHero1, playerHero2, playerHero3, playerActiveHero, heroAI, money, hpPotionCount, attackPotionCount, superPotionCount);


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

            fightSceneControllernotfrommain.loadFightSceneData();
        }
        if (playerHero2.getActive() == true)
        {
            System.out.println("Hero2 is: " + playerHero2.getActive());
            playerActiveHero = playerHero2;

            fightSceneControllernotfrommain.loadFightSceneData();
        }
        if (playerHero3.getActive() == true)
        {
            System.out.println("Hero3 is: " + playerHero3.getActive());
            playerActiveHero = playerHero3;

            fightSceneControllernotfrommain.loadFightSceneData();
        }

        System.out.println("Potions:");
        System.out.println("HP: " + hpPotionCount + " Attack: " + attackPotionCount + " Super: " + superPotionCount);

        setToFightScene(fightScene, playerHero1, playerHero2, playerHero3, playerActiveHero, heroAI, fightSceneControllernotfrommain, money, hpPotionCount, attackPotionCount, superPotionCount);

//        Checks in to see difficulty was set, background set, and hero set
        if (playerActiveHero.getActive() == true)
        {
            selectedHero = true;
            System.out.println(" PASS");
        }

        if (selectedDifficulty == true && selectedBackground == true && selectedHero == true)
        {

            Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            primaryStage.setScene(fightScene);

        }
        else
        {
            if (selectedHero == false)
            {
                button_inspect_heroes.setStyle("-fx-background-color: red");
            }
            if (selectedDifficulty == false)
            {
                button_set_difficulty.setStyle("-fx-background-color: red");
            }
            if (selectedBackground == false)
            {
                button_set_map.setStyle("-fx-background-color: red");
            }
            System.out.println("\nSelect a hero, and a difficulty, and a background");
        }


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

        System.out.println("Potions:");
        System.out.println("HP: " + hpPotionCount + " Attack: " + attackPotionCount + " Super: " + superPotionCount);

        setToHeroSheet(heroSheetScene, playerHero1, playerHero2, playerHero3, playerActiveHero, heroAI, heroSheetControllernotfrommain, money, hpPotionCount, attackPotionCount, superPotionCount);

        // set color correctly because we won't let them come back UNTIL they select a hero.
        button_inspect_heroes.setStyle("-fx-background-color: limegreen");
//        button_inspect_heroes.setText(playerActiveHero.getName());

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

        button_set_map.setStyle("-fx-background-color: limegreen");

        // can redraw background, need a reference to fightscene controller?
       // need one anyway to load data

        // rotate map setting (background image? or anything else) - dunno what data type it should be (prob a string)
        // that gets matched to an image background?
    }

    public String difficulty = "unselected";
    @FXML
    protected void difficultyButtonClick() {

        button_set_difficulty.setStyle("-fx-background-color: limegreen");

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

