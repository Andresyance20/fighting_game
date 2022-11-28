package com.example.javafxtrytwo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

// This is where we do most of the game I think.
// going to need buttons/methods for each action?



public class FightSceneController {


    private Stage stage;
    private Scene scene;
    private Parent root;



    public void switchToMainMenu(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow(); // cast to the stage
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public void inventoryButtonClick()
    {
        System.out.println("click registered for inventory");
//        go to inventory of the hero
    }

    public void supermoveButtonClick()
    {
        System.out.println("click registered for supermove");
//        check if charged or not
    }

    public void surrenderButtonClick()
    {
        System.out.println("click registered for surrender");
//        go to results ?
    }

    public void actionButtonClick()
    {
        System.out.println("click registered for action");
        // an attack/ability?
    }


    public Button button_menu;


//    i still dont know how we wanna do abilities but here is a dummy action button
    public Button button_action;
    //  see above. not sure how we want to do this (UI mockup is different)
    public Button button_abilities;

    public Button button_inventory;
    public Button button_supermove;
    public Button button_surrender;





}
