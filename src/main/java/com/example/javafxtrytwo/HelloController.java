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
import java.io.IOException;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    Hero hero = new Hero("First Hero", 100, 10, 10, 10, 5, 0, 1, 0, 0, 0, 0, 66, 200);
//        FightSceneSetup should have 3 heroes configured to pick from. So by default we should have them created here?


//    FightSceneSetup fightSceneSetup = new FightSceneSetup(hero,"Default map", "easy");

    public void switchToFightSceneSetup(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FightSceneSetup.fxml"));

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("FightSceneSetup.fxml"));
        root = loader.load();
//        Parent root = loader.load();




        FightSceneSetupController fightSceneSetupController = loader.getController();

// messy right now but the logic should work for access to hero methods in the controllers?
        fightSceneSetupController.hero.print_hero_info();
        fightSceneSetupController.hero.takeDamage(1);
        System.out.println(" HP: " + fightSceneSetupController.hero.getHp());

//        object id? yeh the hero object is new each time
        System.out.println(fightSceneSetupController.hero);
//        So current issue seems to be that we are creating a new hero each time.



//        root = FXMLLoader.load(getClass().getResource("FightSceneSetup.fxml"));
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

//    dont think we need exit but text, just need to call an exit method
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