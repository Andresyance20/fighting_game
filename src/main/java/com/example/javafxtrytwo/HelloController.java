package com.example.javafxtrytwo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
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