package com.cddzmitry;

public class Main {
    public static void main(String[] args) {
	    // write your code here
        Car Rio = new CarType(5,4,4,1,"Gas","Kia",4,10,"Rio");
        Rio.honk();
        Rio.drive(10);
        Car Benz = new CarType(5,4,4,1,"Disel","Mersedes",4,30,"Benz");
        Benz.honk();

    }
}
