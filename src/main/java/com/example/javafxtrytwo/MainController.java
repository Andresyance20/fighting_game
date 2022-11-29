// This is the control for our javaFX HelloApplication (our main(start) + main menu)

package com.example.javafxtrytwo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;


    Hero hero = new Hero("First Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);



    private Scene fightSceneSetupScene;

    public void setToFightSceneSetup(Scene scene)
    {
        fightSceneSetupScene = scene;
    }

    public void openFightSceneSetup(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(fightSceneSetupScene);
    }








//    was testing initialize, if you need any data, you can load it before the view is onscreen.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // if we initialize the
        Hero hero = new Hero("First Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
        System.out.println("Does this called each time we go back to mainmenu?"); // not in new setup
    }

//    FightSceneSetup fightSceneSetup = new FightSceneSetup(hero,"Default map", "easy");



    public void switchToFightSceneSetup(Scene actionEvent) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("FightSceneSetup.fxml"));
//        root = loader.load();

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("FightSceneSetup.fxml"));
//        Parent root = loader.load();
//        FightSceneSetupController fightSceneSetupController = loader.getController();
//
//// messy right now but the logic should work for access to hero methods in the controllers?
//        fightSceneSetupController.hero.print_hero_info();
//        fightSceneSetupController.hero.takeDamage(1);
//        System.out.println(" HP: " + fightSceneSetupController.hero.getHp());

//        System.out.println(fightSceneSetupController.hero);
//        So current issue seems to be that we are creating a new hero each time.

        root = FXMLLoader.load(getClass().getResource("FightSceneSetup.fxml"));
//        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        name the scene?
        scene = new Scene(root,1280, 720);
        stage.setScene(scene);
        stage.show();
    }






//    To do:
//    public void switchToShopScene(){}
//    public void switchToOptionScene(){}
//    make controllers + fxml files for them.



    public Button button_start;
    public Button button_shop;
    public Button button_options;
    public Button button_exit;

    @FXML
    private Label shopButtonText;
    @FXML
    private Label optionsButtonText;


    // so here we'd want more buttons that on click will do a transition into a different scene(node)?
    @FXML
    protected void shopButtonClick() {
        shopButtonText.setText("Shop is not yet implemented!");
        System.out.println("click registered for shop button");
        System.out.println(hero); // print hero object id
    }
    @FXML
    protected void optionsButtonClick() {
        optionsButtonText.setText("Options are not yet implemented!");
    }

    @FXML
    protected void exitButtonClick() {Platform.exit(); }



}