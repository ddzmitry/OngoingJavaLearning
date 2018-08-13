package com.cddzmitry;

public class Vehicle {

    private int gears;
    private int wheels;
    private int seats;
    private int engine;

    //    creating a constructor for Vehicle
    public Vehicle(int gears, int wheels, int seats, int engine) {
        this.gears = gears;
        this.wheels = wheels;
        this.seats = seats;
        this.engine = engine;
    }
    //    methods
    public void drive(int speed){
        System.out.println("Vechicle.drive() was called Wroom-Wroom with speed " + speed);
    }

    public void stop(){
        System.out.println("Vechicle.stop() called!");
    }

    public void honk(){
        System.out.println("Vechicle.honk() was called Honk-Honk ");
    }

    //    creating setters for constructor
    public void setGears(int gears) {
        this.gears = gears;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }
}
