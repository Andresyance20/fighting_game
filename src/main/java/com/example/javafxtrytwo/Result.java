package com.example.javafxtrytwo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.text.html.Option;

// should this be a scene or is like a small window with the fightScene as background
public class Result {

    boolean Result;
    double score; // not sure
    double experince;
    String HeroName;


    public Button button_menu;
    public Button button_ReMatch;


    @FXML
    private Label optionsButtonText;



    private void button_ReMatch() {
        optionsButtonText.setText("Options are not yet implemented!");
    }


}