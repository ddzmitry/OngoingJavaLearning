package com.cddzmitry;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        to set a PC we nned elements for PC
        Dimensions dimencions = new Dimensions(20,20,5);

        Case theCase = new Case("220B","DELL","240",dimencions);

//        you can generate new class right in the other class
//        instantiation within instantiation
        Monitor theMonitor = new Monitor("27 inch Beast","Acer",27,new Resolution(2540,1440));

        Motherboard theMtherboard = new Motherboard("BJ-200","Asus",4,6,"v2.44");

        PC myComputer = new PC(theCase,theMonitor,theMtherboard);

//        get the monitor and fire function on it

//      ======================This is composition AWESOMEEEE!!!
//        myComputer.getMonitor().drawPixelAt(1500,1200,"red");
//        myComputer.getMotherboard().loadProgram("Windows 1.0");
//        myComputer.getTheCase().pressButtom();
//        NMow we just can call public power up function in PC class that will fire off the private functions from PC class


//        Compodition is creating objects withing an object
        myComputer.powerUp();


//
    }
}
