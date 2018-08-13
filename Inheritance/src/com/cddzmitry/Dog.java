package com.cddzmitry;

//inheriting from animal
public class Dog extends Animal {
//    specify its own fields in class for a dog
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

//    call Animal with dog
    public Dog(String name, int size, int weight,int eyes,int legs,int tail,int teeth,String coat) {

//        passing super values from parent Animal class
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail   = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew(){
        System.out.println("Dog.chew() called");
    }


//    overrides parent method eat
    @Override
    public void eat() {
        System.out.println("Gog eat called");
        chew();
        super.eat();
    }

    public void walk(){
        System.out.println("Dog.walk() was called");
//        if there is no super it will call Override method
        move(5);

    }

    public void run(){
        System.out.println("Dog.run() was called");
        move(10);


    }
    private void moveLegs(int speed){

        System.out.println("Dog moveLegs was called " + speed);
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog @Override Move was called");
        moveLegs(speed);
        super.move(speed);
    }
}
