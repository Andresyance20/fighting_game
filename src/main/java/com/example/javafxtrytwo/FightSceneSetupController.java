package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

// extend FightSceneSetup ?
public class FightSceneSetupController {

    private Stage stage;
    private Scene scene;
    private Parent root;



    Hero hero = new Hero("First Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);


    // of course the tutorials are outdated and you have to update parts to w/e standardization they use now
//    "javafx.event.ActionEvent actionEvent" NOT "ActionEvent event"
    public void switchToMainMenu(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = loader.load();

        HelloController helloController = loader.getController();

//        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow(); // bruh this is ridiculous to just jump into
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToFightScene(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FightScene.fxml"));
        root = loader.load();

//        HelloController helloController = loader.getController();

//        Parent root = FXMLLoader.load(getClass().getResource("FightScene.fxml"));

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }


    public Button button_menu;
    public Button button_goto_fight_scene;
    public Button button_inspect_hero1;
    public Button button_inspect_hero2;
    public Button button_inspect_hero3;
    public Button button_set_difficulty;
    public Button button_set_map;


    //    needs to be implemented still, but showcases that it works
//    i am not sure how to pass in the hero object? Do we need to override the method?
//    my confusion comes form the formal parameters
    @FXML
    protected void inspectHeroButtonClick() {
//        hero.print_hero_info();
        System.out.println("click registered for inspect hero");
        System.out.println(hero);
    }

    @FXML
    protected void mapButtonClick() {
        System.out.println("click registered for map");
    }

    @FXML
    protected void difficultyButtonClick() {
        System.out.println("click registered for difficulty");

    }

}

