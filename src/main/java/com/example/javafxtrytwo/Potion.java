package com.example.javafxtrytwo;

public class Potion {
    // attributes of a potion
    char type;
    double value;

    public Potion (char type, double value){
        this.type = type;
        this.value = value;
    }
    // getters for the attributes
    public char getType () {
        return type;
    }
    public double getValue () {
        return value;
    }
}
