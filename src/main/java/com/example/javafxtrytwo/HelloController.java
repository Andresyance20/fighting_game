// This is the control for our javaFX HelloApplication (our main(start) + main menu)

package com.example.javafxtrytwo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;


//            so like here, i think we can create hero and pass it through the scenes/controllers/classes
        Hero hero = new Hero("First Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);

//        FightSceneSetup should have 3 heroes configured to pick from. So by default we should have them created here?



    public void switchToFightSceneSetup(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FightSceneSetup.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root,1280, 720);
        stage.setScene(scene);
        stage.show();
    }


//    To do:
//    public void switchToShopScene(){}
//    public void switchToOptionScene(){}
//    make controllers + fxml files for them.

    // exit method?



    public Button button_start;
    public Button button_shop;
    public Button button_options;
    public Button button_exit;


//    also shouldn't need to change this text so prob delete?
    @FXML
    private Label startButtonText;
    @FXML
    private Label shopButtonText;
    @FXML
    private Label optionsButtonText;

//    dont think we need exitbut text, just need to call an exit method
    @FXML
    private Label exitButtonText;


    // so here we'd want more buttons that on click will do a transition into a different scene(node)?
    @FXML
    protected void shopButtonClick() {
        shopButtonText.setText("Shop is not yet implemented!");
    }
    @FXML
    protected void optionsButtonClick() {
        optionsButtonText.setText("Options are not yet implemented!");
    }


    //    exit just needs to exit, not change any text
    @FXML
    protected void exitButtonClick() {
        exitButtonText.setText("no exit yet >:(");
    }

}