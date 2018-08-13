package com.cddzmitry;

public class Animal {
//    creating fields for class
    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;

//creating a constructor
    public Animal(String name, int brain, int body, int size, int weight) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
    }


//    methods ==== Will be avaliable through inheritanse
    public void eat(){
        System.out.println("Nom nom nom");

    }
    public  void move(int speed){

        System.out.println("Animal moves at speed " + speed);

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //    create getters
    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }
}
