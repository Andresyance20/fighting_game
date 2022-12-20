package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Random;


public class FightSceneController {



    private Scene mainScene;
    private Scene loseScene;

    private Hero playerHero1;
    private Hero playerHero2;
    private Hero playerHero3;
    private Hero playerActiveHero;
    private Hero heroAI;
    private int money;
    private int hpPotionCount;
    private int attackPotionCount;
    private int superPotionCount;


    // update every turn
    public int turn_count = 0;
    public boolean playerTurn = true;

    // when this is false, we end the fight, like 0 hp or surrender.
    public boolean combatActive = true;

    public boolean win = false;


    // set data
    public void setToMainMenu(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai, int money, int hpCount, int attackCount, int superCount) {
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

    public void setToLoseScene(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai, int money, int hpCount, int attackCount, int superCount) {
        loseScene = scene;
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


    public Boolean Result()
    {

        return null;
    }



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

        setToMainMenu(mainScene, playerHero1, playerHero2, playerHero3, playerActiveHero, heroAI, money, hpPotionCount,attackPotionCount, superPotionCount);


        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);

    }

    // lose scene for surrender or when player reaches 0 hp
    public void openLoseScene(ActionEvent actionEvent) {

        // you dont need this, just do a set to loss scene method call after the activehero checks but before the primary stage change
        playerHero1 = playerHero1;
        playerHero2 = playerHero2;
        playerHero3 = playerHero3;
        heroAI = heroAI;

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
        

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(loseScene);
    }


    public void inventoryButtonClick()
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



//        go to inventory of the hero
    }

    public void supermoveButtonClick() throws InterruptedException {
        button_supermove.setDisable(true);
        Thread.sleep(100);


        if (playerTurn == true)
        {

            if (playerActiveHero.getCurrentSuperCharge() == playerActiveHero.getMaxSuperCharge())
            {
                System.out.println("Player supermove");
                heroAI.setCurrenthp(heroAI.getCurrenthp() - (playerActiveHero.getAttackDamage() * 3));
                playerActiveHero.setCurrentSuperCharge(0);

                updateTurn();
                responseHeroAiAttack();
            }
            else if (playerActiveHero.getCurrentSuperCharge() < playerActiveHero.getMaxSuperCharge())
            {
             System.out.println("You need 100 supercharge to do this move");
            }
        }

        // After an action, the turn is done.

    }


    public void actionButtonClick() throws InterruptedException {
// disable button so player cant SPAM

        button_action.setDisable(true);
        Thread.sleep(100);
        System.out.println("Player attack. ");

        // If they did not dodge, damage happens
        if (calculateDodge() == false)
        {
            // player attacking
            if (playerTurn == true)
            {
                // deal dmg
                heroAI.setCurrenthp(heroAI.getCurrenthp() - playerActiveHero.getAttackDamage());
                // increase supercharge if not full
                if (playerActiveHero.getCurrentSuperCharge() < 100)
                {
                    playerActiveHero.setCurrentSuperCharge(playerActiveHero.getCurrentSuperCharge() + playerActiveHero.getAttackDamage());
                    // don't overfill the supermove charge bar
                    if (playerActiveHero.getCurrentSuperCharge() > playerActiveHero.getMaxSuperCharge())
                    {
                        playerActiveHero.setCurrentSuperCharge(100);
                    }
//                    enemy gets some charge from taking damage
                    heroAI.setCurrentSuperCharge(heroAI.getCurrentSuperCharge() + (playerActiveHero.getAttackDamage() / 2));
                    if (heroAI.getCurrentSuperCharge() > heroAI.getMaxSuperCharge())
                    {
                        heroAI.setCurrentSuperCharge(100);
                    }
                }
            }

//             i guess we dont need to hardcode the AI response here, but it's ok for our purposes
            // AI attacking


            else if (playerTurn == false)
            {


            }
        }
// After an action, calculations happen and the turn is done.
        updateTurn();
        // updates the turn count, switches the turn to the other, and calls the loadfightscene data

        // ai turn
        Thread.sleep(400);
        responseHeroAiAttack();
    }


    // the enemy turn logic
    public void responseHeroAiAttack() throws InterruptedException {
        // player doesn't dodge

        System.out.println("Enemy attack. ");
        if (calculateDodge() == false)
        {
            if (heroAI.getCurrentSuperCharge() == heroAI.getMaxSuperCharge())
            {
//              do supermove
                responseHeroAiSupermove();
            }

            else
            {
                playerActiveHero.setCurrenthp(playerActiveHero.getCurrenthp() - heroAI.getAttackDamage());
                if (heroAI.getCurrentSuperCharge() < 100)
                {
                    heroAI.setCurrentSuperCharge(heroAI.currentSuperCharge + heroAI.getAttackDamage());
                    if (heroAI.getCurrentSuperCharge() > heroAI.getMaxSuperCharge())
                    {
                        heroAI.setCurrentSuperCharge(100);
                    }

                    playerActiveHero.setCurrentSuperCharge(playerActiveHero.getCurrentSuperCharge() + (heroAI.getAttackDamage() / 2));
                    if (playerActiveHero.getCurrentSuperCharge() > playerActiveHero.getMaxSuperCharge())
                    {
                        playerActiveHero.setCurrentSuperCharge(100);
                    }
                }
            }
            // pass turn back to player
            updateTurn();
        }

    }

    public void responseHeroAiSupermove()
    {
        if (heroAI.getCurrentSuperCharge() == heroAI.getMaxSuperCharge())
        {
            playerActiveHero.setCurrenthp(playerActiveHero.getCurrenthp() - (heroAI.getAttackDamage() * 3));
            heroAI.setCurrentSuperCharge(0);
        }
    }





    // let's assume you can only dodge normal attacks (so no dodge for supermove)
    public boolean calculateDodge()
    {
        Random rng = new Random();

        if (playerTurn == true)
        {
            // check player turn
            if (rng.nextInt(100) < playerActiveHero.getDodge())
            {
                System.out.println("The enemy dodged!");
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (playerTurn == false)
        {
            // check AI turn
            if (rng.nextInt(100) < heroAI.getDodge())
            {
                System.out.println("The player dodged!");
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }



    public void updateTurn() throws InterruptedException {
        // check to see if loss
        if (playerActiveHero.getCurrenthp() <= 0)
        {
//            go to the loss scene
            playerActiveHero.setLossCount(playerActiveHero.getLossCount() + 1);

            // heal the heros
            playerActiveHero.reset_hero_full_recovery();
            heroAI.reset_hero_full_recovery();

            button_surrender.fire();
        }
        else if (heroAI.getCurrenthp() <= 0)
        {
//            claim prize for victory
            playerActiveHero.setExperience(playerActiveHero.getExperience() + heroAI.getExperience());
            playerActiveHero.setMoney(playerActiveHero.getMoney() + heroAI.getMoney());
            playerActiveHero.setVictoryCount((playerActiveHero.getVictoryCount()) + 1);


            playerActiveHero.reset_hero_full_recovery();
            heroAI.reset_hero_full_recovery();

//            why don't we have a win scene?
//            call the button.fire() for it here
        }


        // switch turns
        if (playerTurn == true)
        {
            // really only the player needs a turn count

            turn_count += 1;
            playerTurn = false;
            loadFightSceneData();
            Thread.sleep(100);
//            System.out.println("Enemy turn");
        }
        else if (playerTurn == false)
        {
            playerTurn = true;
            // player can click buttons again
//            Thread.sleep(700);
            loadFightSceneData();
            Thread.sleep(100);
            button_action.setDisable(false);
            button_supermove.setDisable(false);
//            System.out.println("Player turn");
        }
// update data to reflect changes
    }





    @FXML
    private Label hero_player_text_name;
    @FXML
    private Label hero_ai_text_name;
    @FXML
    private Label hero_player_hp_text;
    @FXML
    private Label hero_ai_hp_text;

    @FXML
    private Label hero_player_super_text;
    @FXML
    private Label hero_ai_super_text;
    @FXML
    private Label turn_count_text;




    public void loadFightSceneData()
    {
// we do always need this check to stay updated otherwise it won't be the correct data displayed
        if (playerHero1.getActive() == true)
        {
//            System.out.println("Hero1 is: " + playerHero1.getActive());
            playerActiveHero = playerHero1;
        }
        if (playerHero2.getActive() == true)
        {
//            System.out.println("Hero2 is: " + playerHero2.getActive());
            playerActiveHero = playerHero2;
        }
        if (playerHero3.getActive() == true)
        {
//            System.out.println("Hero3 is: " + playerHero3.getActive());
            playerActiveHero = playerHero3;
        }

        hero_player_text_name.setText("" + playerActiveHero.getName());
        hero_player_hp_text.setText("" + (playerActiveHero.getCurrenthp() + " / " + playerActiveHero.getMaxhp()));
        hero_player_super_text.setText("" + playerActiveHero.getCurrentSuperCharge() + " / " + playerActiveHero.getMaxSuperCharge());

        hero_player_hp_text.setStyle("-fx-background-color: limegreen");
        hero_player_super_text.setStyle("-fx-background-color: lightblue");

        hero_ai_text_name.setText("" + heroAI.getName());
        hero_ai_hp_text.setText("" + (heroAI.getCurrenthp() + " / " + heroAI.getMaxhp()));
        hero_ai_super_text.setText("" + heroAI.getCurrentSuperCharge() + " / " + heroAI.getMaxSuperCharge());

        hero_ai_hp_text.setStyle("-fx-background-color: limegreen");
        hero_ai_super_text.setStyle("-fx-background-color: lightblue");

        turn_count_text.setText("Turn Count: " + turn_count);



    }

    public Button button_menu;



    // currently our attack button
    public Button button_action;
    public Button button_supermove;

    //  see above. not sure how we want to do this (UI mockup is different)
    public Button button_abilities;

    public Button button_inventory;
    public Button button_surrender;




}
