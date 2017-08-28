package com.company;

/**
 * Created by User on 28.08.2017.
 */
public abstract class Human {
    String name;
    public Human(String name) {
        this.name = name;
    }

    public void printName(){
        System.out.println("Меня зовут "+ this.name);
    }

    public abstract void goToHackaton();


}
