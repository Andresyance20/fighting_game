package com.example.javafxtrytwo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameMenu extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        //set background
        Pane root = new Pane();
        root.setPrefSize(800,600);
        //input stream from file
        InputStream stg = Files.newInputStream(Paths.get("background1.gif")); // we can change this image btw
        //load image "stg" to the class Image
        Image image = new Image(stg);
        //in case we want to use the image again let's close it up otherwise will be blocked
        stg.close();
        //create imageview to see the image
        ImageView imageView = new ImageView(image);
        //attached imageView to the root
        root.getChildren().addAll(imageView);
        //set scene and display
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        //resizable?
        //primaryStage.setResizable(true);
        // set size or resizable above
        imageView.setFitHeight(800);
        imageView.setFitWidth(600);
        primaryStage.show();
    }
    //set menu bottom
    private static class MenuButton extends StackPane {
        //text for menu
        private Text text;
        //constructor
        public MenuButton(String name){
            //set the text and font size
            text = new Text(name);
            text.setFont(text.getFont().font(20));
            //draw rectangle and painted for the menu Button
            Rectangle rc = new Rectangle(250,30);
            rc.setOpacity(0.6);
            rc.setFill(Color.BLACK);
            rc.setEffect(new GaussianBlur(3.5));


            //I have to add to more stuff :)
            //the menu will have 3 or 4 button:
            // start game
            // Shop or sound setting or both
            // Quit game




        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
