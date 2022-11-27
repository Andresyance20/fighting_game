package com.example.javafxtrytwo;

public class FightSceneSetup {


    String map;
    String difficulty;


//    takes in at least 1 hero object
//    i think this is okay for passing the hero object for scope, right?
    public FightSceneSetup(Hero hero, String map, String difficulty)
    {
        this.map = map;
        this.difficulty = difficulty;
    }


// I'm a little unsure about how to access the hero right now. prob just have method on the hero?
    public void inspectHero(Hero hero)
    {
// come back to this after hero is more complete.
        hero.print_hero_info();
    }

    public void pickHero()
    {

    }


    public void pickMap(String arg)
    {
//        I forgot how to do this in java but we just check in arg is = map name and set background somehow w/ controller
//        if (arg == "default") {}
    }

    public void pickDifficulty()
    {
// same idea s pickmap but we will inflate enemy numbers or something, too.
    }

//    this should be button click after all the required parameters are set and ready to be taken into the FightScene.
    public void startFight()
    {

    }



}
