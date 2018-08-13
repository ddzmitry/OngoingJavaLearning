package com.cddzmitry;

public class Car {
//state component of the car
    private int doors;
    private  int wheels;
    private String model;
    private String engine;
    private String color;

//    create method that publicly accesable

//    ================** setters
    public void setModel(String model) {
    String validModel = model.toLowerCase();

//    we can validate on instatiation
    if(validModel.equals("potshe") || validModel.equals("ford")){
        this.model = model;
    } else {
        this.model = "Unknown";
    }


    }
// ==============** getters
    public String  getModel(){
        return  this.model;
    }
}
