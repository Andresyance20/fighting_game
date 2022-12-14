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
    private Hero playerActiveHero;
    private Hero heroAI;


//    These sets are only the initial setting of data.
    // The only place we change activeHero is here ...
    // So we should be able to just do if checks to set it to the correct one?
    public void setToFightSceneSetup(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai)
    {

        fightSceneSetupScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
    }

    // here is where we can update the data we pass between scenes
    public void openFightSceneSetup(ActionEvent actionEvent)
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

        setToFightSceneSetup(fightSceneSetupScene, playerHero1, playerHero2, playerHero3, playerActiveHero, heroAI);




        System.out.println("\nGrand Test Print");
        System.out.println("in class: HeroSheetController. ");
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
        primaryStage.setScene(fightSceneSetupScene);
    }



    public Button button_fight_scene_setup;




    public void loadHeroData1()
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

        System.out.println("Start by printing playerActiveHero name: "+ playerActiveHero.getName());
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
        hero_text_cost_str.setText("Cost: " + (playerHero1.getStrength() * 69 * 1.2) + ".");
        hero_text_cost_end.setText("Cost: " + (playerHero1.getEndurance() * 69 * 1.2)+ ".");
        hero_text_cost_agi.setText("Cost: " + (playerHero1.getAgility() * 69 * 1.2) + ".");

        hero_text_active_hero.setText("Active Hero: " + playerHero1.getName() + ".");
        // set the loaded hero to active, and others to not active.
        playerHero1.active = true;
        playerHero2.active = false;
        playerHero3.active = false;
//        System.out.println("\nHero1: " + playerHero1.getName() + ".\nActive: " + playerHero1.getActive() + ".");
//        System.out.println("Hero2: " + playerHero2.getActive() + " Hero3: " + playerHero3.getActive());



// testing an "Active" hero ref to make combat easier
        playerActiveHero = playerHero1;


        System.out.println("playerActiveHero name: "+ playerActiveHero.getName());
        System.out.println("playerHero1 name: "+ playerHero1.getName());





    }

    public void loadHeroData2()
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

        System.out.println("Start by printing playerActiveHero name: "+ playerActiveHero.getName());
        hero_text_str.setText("Strength: " + playerHero2.getStrength() + ".");
        hero_text_end.setText("Endurance: " + playerHero2.getEndurance() + ".");
        hero_text_agi.setText("Agility: " + playerHero2.getAgility() + ".");
        hero_text_name.setText("Name: " + playerHero2.getName() + ".");
        hero_text_exp.setText("Experience: " + playerHero2.getExperience() + ".");
        hero_text_money.setText("Money: " + playerHero2.getMoney() + ".");
        hero_text_victories.setText("Victories: " + playerHero2.getVictoryCount() + ".");
        hero_text_losses.setText("Losses: " + playerHero2.getLossCount() + ".");
        hero_text_hp.setText("HP: " + playerHero2.getCurrenthp() + "/" + playerHero2.getMaxhp() + ".");
        hero_text_dodge.setText("Dodge: " + playerHero2.getDodge() + "%");
        hero_text_cost_str.setText("Cost: " + (playerHero2.getStrength() * 69) + ".");
        hero_text_cost_end.setText("Cost: " + (playerHero2.getEndurance() * 69)+ ".");
        hero_text_cost_agi.setText("Cost: " + (playerHero2.getAgility() * 69)+ ".");

        hero_text_active_hero.setText("Active Hero: " + playerHero2.getName() + ".");
        // set the loaded hero to active, and others to not active.
        playerHero1.active = false;
        playerHero2.active = true;
        playerHero3.active = false;
//        System.out.println("\nHero2: " + playerHero2.getName() + ".\nActive: " + playerHero2.getActive() + ".");
//        System.out.println("Hero1: " + playerHero1.getActive() + " Hero3: " + playerHero3.getActive());


// testing an "Active" hero ref to make combat easier
        playerActiveHero = playerHero2;
        System.out.println("playerActiveHero name: "+ playerActiveHero.getName());
        System.out.println("playerHero2 name: "+ playerHero2.getName());


    }
    public void loadHeroData3()
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


        System.out.println("Start by printing playerActiveHero name: "+ playerActiveHero.getName());
        hero_text_str.setText("Strength: " + playerHero3.getStrength() + ".");
        hero_text_end.setText("Endurance: " + playerHero3.getEndurance() + ".");
        hero_text_agi.setText("Agility: " + playerHero3.getAgility() + ".");
        hero_text_name.setText("Name: " + playerHero3.getName() + ".");
        hero_text_exp.setText("Experience: " + playerHero3.getExperience() + ".");
        hero_text_money.setText("Money: " + playerHero3.getMoney() + ".");
        hero_text_victories.setText("Victories: " + playerHero3.getVictoryCount() + ".");
        hero_text_losses.setText("Losses: " + playerHero3.getLossCount() + ".");
        hero_text_hp.setText("HP: " + playerHero3.getCurrenthp() + "/" + playerHero3.getMaxhp() + ".");
        hero_text_dodge.setText("Dodge: " + playerHero3.getDodge() + "%");
        hero_text_cost_str.setText("Cost: " + (playerHero3.getStrength() * 69) + ".");
        hero_text_cost_end.setText("Cost: " + (playerHero3.getEndurance() * 69)+ ".");
        hero_text_cost_agi.setText("Cost: " + (playerHero3.getAgility() * 69)+ ".");

        hero_text_active_hero.setText("Active Hero: " + playerHero3.getName() + ".");
        // set the loaded hero to active, and others to not active.
        playerHero1.active = false;
        playerHero2.active = false;
        playerHero3.active = true;
//        System.out.println("\nHero3: " + playerHero3.getName() + ".\nActive: " + playerHero3.getActive() + ".");
//        System.out.println("Hero1: " + playerHero2.getActive() + " Hero2: " + playerHero2.getActive());



// testing an "Active" hero ref to make combat easier
        playerActiveHero = playerHero3;
        System.out.println("playerActiveHero name: "+ playerActiveHero.getName());
        System.out.println("playerHero3 name: "+ playerHero3.getName());

//        playerHero3.setCurrenthp(playerHero3.getCurrenthp()-1);
        System.out.println("playerHero3 current hp: " + playerHero3.getCurrenthp());


        playerActiveHero.setCurrenthp(playerActiveHero.getCurrenthp()-1);
        System.out.println("playerActiveHero current hp: " + playerActiveHero.getCurrenthp() + " did not change this one directly");

        System.out.println("After changing the active hero, here is playerHero3's current hp:" + playerHero3.getCurrenthp());



    }

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
    @FXML
    private Text hero_text_active_hero;

    @FXML
    Button button_increase_str;
    @FXML
    Button button_increase_end;
    @FXML
    Button button_increase_agi;



// idk this seems bulky but i don't want to think anymore, would be cool if we could just pass in the active hero but
// we just assume access to all heros so we don't know unless we actively check if hero is active until we find it.
// maybe a way to have another hero object reference that swaps during changes?
    // idk formula can be 69 funny number * 1.2
    public void increaseStrength()
    {
        double costFormulaHero1 = playerHero1.getStrength() * 69 * 1.2;
        double costFormulaHero2 = playerHero2.getStrength() * 69 * 1.2;
        double costFormulaHero3 = playerHero3.getStrength() * 69 * 1.2;

        // check if active
        if (playerHero1.getActive())
        {
            // check if can afford first
            if (playerHero1.getExperience() >= costFormulaHero1)
            {
                // pay the cost, increase the stat
                playerHero1.setExperience(playerHero1.getExperience() - (costFormulaHero1));
                playerHero1.setStrength(playerHero1.getStrength() + 1);
                // update the screen to current data
                loadHeroData1();
            }
            else { System.out.println("Not enough exp! "); }
        }
        else if (playerHero2.getActive())
        {
            if (playerHero2.getExperience() >= costFormulaHero2)
            {
                playerHero2.setExperience(playerHero2.getExperience() - (costFormulaHero2));
                playerHero2.setStrength(playerHero2.getStrength() + 1);
                loadHeroData2();
            }
            else { System.out.println("Not enough exp! "); }

        }
        else if (playerHero3.getActive())
        {
            if (playerHero3.getExperience() >= costFormulaHero3)
            {
                playerHero3.setExperience(playerHero3.getExperience() - (costFormulaHero3));
                playerHero3.setStrength(playerHero3.getStrength() + 1);
                loadHeroData3();
            }
            else { System.out.println("Not enough exp! "); }
        } else { System.out.println("Not enough experience? or not active hero?"); }
    }

    public void increaseEndurance()
    {
        double costFormulaHero1 = playerHero1.getEndurance() * 69 * 1.2;
        double costFormulaHero2 = playerHero2.getEndurance() * 69 * 1.2;
        double costFormulaHero3 = playerHero3.getEndurance() * 69 * 1.2;

        if (playerHero1.getActive())
        {
            if (playerHero1.getExperience() >= costFormulaHero1)
            {
                playerHero1.setExperience(playerHero1.getExperience() - (costFormulaHero1));
                playerHero1.setEndurance(playerHero1.getEndurance() + 1);
                loadHeroData1();
            }
            else { System.out.println("Not enough exp! "); }
        }
        else if (playerHero2.getActive())
        {
            if (playerHero2.getExperience() >= costFormulaHero2)
            {
                playerHero2.setExperience(playerHero2.getExperience() - (costFormulaHero2));
                playerHero2.setEndurance(playerHero2.getEndurance() + 1);
                loadHeroData2();
            }
            else { System.out.println("Not enough exp! "); }
        }
        else if (playerHero3.getActive())
        {
            if (playerHero3.getExperience() >= costFormulaHero3)
            {
                playerHero3.setExperience(playerHero3.getExperience() - (costFormulaHero3));
                playerHero3.setEndurance(playerHero3.getEndurance() + 1);
                loadHeroData3();
            }
            else { System.out.println("Not enough exp! "); }
        } else { System.out.println("No active hero? try to load one by clicking the button "); }
    }

    public void increaseAgility()
    {
        double costFormulaHero1 = playerHero1.getAgility() * 69 * 1.2;
        double costFormulaHero2 = playerHero2.getAgility() * 69 * 1.2;
        double costFormulaHero3 = playerHero3.getAgility() * 69 * 1.2;

        if (playerHero1.getActive())
        {
            if (playerHero1.getExperience() >= costFormulaHero1)
            {
                playerHero1.setExperience(playerHero1.getExperience() - (costFormulaHero1));
                playerHero1.setAgility(playerHero1.getAgility() + 1);
                loadHeroData1();
            }
            else { System.out.println("Not enough exp! "); }
        }
        else if (playerHero2.getActive())
        {
            if (playerHero2.getExperience() >= costFormulaHero2)
            {
                playerHero2.setExperience(playerHero2.getExperience() - (costFormulaHero2));
                playerHero2.setAgility(playerHero2.getAgility() + 1);
                loadHeroData2();
            }
            else { System.out.println("Not enough exp! "); }
        }
        else if (playerHero3.getActive())
        {
            if (playerHero3.getExperience() >= costFormulaHero3)
            {
                playerHero3.setExperience(playerHero3.getExperience() - (costFormulaHero3));
                playerHero3.setAgility(playerHero3.getAgility() + 1);
                loadHeroData3();
            }
            else { System.out.println("Not enough exp! "); } // Add some visual signal?
        } else { System.out.println("No active hero? try to load one by clicking the button "); }
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
