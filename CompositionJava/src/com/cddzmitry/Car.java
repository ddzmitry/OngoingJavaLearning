package com.cddzmitry;

public class Car extends Vehicle {
    private int doors;
    private int engineCapacity;

//    constructor for the class
    public Car(String name, int doors, int engineCapacity) {
        super(name);
        this.doors = doors;
        this.engineCapacity = engineCapacity;
    }


}
