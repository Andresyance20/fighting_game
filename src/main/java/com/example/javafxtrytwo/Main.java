package com.example.javafxtrytwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;


public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
//    stage << scene << root node << node
//    scene requires a stage and stage construction requires a root node
//    our first stage is premade in the background here I think.
    public void start(Stage primaryStage)
    {
        // Construct heroes here, so they are passable as parameters in the javafx scope.
        // we need 4 persistent heroes total, 3 for player to switch around, and 1 to represent an enemy.
        Hero playerHero1 = new Hero("First Hero", 100, 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
        Hero playerHero2 = new Hero("Second Hero", 100, 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
        Hero playerHero3 = new Hero("Third Hero", 100, 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
        Hero aiHero = new Hero("AI Hero", 100, 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);

//        now that I am thinking about it, we might need to premake our other classes, too, such as fightscenesetup
//        or any other data we need to access.
//        no matter, it will follow the same process, so it is solved, and it can be done.

        // add background
        /*Image image  = new Image("background2.jpg");
        ImageView imageView = new ImageView(image);

        Group root = new Group();
        root.getChildren().addAll(imageView);

        Scene scene = new Scene(root,500,300);
        primaryStage.setScene(scene);*/














        try {
            // Making loaders for controllers.
            // all of them will be made here. Feel free to observe/copy patterns and get these done.
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent mainRoot = mainLoader.load();
            Scene mainScene = new Scene(mainRoot, 1080, 600);

            FXMLLoader fightSceneSetupLoader = new FXMLLoader(getClass().getResource("FightSceneSetup.fxml"));
            Parent fightSceneSetupRoot = fightSceneSetupLoader.load();
            Scene fightSceneSetupScene = new Scene(fightSceneSetupRoot, 1080, 600);


            FXMLLoader fightSceneLoader = new FXMLLoader(getClass().getResource("FightScene.fxml"));
            Parent fightSceneRoot = fightSceneLoader.load();
            Scene fightSceneScene = new Scene(fightSceneRoot, 1080, 600);

            FXMLLoader loseSceneLoader = new FXMLLoader(getClass().getResource("LoseScene.fxml"));
            Parent loseSceneRoot = loseSceneLoader.load();
            Scene loseSceneScene = new Scene(loseSceneRoot, 1080, 600);


            FXMLLoader heroSheetLoader = new FXMLLoader(getClass().getResource("HeroSheet.fxml"));
            Parent heroSheetRoot = heroSheetLoader.load();
            Scene heroSheetScene = new Scene(heroSheetRoot, 1080, 600);




            // These are how we pass data to the controller classes, check the controller classes to see the data copy
            // injecting second scene into the controller of the first scene
            MainController mainController = (MainController) mainLoader.getController();
            mainController.setToFightSceneSetup(fightSceneSetupScene, playerHero1);
            //    To do:
            //    add logic for switchToShopScene (will require heros / inventory)
            //    add logic for switchToOptionScene (idk if we need to pass references here? maybe because it might lose reference on reenter? I am unsure)
            //    make controllers + fxml files for them.



            // injecting first scene into the controller of the second scene
            FightSceneSetupController fightSceneSetupController = (FightSceneSetupController) fightSceneSetupLoader.getController();
            // example: we access the "fightscenesetup controller" class methods(activate on buttons) and pass in the data we have here.
            // idk if that's the EXACT process, there's a lot of parts to it.
            fightSceneSetupController.setToMainMenu(mainScene, playerHero1);
            fightSceneSetupController.setToFightScene(fightSceneScene, playerHero1);
            fightSceneSetupController.setToHeroSheet(heroSheetScene, playerHero1);
            // add navigation method to fight sheet


            // so, passing reference to the scene and hero object and storing it inside a private variable inside this specific control, basically we just copy contents of hero onto another hero object.
            FightSceneController fightSceneController = (FightSceneController) fightSceneLoader.getController();
            fightSceneController.setToMainMenu(mainScene, playerHero1);
            fightSceneController.setToLoseScene(loseSceneScene, playerHero1);

            LoseSceneController loseSceneController = (LoseSceneController) loseSceneLoader.getController();
            loseSceneController.setToMainMenu(mainScene, playerHero1);
            loseSceneController.setToFightScene(fightSceneScene, playerHero1);


            HeroSheetController heroSheetController = (HeroSheetController) heroSheetLoader.getController();
            heroSheetController.setToFightSceneSetup(fightSceneSetupScene, playerHero1);

//                    heroSheetLoader
//                    heroSheetRoot
//                    heroSheetScene




            primaryStage.setTitle("FIGHT GAME!");
            primaryStage.setResizable(true);
//    scene is a "drawing surface for graphical content and a container for nodes"
            primaryStage.setScene(mainScene); // Add scene to the stage
            primaryStage.show(); // Render the stage. This is always the last step.

            } catch (Exception e) {
                e.printStackTrace();
        }
    }
}


