package com.cddzmitry;

public class Fish extends Animal {

//    define properties that are for the fish itself
    private int gills;
    private int eyes;
    private  int fins;



    public Fish(String name,int size, int weight,int gills,int eyes,int fins) {

//        getting this stuff from Animal class
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }
    private void rest(){

    }



    private void moveMuscles(){
        System.out.println("Fish Moved Muscles");

    }

    private void moveBackFin(){
        System.out.println("Fish Moved moveBackFin");

    }

    private void swim(int speed) {
        System.out.println("Fish swim was called");
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }



}
