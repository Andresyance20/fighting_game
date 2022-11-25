package com.example.javafxtrytwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
//    public void start(Stage stage) throws IOException {//
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml")); // creating controller?
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240); // setting scene to be the fxmlLoader
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }

//    Going with the "Parent" route instead of the "fxmlLoader" because all the docs/guides are for this parent root
//    stage << scene << root node << node
    public void start(Stage stage) throws IOException {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene main_menu = new Scene(root, 420, 469); // can set initial size here
            stage.setTitle("FIGHT GAME!"); // name?
            stage.setScene(main_menu); // Setting stage to show screen
            stage.show(); // Render the stage.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


// Here is the main
    public static void main(String[] args) {


        Hero hero = new Hero("testname");

        hero.print_name();
        System.out.println("console test text in main");


//        pretty sure we need to do all our constructions BEFORE we launch the app otherwise,
//        at least for testing purposes otherwise it won't reach the lines of code after launch.
//        You would need to have an activation setup within the app already
        launch();

    }






}


