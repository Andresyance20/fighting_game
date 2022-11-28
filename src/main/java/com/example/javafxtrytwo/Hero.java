package com.example.javafxtrytwo;

public class Hero {

    String name;

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

    //    to be done, control img size?
    double height;
    double weight;




// we handle these somehow in abilities?
//    double atkDmg,
//    double blockAmount,
    public Hero(String name, double hp, double strength, double endurance, double agility,
                double dodge, double superCharge, double position, double experience,
                double money, double victoryCount, double lossCount, double height, double weight)
    {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.endurance = endurance;
        this.agility = agility;
//        this.atkDmg = strength + (agility / 2);
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
    public String getName() {
        return name;
    }
    public double getHp() {
        return hp;
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
    public void setName(String name) {
        this.name = name;
    }
    public void setHp(double hp) {
        this.hp = hp;
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


    public void print_hero_info()
    {
        System.out.println("\n");
        System.out.println("==========HERO==========");
        System.out.println("Name: " + getName());
        System.out.println("HP: " + getHp());
        System.out.println("Strength: " + getStrength());
        System.out.println("Endurance: " + getEndurance());
        System.out.println("Agility: " + getAgility());
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

    // hero takes damage when hit with an attack
    public void takeDamage (double hit)
    {
        System.out.println("Hero takes: " + hit + " damage.");
        double temp = getHp() - hit;

        System.out.println(temp);

        setHp(temp);
        System.out.println(getHp());
        System.out.println("Hero has: " + getHp() + ".");
        if (getHp() > 50)
        {
            takeDamage(10);
        }
    }
}
