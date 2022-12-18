package com.example.javafxtrytwo;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ShopController {
    private Scene mainScene;
    private Hero playerHero1;
    private Hero playerHero2;
    private Hero playerHero3;
    private Hero playerActiveHero;
    private Hero heroAI;
    private int money;
    private int hpPotionCount;
    private int attackPotionCount;
    private int superPotionCount;


    // setting money to textfield

    public void setToMainMenu(Scene scene, Hero hero1, Hero hero2, Hero hero3, Hero activeHero, Hero heroai, int money, int hpCount, int attackCount, int superCount) {
        mainScene = scene;
        playerHero1 = hero1;
        playerHero2 = hero2;
        playerHero3 = hero3;
        playerActiveHero = activeHero;
        heroAI = heroai;
        this.money = money;
        hpPotionCount = hpCount;
        attackPotionCount = attackCount;
        superPotionCount = superCount;
    }

    // back to menu
    public void openMainMenu(ActionEvent actionEvent)
    {


        // add some logic to make sure there is an active hero before going to fightscene?
        if (playerHero1.getActive() == true)
        {
            System.out.println("Hero1 is: " + playerHero1.getActive());
            playerActiveHero = playerHero1;
        }
        if (playerHero2.getActive() == true)
        {
            System.out.println("Hero2 is: " + playerHero2.getActive());
            playerActiveHero = playerHero2;
        }
        if (playerHero3.getActive() == true)
        {
            System.out.println("Hero3 is: " + playerHero3.getActive());
            playerActiveHero = playerHero3;
            System.out.println(playerActiveHero.getCurrenthp());
        }

        setToMainMenu(mainScene, playerHero1, playerHero2, playerHero3, playerActiveHero, heroAI, money, hpPotionCount, attackPotionCount, superPotionCount);

        System.out.println("\nGrand Test Print");
        System.out.println("in class: FightSceneController. ");
        System.out.println("Hero 1 name: " + playerHero1.getName());
        System.out.println("Hero 1 hp: " + playerHero1.getCurrenthp());
        System.out.println("Hero 1 active: " + playerHero1.getActive());

        System.out.println("\nHero 2 name: " + playerHero2.getName());
        System.out.println("Hero 2 hp: " + playerHero2.getCurrenthp());
        System.out.println("Hero 2 active: " + playerHero2.getActive());

        System.out.println("\nHero 3 name: " + playerHero3.getName());
        System.out.println("Hero 3 hp: " + playerHero3.getCurrenthp());
        System.out.println("Hero 3 active: " + playerHero3.getActive());

        System.out.println("\nACTIVEheroobject name: " + playerActiveHero.getName());
        System.out.println("ACTIVEheroobject hp: " + playerActiveHero.getCurrenthp());
        System.out.println("ACTIVEheroobject active:  " + playerActiveHero.getActive());



        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(mainScene);
    }

    public Button button_shopToMenu;
    public Button button_healthPotion;
    public Button button_attackPotion;
    public Button button_superPotion;
    public TextField text_money;

    // potion buttons clicked
    @FXML
    protected void hpPotionClick (ActionEvent actionEvent)
    {
        int hpCost = 100;
        if (money >= hpCost)
        {
            Alert  alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Purchase");
            alert.setHeaderText("Ready to buy Health Potion");
            alert.setContentText("Confirm Purchase?");
            if(alert.showAndWait().get() == ButtonType.OK)
            {
                money -= hpCost;
                hpPotionCount++;
                System.out.println("Money: " + money);
                System.out.println("Number of Health Potions: " + hpPotionCount);
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not Enough Money");
            alert.setHeaderText("You don't have enough money");
        }
    }
    @FXML
    protected void attackPotionClick (ActionEvent actionEvent) {
        int attackCost = 100;
        if (money >= attackCost) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Purchase");
            alert.setHeaderText("Ready to buy Attack Potion");
            alert.setContentText("Confirm Purchase?");
            if (alert.showAndWait().get() == ButtonType.OK) {
                money -= attackCost;
                attackPotionCount++;
                System.out.println("Money: " + money);
                System.out.println("Number of Attack Potions: " + attackPotionCount);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not Enough Money");
            alert.setHeaderText("You don't have enough money");
        }
    }
    @FXML
    protected void superPotionClick (ActionEvent actionEvent) {
        int superCost = 300;
        if (money >= superCost) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Purchase");
            alert.setHeaderText("Ready to buy Super Potion");
            alert.setContentText("Confirm Purchase?");
            if (alert.showAndWait().get() == ButtonType.OK) {
                money -= superCost;
                superPotionCount++;
                System.out.println("Money: " + money);
                System.out.println("Number of Super Potions: " + superPotionCount);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not Enough Money");
            alert.setHeaderText("You don't have enough money");
        }
    }
}
