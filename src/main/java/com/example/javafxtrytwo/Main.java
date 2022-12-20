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
    public void start(Stage primaryStage)
    {
        // Construct heroes or other data here, so they are passable as parameters in the javafx scope.
        // we need 4 persistent heroes total, 3 for player to switch around, and 1 to represent an enemy.
        Hero playerHero1 = new Hero(false,"Hero1 name", 150, 150, 10, 10, 10,  5,5, 0, 100,1, 10000, 0, 0, 0, 66, 200);
        Hero playerHero2 = new Hero(false,"Hero2 name", 150, 150, 10, 10, 10, 5, 5, 0,100, 1, 10000, 0, 0, 0, 66, 200);
        Hero playerHero3 = new Hero(false,"Hero3 name", 150, 150, 10, 10, 10, 5, 5, 0,100, 1, 10000, 0, 0, 0, 66, 200);

        // TESTING
        Hero playerActiveHero = new Hero(false,"Default active Hero", 100, 100, 10, 10, 10, 5, 5, 100,0, 1, 0, 0, 0, 0, 66, 200);
        Hero aiHero = new Hero(false,"AI Hero", 100, 100, 10, 10, 10, 5, 5, 0, 100,1, 0, 0, 0, 0, 66, 200);

        // default money supply
        int money = 500;

        // default potion count
        int hpPotionCount = 0;
        int attackPotionCount = 0;
        int superPotionCount = 0;

        // add background
        /*Image image  = new Image("background2.jpg");
        ImageView imageView = new ImageView(image);

        Group root = new Group();
        root.getChildren().addAll(imageView);

        Scene scene = new Scene(root,500,300);
        primaryStage.setScene(scene);*/



//    stage << scene << root node << node
//    scene requires a stage and stage construction requires a root node
//    our first stage is premade in the background here I think.
        try {
            // Making loaders for controllers.
            // all of them will be made here. Feel free to observe/copy patterns and get these done.
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent mainRoot = mainLoader.load();
            mainRoot.setStyle("-fx-background-color: blue;");
            Scene mainScene = new Scene(mainRoot, 1080, 600);




            FXMLLoader fightSceneSetupLoader = new FXMLLoader(getClass().getResource("FightSceneSetup.fxml"));
            Parent fightSceneSetupRoot = fightSceneSetupLoader.load();
            fightSceneSetupRoot.setStyle("-fx-background-color: blue");
            Scene fightSceneSetupScene = new Scene(fightSceneSetupRoot, 1080, 600);


            FXMLLoader fightSceneLoader = new FXMLLoader(getClass().getResource("FightScene.fxml"));
            Parent fightSceneRoot = fightSceneLoader.load();
            fightSceneRoot.setStyle("-fx-background-color: blue;");
            Scene fightSceneScene = new Scene(fightSceneRoot, 1080, 600);

            FXMLLoader loseSceneLoader = new FXMLLoader(getClass().getResource("LoseScene.fxml"));
            Parent loseSceneRoot = loseSceneLoader.load();
            loseSceneRoot.setStyle("-fx-background-color: blue;");
            Scene loseSceneScene = new Scene(loseSceneRoot, 1080, 600);


            FXMLLoader heroSheetLoader = new FXMLLoader(getClass().getResource("HeroSheet.fxml"));
            Parent heroSheetRoot = heroSheetLoader.load();
            heroSheetRoot.setStyle("-fx-background-color: blue;");
            Scene heroSheetScene = new Scene(heroSheetRoot, 1080, 600);

            FXMLLoader shopLoader = new FXMLLoader(getClass().getResource("ShopScene.fxml"));
            Parent shopRoot = shopLoader.load();
            ShopController shopCont = shopLoader.getController();
            shopCont.displayMoney(String.valueOf(money));
            shopRoot.setStyle("-fx-background-color: blue;");
            Scene shopScene = new Scene(shopRoot, 1080, 600);

            FXMLLoader ResultLoader = new FXMLLoader(getClass().getResource("Result.fxml"));
            Parent ResultRoot = ResultLoader.load();
            ResultRoot.setStyle("-fx-background-color: blue;");
            Scene ResultScene = new Scene(ResultRoot, 1080, 600);




            // These are how we pass data to the controller classes, check the controller classes to see the data copy
            // injecting second scene into the controller of the first scene
            MainController mainController = (MainController) mainLoader.getController();
            mainController.setToFightSceneSetup(fightSceneSetupScene, playerHero1, playerHero2, playerHero3, playerActiveHero, aiHero, money, hpPotionCount, attackPotionCount, superPotionCount);
            mainController.setToShop(shopScene, playerHero1, playerHero2, playerHero3, playerActiveHero, aiHero, money, hpPotionCount, attackPotionCount, superPotionCount);
            //    To do:
            //    add logic for switchToShopScene (will require heros / inventory)
            //    add logic for switchToOptionScene (idk if we need to pass references here? maybe because it might lose reference on reenter? I am unsure)
            //    make controllers + fxml files for them.


            HeroSheetController heroSheetController = (HeroSheetController) heroSheetLoader.getController();
            heroSheetController.setToFightSceneSetup(fightSceneSetupScene, playerHero1, playerHero2, playerHero3, playerActiveHero, aiHero);


            // so, passing reference to the scene and hero object and storing it inside a private variable inside this specific control, basically we just copy contents of hero onto another hero object.
            FightSceneController fightSceneController = (FightSceneController) fightSceneLoader.getController();
            fightSceneController.setToMainMenu(mainScene, playerHero1, playerHero2, playerHero3, playerActiveHero, aiHero, money, hpPotionCount, attackPotionCount, superPotionCount);
            fightSceneController.setToLoseScene(loseSceneScene, playerHero1, playerHero2, playerHero3, playerActiveHero, aiHero, money, hpPotionCount, attackPotionCount, superPotionCount);


            // injecting first scene into the controller of the second scene
            FightSceneSetupController fightSceneSetupController = (FightSceneSetupController) fightSceneSetupLoader.getController();
            // example: we access the "fightscenesetup controller" class methods(activate on buttons) and pass in the data we have here.
            // idk if that's the EXACT process, there's a lot of parts to it.
            fightSceneSetupController.setToMainMenu(mainScene, playerHero1, playerHero2, playerHero3, playerActiveHero, aiHero, money, hpPotionCount, attackPotionCount, superPotionCount);
            fightSceneSetupController.setToFightScene(fightSceneScene, playerHero1, playerHero2, playerHero3, playerActiveHero, aiHero, fightSceneController, money, hpPotionCount, attackPotionCount, superPotionCount);
            fightSceneSetupController.setToHeroSheet(heroSheetScene, playerHero1, playerHero2, playerHero3, playerActiveHero, aiHero, heroSheetController);
//            fightSceneSetupController.updateHeroInfo();



            LoseSceneController loseSceneController = (LoseSceneController) loseSceneLoader.getController();
            loseSceneController.setToMainMenu(mainScene, playerHero1, playerHero2, playerHero3, playerActiveHero, aiHero);
            loseSceneController.setToFightScene(fightSceneScene, playerHero1, playerHero2, playerHero3, playerActiveHero, aiHero);

            ShopController shopController = (ShopController) shopLoader.getController();
            shopController.setToMainMenu(mainScene, playerHero1, playerHero2, playerHero3, playerActiveHero, aiHero, money, hpPotionCount, attackPotionCount, superPotionCount);

            //ResultController ResultController = (ResultController) ResultLoader.getController();

           /* ResultController.setToMainMenu(mainScene, playerHero1, playerHero2, playerHero3);
            ResultController.setToFightScene(fightSceneScene, playerHero1, playerHero2, playerHero3);

*/

            primaryStage.setTitle("Way of the Fist");
            primaryStage.setResizable(true);
//    scene is a "drawing surface for graphical content and a container for nodes"
            primaryStage.setScene(mainScene);
            // Add scene to the stage
            primaryStage.show(); // Render the stage. This is always the last step.

            } catch (Exception e) {
                e.printStackTrace();
        }
    }
}


