package com.example.javafxtrytwo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

// should this be a scene or is like a small window with the fightScene as background
public class Result {

    boolean Result;
    double score;
    double experience;
    String HeroName;


    public Button button_menu;
    public Button button_ReMatch;


    @FXML
    private Label optionsButtonText;



    private void button_ReMatch() {
        optionsButtonText.setText("Options are not yet implemented!");
    }
    public void gain_experience()
    {
        /*Label label = new Label();
        StringProperty myStringProperty = new SimpleStringProperty();

        myStringProperty.bind(Bindings.when(conditionProperty).then("Yes").otherwise("No"));
        label.textProperty().bind(myStringProperty);
    }*/


}
}