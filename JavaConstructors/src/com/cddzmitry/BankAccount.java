package com.cddzmitry;

public class BankAccount {
    private int number;
    private double balance;
    private String CustomerName;
    private String email;
    private String phoneNumber;


    public void setNumber(int number){
        this.number = number;
        System.out.println("The account bumber is " + this.number);
    }
    public void setBalance(double balance) {
        this.balance = balance;
        System.out.println("The balance is " + this.balance);
        if (this.balance >= 10000){
            System.out.println(this.CustomerName + " is ritch BITCH!");
        }
    }
    public void setCustomerName(String CustomerName){
        this.CustomerName = CustomerName;
    }

    public void setEmail(String email) {
        this.email = email;
        System.out.println("The email was swt to " + this.email);
    }

    public void  setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        System.out.println("The phone was set to " + this.phoneNumber);

    }
    public double getBalance(){
        return this.balance;
    }
    public void addFunds(double  amount){
        this.balance = this.balance + amount;
        setBalance(this.balance);
    }

    public void withdrawFunds(double amount){
        if ((this.balance - amount)<0){
            System.out.println("Insufficient funds");
        }else{
            this.balance -= amount;
            setBalance(this.balance);
        }

    }
}
