package com.example.javafxtrytwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    public static void main(String[] args) {

        // Might need to make these in the MainController instead
        // we need 4 persistent heroes total, 3 for player to switch around, and 1 to represent an enemy.
//        Hero playerHero1 = new Hero("First Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
//        Hero playerHero2 = new Hero("Second Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
//        Hero playerHero3 = new Hero("Third Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
//        Hero aiHero = new Hero("AI Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);


        //        hero.print_hero_info();
//        System.out.println(playerHero1 + " from the main print");

        System.out.println("console test text in main");
        launch();
    }


    @Override
//    stage << scene << root node << node
//    scene requires a stage and stage construction requires a root node
//    our first stage is premade in the background here I think.
    public void start(Stage primaryStage)
    {
//        try {
//            Parent mainRoot = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
//            Scene scene = new Scene(mainRoot, 1280, 720, Color.GRAY);
//            primaryStage.setTitle("FIGHT GAME!");
//            primaryStage.setScene(scene);
//
//            primaryStage.show();
//
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }



        Hero playerHero1 = new Hero("First Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
        Hero playerHero2 = new Hero("Second Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
        Hero playerHero3 = new Hero("Third Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
        Hero aiHero = new Hero("AI Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);


        // older attempt at keeping data/scenes static, it worked, data is persistent but still issue with not able to access data.
        // 2pm I think it can work actually! trying a 3-way communication, if this works, it works and will scale
        try {
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent mainRoot = mainLoader.load();
            Scene mainScene = new Scene(mainRoot, 1280, 720);

            FXMLLoader fightSceneSetupLoader = new FXMLLoader(getClass().getResource("FightSceneSetup.fxml"));
            Parent fightSceneSetupRoot = fightSceneSetupLoader.load();
            Scene fightSceneSetupScene = new Scene(fightSceneSetupRoot, 1280, 720);


            FXMLLoader fightSceneLoader = new FXMLLoader(getClass().getResource("FightScene.fxml"));
            Parent fightSceneRoot = fightSceneLoader.load();
            Scene fightSceneScene = new Scene(fightSceneRoot, 1280, 720);


            // injecting second scene into the controller of the first scene
            MainController mainController = (MainController) mainLoader.getController();
            mainController.setToFightSceneSetup(fightSceneSetupScene, playerHero1);

            // injecting first scene into the controller of the second scene
            FightSceneSetupController fightSceneSetupController = (FightSceneSetupController) fightSceneSetupLoader.getController();
            fightSceneSetupController.setToMainMenu(mainScene, playerHero1);
            fightSceneSetupController.setToFightScene(fightSceneScene, playerHero1);


            // so, passing reference to the scene and hero object and storing it inside a private variable inside this specific control, basically we just copy contents of hero onto another hero object.

            FightSceneController fightSceneController = (FightSceneController) fightSceneLoader.getController();
            fightSceneController.setToMainMenu(mainScene, playerHero1);




            //            MainController mainController = new MainController();
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setController(mainController);



//            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
//        Group root = new Group(); // Create the root node to arrange all the nodes
//            Scene scene = new Scene(root, 1280, 720, Color.GRAY); // Create the scene + add root node to the scene

            primaryStage.setTitle("FIGHT GAME!");
            primaryStage.setResizable(false);
//    scene is a "drawing surface for graphical content and a container for nodes"
            primaryStage.setScene(mainScene); // Add scene to the stage
            primaryStage.show(); // Render the stage. This is always the last step.

//            Scene main_menu = new Scene(root, 1280, 720); // can set initial size here
//            stage.setTitle("FIGHT GAME!"); // name?
//            stage.setScene(main_menu);
//            stage.show();
            } catch (Exception e) {
                e.printStackTrace();
        }
    }
}


