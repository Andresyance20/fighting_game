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

    // make the scene and hero in here but we copy data into them (via methods here) from the main when we call this MainController.
    private Scene fightSceneSetupScene;
    private Hero hero1;
    Stage stage;


    // set the data
    public void setToFightSceneSetup(Scene scene, Hero hero)
    {
        fightSceneSetupScene = scene;
        hero1 = hero;
        System.out.println(hero1.getName() + " From main controller");
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
        System.out.println(hero1 + " object ID from MainController"); // print hero object id
        System.out.println("Hero HP is: " + hero1.getCurrenthp());
    }
    @FXML
    protected void optionsButtonClick() {
        optionsButtonText.setText("Options are not yet implemented!");
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