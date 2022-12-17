package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

//    think we need to initialize the text?
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


//        if the player selected a hero
        if (playerActiveHero.getActive() == true)
        {
            hero_text_active_hero.setStyle("-fx-background-color: lightgray");
            Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            primaryStage.setScene(fightSceneSetupScene);
        }
        else if (playerActiveHero.getActive() == false)
        {
            hero_text_active_hero.setText("Select a hero!");
            hero_text_active_hero.setFill(Color.RED);
//            hero_text_active_hero.setScaleX(2);
//            hero_text_active_hero.setScaleY(2);

        }

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
        hero_text_cost_str.setText("Cost: " + (playerHero1.getStrength() * 69) + ".");
        hero_text_cost_end.setText("Cost: " + (playerHero1.getEndurance() * 69)+ ".");
        hero_text_cost_agi.setText("Cost: " + (playerHero1.getAgility() * 69) + ".");

        hero_text_damage.setText("Attack Damage: " + playerHero1.getAttackDamage() + ".");

        hero_text_active_hero.setText("Active Hero: " + playerHero1.getName() + ".");
        hero_text_active_hero.setFill(Color.BLACK);
        button_load_hero1.setStyle("-fx-background-color: limegreen");
        button_load_hero2.setStyle("-fx-background-color: lightgray");
        button_load_hero3.setStyle("-fx-background-color: lightgray");
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

        hero_text_damage.setText("Attack Damage: " + playerHero2.getAttackDamage() + ".");

        hero_text_active_hero.setText("Active Hero: " + playerHero2.getName() + ".");
        hero_text_active_hero.setFill(Color.BLACK);
        button_load_hero1.setStyle("-fx-background-color: lightgray");
        button_load_hero2.setStyle("-fx-background-color: limegreen");
        button_load_hero3.setStyle("-fx-background-color: lightgray");
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
        hero_text_damage.setText("Attack Damage: " + playerHero3.getAttackDamage() + ".");

        hero_text_active_hero.setText("Active Hero: " + playerHero3.getName() + ".");
        hero_text_active_hero.setFill(Color.BLACK);
        button_load_hero1.setStyle("-fx-background-color: lightgray");
        button_load_hero2.setStyle("-fx-background-color: lightgray");
        button_load_hero3.setStyle("-fx-background-color: limegreen");
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


        playerActiveHero.setCurrenthp((int) (playerActiveHero.getCurrenthp()-1));
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
    private Text hero_text_damage;



    @FXML
    Button button_increase_str;
    @FXML
    Button button_increase_end;
    @FXML
    Button button_increase_agi;

    @FXML
    Button button_load_hero1;
    @FXML
    Button button_load_hero2;
    @FXML
    Button button_load_hero3;



// idk this seems bulky but i don't want to think anymore, would be cool if we could just pass in the active hero but
// we just assume access to all heros so we don't know unless we actively check if hero is active until we find it.
// maybe a way to have another hero object reference that swaps during changes?
    // idk formula can be 69 funny number * 1.2
    public void increaseStrength()
    {
        int costFormulaHero1 = (int) (playerHero1.getStrength() * 70);
        int costFormulaHero2 = (int) (playerHero2.getStrength() * 70);
        int costFormulaHero3 = (int) (playerHero3.getStrength() * 70);

        // check if active
        if (playerHero1.getActive())
        {
            // check if can afford first
            if (playerHero1.getExperience() >= costFormulaHero1)
            {
                // pay the cost, increase the stat
                playerHero1.setExperience((int) (playerHero1.getExperience() - (costFormulaHero1)));
                playerHero1.setStrength((int) (playerHero1.getStrength() + 1));
                // update the screen to current data

                playerHero1.updateAllStats();
                loadHeroData1();
            }
            else { System.out.println("Not enough exp! "); }
        }
        else if (playerHero2.getActive())
        {
            if (playerHero2.getExperience() >= costFormulaHero2)
            {
                playerHero2.setExperience((int) (playerHero2.getExperience() - (costFormulaHero2)));
                playerHero2.setStrength((int) (playerHero2.getStrength() + 1));

                playerHero2.updateAllStats();
                loadHeroData2();
            }
            else { System.out.println("Not enough exp! "); }

        }
        else if (playerHero3.getActive())
        {
            if (playerHero3.getExperience() >= costFormulaHero3)
            {
                playerHero3.setExperience((int) (playerHero3.getExperience() - (costFormulaHero3)));
                playerHero3.setStrength((int) (playerHero3.getStrength() + 1));

                playerHero3.updateAllStats();
                loadHeroData3();
            }
            else { System.out.println("Not enough exp! "); }
        } else { System.out.println("Not enough experience? or not active hero?"); }
    }

    public void increaseEndurance()
    {
        int costFormulaHero1 = (int) (playerHero1.getEndurance() * 69);
        int costFormulaHero2 = (int) (playerHero2.getEndurance() * 69);
        int costFormulaHero3 = (int) (playerHero3.getEndurance() * 69);

        if (playerHero1.getActive())
        {
            if (playerHero1.getExperience() >= costFormulaHero1)
            {
                playerHero1.setExperience((int) (playerHero1.getExperience() - (costFormulaHero1)));
                playerHero1.setEndurance((int) (playerHero1.getEndurance() + 1));

                playerHero1.updateAllStats();
                loadHeroData1();
            }
            else { System.out.println("Not enough exp! "); }
        }
        else if (playerHero2.getActive())
        {
            if (playerHero2.getExperience() >= costFormulaHero2)
            {
                playerHero2.setExperience((int) (playerHero2.getExperience() - (costFormulaHero2)));
                playerHero2.setEndurance((int) (playerHero2.getEndurance() + 1));

                playerHero2.updateAllStats();
                loadHeroData2();
            }
            else { System.out.println("Not enough exp! "); }
        }
        else if (playerHero3.getActive())
        {
            if (playerHero3.getExperience() >= costFormulaHero3)
            {
                playerHero3.setExperience((int) (playerHero3.getExperience() - (costFormulaHero3)));
                playerHero3.setEndurance((int) (playerHero3.getEndurance() + 1));

                playerHero3.updateAllStats();
                loadHeroData3();
            }
            else { System.out.println("Not enough exp! "); }
        } else { System.out.println("No active hero? try to load one by clicking the button "); }
    }

    public void increaseAgility()
    {
        int costFormulaHero1 = (int) (playerHero1.getAgility() * 69);
        int costFormulaHero2 = (int) (playerHero2.getAgility() * 69);
        int costFormulaHero3 = (int) (playerHero3.getAgility() * 69);

        if (playerHero1.getActive())
        {
            if (playerHero1.getExperience() >= costFormulaHero1)
            {
                playerHero1.setExperience((int) (playerHero1.getExperience() - (costFormulaHero1)));
                playerHero1.setAgility((int) (playerHero1.getAgility() + 1));

                playerHero1.updateAllStats();
                loadHeroData1();
            }
            else { System.out.println("Not enough exp! "); }
        }
        else if (playerHero2.getActive())
        {
            if (playerHero2.getExperience() >= costFormulaHero2)
            {
                playerHero2.setExperience((int) (playerHero2.getExperience() - (costFormulaHero2)));
                playerHero2.setAgility((int) (playerHero2.getAgility() + 1));

                playerHero2.updateAllStats();
                loadHeroData2();
            }
            else { System.out.println("Not enough exp! "); }
        }
        else if (playerHero3.getActive())
        {
            if (playerHero3.getExperience() >= costFormulaHero3)
            {
                playerHero3.setExperience((int) (playerHero3.getExperience() - (costFormulaHero3)));
                playerHero3.setAgility((int) (playerHero3.getAgility() + 1));

                playerHero3.updateAllStats();
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
