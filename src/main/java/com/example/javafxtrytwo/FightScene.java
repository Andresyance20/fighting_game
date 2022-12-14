package com.example.javafxtrytwo;


import javafx.scene.Scene;

public class FightScene {

// Need to get basics done first: Simple turn logic (attack, calculate, pass turn to enemy) / enemy AI response)
// Requires ability class to do attacks but can just implement a dummy attack action if not completed.

//    basic switch for turn
    boolean player_turn = false;

//    maybe not a string, but this should decide the background art.
    String map;

    double turnCount;
    double hpBarDisplay;
    double superMoveBarDisplay;
    double heroNameDisplay;
    double roundWinCount;


    private Hero activeHero;

//    public void setActiveHero(Hero hero1)
//    {
//       Hero activeHero = hero1;
//    }

//    add ai hero
    public FightScene(Hero activeHero)
    {
        this.activeHero = activeHero;
    }




    public void endTurn()
    {

    }

    public void loss()
    {

    }
    public void victory()
    {

    }

    public void rematch()
    {

    }

    public void surrender()
    {

    }

    public void nextRound()
    {

    }

//    was attack/block but it should just take w/e ability/action is picked instead, right?
    public void ability()
    {

    }

// I think superMove is an exception to the above
    public void superMove()
    {

    }

//    take in some parameters to be measured to give an amount of super charge
    public void increaseSuperCharge(double damage)
    {

    }

    public void accessInventory()
    {

    }

    public void changePosition()
    {

    }



}
