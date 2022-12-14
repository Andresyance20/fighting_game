// This is the controller for our javaFX FXML files
// It is going to be a single controller so we don't need to worry about data being inaccessible

package com.example.javafxtrytwo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainController {


//    in here we could try to write a fast loop to go visit each scene to initialize it?
//    so data won't be null and the scene will be accessible?





    // make the scene and hero in here but we copy data into them (via methods here) from the main when we call this MainController.
    private Scene fightSceneSetupScene;
    private Hero playerHero1;
    private Hero playerHero2;
    private Hero playerHero3;
    private Hero playerActiveHero;
    private Hero heroAI;

    Stage stage;


    // set the data
    public void setToFightSceneSetup(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai)
    {
        fightSceneSetupScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
    }

    // set the stage and scene
    public void openFightSceneSetup(ActionEvent actionEvent)
    {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(fightSceneSetupScene);
    }



//    was testing initialize, if you need any data, you can load it before the view is onscreen.
//    idk that we will need to do this, but if we have issues with null data, this might be a solution so I will leave it here for now.

//    public class MainController implements Initializable {
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//    }


    public Button button_start;
    public Button button_shop;
    public Button button_options;
    public Button button_exit;

    @FXML
    private Label shopButtonText;
    @FXML
    private Label optionsButtonText;
    @FXML
    private AnchorPane anchorPane;


    // some testing is leftover from troubleshooting, good for getting a feel of the program functionality.
    @FXML
    protected void shopButtonClick() {
        shopButtonText.setText("Shop is not yet implemented!");
        System.out.println("click registered for shop button");
        System.out.println(playerHero1 + " object ID from MainController"); // print hero object id
        System.out.println("Hero HP is: " + playerHero1.getCurrenthp());
    }
    @FXML
    protected void optionsButtonClick() {
        optionsButtonText.setText("Options are not yet implemented!");
        // testing changing text, seems labels ar easier than text
        optionsButtonText.setText(playerHero1.getName());


    }

    @FXML
    protected void exitButtonClick(ActionEvent actionEvent) {


        Alert  alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to quit the game!");
        alert.setContentText("Are you sure?");

        if(alert.showAndWait().get() == ButtonType.OK)
        {
            System.out.println("you quit successfully");
            Platform.exit();
        }
    }





}