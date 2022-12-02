package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class FightSceneController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    private Scene mainScene;
    private Scene loseScene;
    private Scene fightSceneSetup;

    private Hero hero1;

    // set data
    public void setToMainMenu(Scene scene, Hero hero) {
        mainScene = scene;
        hero1 = hero;
        System.out.println(hero1.getName() + " From fightScene controller");
    }

    public void setToLoseScene(Scene scene, Hero hero) {
        loseScene = scene;
        hero1 = hero;
        System.out.println(hero1.getName() + " From fightScene controller");
    }
    // move scene
    // main menu
    public void openMainMenu(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
    }
    // lose scene
    public void openLoseScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(loseScene);
    }

    // back to fight scene


    // will need to update these to be from the main via new access method of copying data



    // these are older implementation of transitions that won't persist data
    // to be updated to new way



//    some troubleshooting prints
    public void inventoryButtonClick()
    {
        System.out.println("click registered for inventory");
        System.out.println(hero1 + " object ID from FightScene Controller"); // print hero object id
        System.out.println("Hero HP is: " + hero1.getHp());
        hero1.setHp(hero1.getHp()-1);
        System.out.println("Hero HP is: " + hero1.getHp());

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
    }

    public TextField txt_p1Hp;
    public TextField txt_p2Hp;
    public Button button_menu;

//    i still dont know how we wanna do abilities but here is a dummy action button
    public Button button_action;
    //  see above. not sure how we want to do this (UI mockup is different)
    public Button button_abilities;

    public Button button_inventory;
    public Button button_supermove;
    public Button button_surrender;




}
