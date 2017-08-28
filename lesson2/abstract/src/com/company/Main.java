package com.company;

public class Main  {
    public static void main(String[] args) {
       Person petya = new Person("Петя"); // write your code here
        petya.printName();
        petya.setSalary(35000);
        petya.startWork();

        Person vasya = new Person("Вася");
        vasya.printName();
        vasya.setSalary(55000);
        vasya.startWork();

        vasya.goToHackaton();

    }
}
