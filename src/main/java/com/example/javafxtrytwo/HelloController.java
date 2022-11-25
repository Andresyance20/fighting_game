// This is the control for our javaFX i think

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
    private Parent parent;


// of course the tutorials are outdated and you have to update parts to w/e standardization they use now
//    "javafx.event.ActionEvent actionEvent" NOT "ActionEvent event"
    public void switchToMainMenu(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//        cast to the stage
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow(); // bruh this is ridiculous to just jump into
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToFightScene(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FightScene.fxml")); // maybe this fxml shouldn't be capitalized?
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    public Button button_start;
    public Button button_shop;
    public Button button_options;
    public Button button_exit;
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
    protected void startButtonClick() {
        startButtonText.setText("Start is not yet implemented!");
    }

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