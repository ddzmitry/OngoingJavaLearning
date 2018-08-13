package com.cddzmitry;

public class VipCustomers {

    private String name;
    private double balance;
    private String email;

//     ====== Overloading constrictors
    public VipCustomers() {
//        filling up the constructor !
        this("DefName",500,"IamVIP@vip.com");
        System.out.println("Constructor for 0 parameters was called");


    }

    public VipCustomers(String name, double balance) {
        this(name,balance,"noemail@mail.com");

        System.out.println("Constructor for 2 parameters was called");


    }
    public  VipCustomers(String name, double balance, String email){
        System.out.println("Constructor for 3 parameters was called");
        this.name = name;
        this.balance = balance;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





}
