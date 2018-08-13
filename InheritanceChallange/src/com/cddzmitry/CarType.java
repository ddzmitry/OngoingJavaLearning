package com.cddzmitry;

public class CarType extends Car {
    private int seatCount;
    private  int gasMilage;
    private  String Model;

    public CarType(int gears, int wheels, int seats, int size, String engineType, String brand, int seatCount, int gasMilage, String Model) {
        super(gears, wheels, seats, size, engineType, brand);
        this.seatCount = seatCount;
        this.gasMilage = gasMilage;
        this.Model = Model;
    }
// methods

//    setters

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public void setGasMilage(int gasMilage) {
        this.gasMilage = gasMilage;
    }

    public void setModel(String Model) {
        System.out.println("The model is " + Model);
        this.Model = Model;
    }

    @Override
    public void drive(int speed) {
        System.out.println(this.Model + " Was called with speed " + speed);
        super.drive(speed);
    }

}
