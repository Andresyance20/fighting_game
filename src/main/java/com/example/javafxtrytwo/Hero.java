package com.example.javafxtrytwo;

public class Hero {

    String name;

//    to be done, control img size?
    double height;
    double weight;

//    stats
    double hp;
    double strength;
    double endurance;
    double agility;

//    maybe dont need atk dmg if we're handling that in ability class, we can just use the 3 stats, Str, End, Agi for calculations?
    double atkDmg;
//    yeh it might make more sense to have block be an ability (like reduce/absorb dmg and build up super gauge?).
    double blockAmount;
//    ok but i think dodge chance makes sense to keep here based on ability as it is a reactive action, not an active action.
    double dodge;
    double superCharge;

//    may need to rethink position? Not totally sure how we're implementing it, but it'll be tied to abilities somehow.
    double position;


//    honestly we could just do away with xp or money if we wanted and use only 1 or the other?
    double experience;
    double money;

//    fun stats
    double victoryCount;
    double lossCount;






    public Hero(String name)
    {
        this.name = name;
    }

    public void print_name()
    {
        System.out.println(name);
    }

}
