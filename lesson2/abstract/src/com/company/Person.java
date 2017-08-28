package com.company;

/**
 * Created by User on 28.08.2017.
 */
public class Person extends Human implements Skils {
    private int salary;

    public Person(String name) {
        super(name);
    }

    @Override
    public void startCoding() {
        System.out.println("Начал кодить!");
    }

    @Override
    public void startWork() {
        if (salary < 40000) {
            stopCoding();
        }else startCoding();
    }

    @Override
    public void stopCoding() {
        System.out.println("Не буду кодить!");
    }

    @Override
    public void goToHackaton() {
        System.out.println("Ребята, я поехал на хакатон.");
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
}
