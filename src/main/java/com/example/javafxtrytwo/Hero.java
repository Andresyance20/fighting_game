package com.example.javafxtrytwo;

import java.util.Random;

public class Hero {

    boolean active;
    String name;
//    stats
    double currenthp;
    double maxhp;
    double strength;
    double endurance;
    double agility;

//    maybe dont need atk dmg if we're handling that in ability class, we can just use the 3 stats, Str, End, Agi for calculations?
    double attackDamage;
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

    //    to be done, control img size?
    double height;
    double weight;




// we handle these somehow in abilities?
//    double atkDmg,
//    double blockAmount,
    public Hero(boolean active, String name, double currenthp, double maxhp, double strength, double endurance, double agility, double attackDamage,
                double dodge, double superCharge, double position, double experience,
                double money, double victoryCount, double lossCount, double height, double weight)
    {
        this.active = active;
        this.name = name;
        this.currenthp = currenthp;
        this.maxhp = maxhp;
        this.strength = strength;
        this.endurance = endurance;
        this.agility = agility;
        this.attackDamage = attackDamage;
//        this.blockAmount = blockAmount;
        this.dodge = dodge;
        this.superCharge = superCharge;
        this.position = position;
        this.experience =experience;
        this.money = money;
        this.victoryCount = victoryCount;
        this.lossCount = lossCount;
        this.height = height;
        this.weight = weight;


    }

    // GETTERS
    public boolean getActive()
    {
        return active;
    }
    public String getName() {
        return name;
    }
    public double getCurrenthp() {
        return currenthp;
    }
    public double getMaxhp()
    {
        return maxhp;
    }

    public double getStrength() {
        return strength;
    }
    public double getEndurance() {
        return endurance;
    }
    public double getAgility() {
        return agility;
    }
    public double getAttackDamage()
    {
        return attackDamage;
    }
    public double getDodge() {
        return dodge;
    }
    public double getSuperCharge() {
        return superCharge;
    }
    public double getPosition() {
        return position;
    }
    public double getExperience() {
        return experience;
    }
    public double getMoney() {
        return money;
    }
    public double getVictoryCount() {
        return victoryCount;
    }
    public double getLossCount() {
        return lossCount;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }

    // SETTERS
    public void setActive(boolean active)
    {
        this.active = active;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCurrenthp(double currenthp) {
        this.currenthp = currenthp;
    }
    public void setMaxhp(double maxhp)
    {
        this.maxhp = maxhp;
    }
    public void setStrength(double strength) {
        this.strength = strength;
    }
    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }
    public void setAgility(double agility) {
        this.agility = agility;
    }
    public void setAttackDamage(double attack)
    {
        this.attackDamage = attack;
    }
    public void setDodge(double dodge) {
        this.dodge = dodge;
    }
    public void setSuperCharge(double superCharge) {
        this.superCharge = superCharge;
    }
    public void setPosition(double position) {
        this.position = position;
    }
    public void setExperience(double experience) {
        this.experience = experience;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    public void setVictoryCount(double victoryCount) {
        this.victoryCount = victoryCount;
    }
    public void setLossCount(double lossCount) {
        this.lossCount = lossCount;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }



//    For bug testing
    public void print_hero_info()
    {
        System.out.println("\n");
        System.out.println("==========HERO==========");
        System.out.println("Name: " + getName());
        System.out.println("HP: " + getCurrenthp() + "/" + getMaxhp());
        System.out.println("Strength: " + getStrength());
        System.out.println("Endurance: " + getEndurance());
        System.out.println("Agility: " + getAgility());
        System.out.println("Attack: " + getAttackDamage());
        System.out.println("Dodge Chance: " + getDodge() + "%");
        System.out.println("Supercharge: " + getSuperCharge() + "% out of 100%" );
        System.out.println("Position " + getPosition()); // crouching, standing, jumping?
        System.out.println("Experience: " + getExperience());
        System.out.println("Money " + getMoney());
        System.out.println("Victories: " + getVictoryCount());
        System.out.println("Losses:  " + getLossCount());
        System.out.println("Height: " + getHeight());
        System.out.println("Weight: " + getWeight());
        System.out.println("\n");
    }

//    For resetting a hero (player or AI) after a win or loss / retry
    public void reset_hero_full_recovery()
    {
        // reset hp
        this.setCurrenthp(getMaxhp());
        // set supercharge back down to 0
        this.setSuperCharge(0);
        updateAllStats();
        // idk, we'll figure out what else we need when we run into it
    }



// recalculate stat results if any stat changes
// if player increases endurance, see if their hp should go up.
// hp = (endurance + (strength / 2)) * 10
    public void updatehp()
    {
        this.setMaxhp((this.getEndurance() + (this.getStrength() / 2)) * 10);
        this.setCurrenthp(this.getMaxhp());
    }

//    dodge = agility + (endurance/2) * 0.1
    public void updateDodge()
    {
        this.setDodge((this.getAgility() + (this.getEndurance() / 2)) * 0.1);
    }

//    i think we just need an atk method for now, can change if abilities get made
    public void updateAttack()
    {
        this.setAttackDamage((this.getStrength() + (this.getAgility() / 2)) * 0.4);
    }

    public void updateAllStats()
    {
        updatehp();
        updateDodge();
        updateAttack();
    }



// For AI hero to set stats
// some RNG for spice?
    public void setAiDifficulty(String difficulty)
    {
        Random rng = new Random();
        if (difficulty.equals("normal"))
        {
//  set the stats for AIhero.
            this.setStrength(10 + rng.nextDouble(7));
            this.setEndurance(10 + rng.nextDouble(7));
            this.setAgility(10 + rng.nextDouble(7));

            this.setMaxhp((this.getEndurance() + (this.getStrength() / 2)) * 10);
            this.setCurrenthp(this.getMaxhp());

            this.setDodge(((this.getAgility() + (this.getEndurance() / 2)) * 0.1));


            this.setAttackDamage((this.getStrength() + (this.getAgility() / 2)) * 0.4);


//  we can grab these numbers from AI and simply give to the playerActiveHero if they win
            this.setExperience(100 + rng.nextDouble(25));
            this.setMoney(100 + rng.nextDouble(25));
        }

        else if (difficulty.equals("hard"))
        {
            //            set the stats for AIhero.
            this.setStrength(10 + rng.nextDouble(14));
            this.setEndurance(10 + rng.nextDouble(14));
            this.setAgility(10 + rng.nextDouble(14));

            this.setMaxhp((this.getEndurance() + (this.getStrength() / 2)) * 10);
            this.setCurrenthp(this.getMaxhp());

            this.setDodge(((this.getAgility() + (this.getEndurance() / 2)) * 0.1));

            this.setAttackDamage((this.getStrength() + (this.getAgility() / 2)) * 0.4);

//            we can grab these numbers from AI and simply give to the playerActiveHero if they win
            this.setExperience(200 + rng.nextDouble(80));
            this.setMoney(200 + rng.nextDouble(80));
        }
    }


    // some troubleshooting print statements in here from earlier tests
    // hero takes damage when hit with an attack
    public void takeDamage (double hit)
    {
        System.out.println("Hero takes: " + hit + " damage.");
        double temp = getCurrenthp() - hit;

        System.out.println(temp);

        setCurrenthp(temp);
        System.out.println(getCurrenthp());
        System.out.println("Hero has: " + getCurrenthp() + ".");
        if (getCurrenthp() > 50)
        {
            takeDamage(10);
        }
    }
}
