package com.cddzmitry;

public class Car extends Vehicle{

    private int size;
    private String engineType;
    private String brand;
//    creating constructor that will use Vehicle
    public Car(int gears, int wheels, int seats, int size, String engineType,String brand) {
        super(gears, wheels, seats, 1);
        this.size = size;
        this.engineType = engineType;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
