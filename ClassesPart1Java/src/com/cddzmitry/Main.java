package com.cddzmitry;

public class Main {

    public static void main(String[] args) {
// build an object from car

//        created an object of Porshe based of the templet car
        Car porche = new Car();
        Car ford = new Car();

//      call methods on class
        porche.setModel("Carrera");
        System.out.println("Model is " + porche.getModel());


    }
}

