package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

// This is where we do most of the game I think.
// going to need buttons/methods for each action?



public class FightSceneController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    private Scene mainScene;
    private Scene fightSceneSetup;

    private Hero hero1;

    public void setToMainMenu(Scene scene, Hero hero) {
        mainScene = scene;
        hero1 = hero;
        System.out.println(hero1.getName() + " From fightScene controller");

    }

    public void openMainMenu(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
    }





    Hero hero = new Hero("First Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
    Hero enemy = new Hero("First Hero", 100, 5, 5, 5, 5, 0, 1, 0, 0, 0, 0, 66, 200);
    public void switchToMainMenu(javafx.event.ActionEvent actionEvent) throws IOException {

//        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        root = loader.load();

//        FightSceneSetupController fightSceneSetupController = loader.getController();

//        FightSceneController fightSceneController = loader.getController();
//        fightSceneSetupController.hero.print_hero_info();

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow(); // cast to the stage


        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLoseScreen(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoseScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow(); // cast to the stage
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToFightScreen(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FightScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow(); // cast to the stage
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public void inventoryButtonClick()
    {
        System.out.println("click registered for inventory");
        System.out.println(hero1 + " object ID from FightScene Controller"); // print hero object id
        System.out.println("Hero HP is: " + hero1.getHp());
        hero1.setHp(hero1.getHp()-1);
        System.out.println("Hero HP is: " + hero1.getHp());
//        System.out.println(fightSceneSetupController.hero);
//        System.out.println(hero);

//        go to inventory of the hero
    }

    public void supermoveButtonClick()
    {
        System.out.println("click registered for supermove");
//        check if charged or not
    }

    public void actionButtonClick()
    {
        System.out.println("click registered for action");
        double changedHpPlayer;
        double changedHPComp;
        changedHPComp = hero.getStrength();
        changedHpPlayer = enemy.getStrength();
        
    }

    public Label label_player1;
    public Label label_player2;
    public Button button_menu;
    public Button button_losetomenu;
    public Button button_retry;

//    i still dont know how we wanna do abilities but here is a dummy action button
    public Button button_action;
    //  see above. not sure how we want to do this (UI mockup is different)
    public Button button_abilities;

    public Button button_inventory;
    public Button button_supermove;
    public Button button_surrender;




}
