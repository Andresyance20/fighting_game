package com.example.javafxtrytwo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

import java.io.IOException;

// extend FightSceneSetup ?
public class FightSceneSetupController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Scene mainScene;

    public void setToMainMenu(Scene scene)
    {
        mainScene = scene;
    }


    public void openMainMenu(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
    }


    Hero hero = new Hero("First Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);

    public void switchToMainMenu(Scene actionEvent) throws IOException {

//        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("FightSceneSetup.fxml"));
//        HelloController helloController = loader.getController();
//        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));


        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        root = loader.load();
//        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow(); // bruh this is ridiculous to just jump into
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




    @FXML
    protected void inspectHeroButtonClick() {
//        hero.print_hero_info();
        System.out.println("click registered for inspect hero");
        System.out.println(hero); // print hero object id
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

