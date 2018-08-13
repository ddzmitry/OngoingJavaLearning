package com.cddzmitry;

public class Main {

    public static void main(String[] args) {
	// write your code here
    BankAccount DzmitryAcc = new BankAccount();
    DzmitryAcc.setNumber(123445666);
    DzmitryAcc.setCustomerName("Dzmitry Dubarau");
    DzmitryAcc.setEmail("ddzmitry@yahoo.com");
    DzmitryAcc.setPhoneNumber("7573180252");
    DzmitryAcc.setBalance(5000);
    DzmitryAcc.withdrawFunds(3000);
    DzmitryAcc.addFunds(3000);
    DzmitryAcc.withdrawFunds(10000);
    DzmitryAcc.addFunds(10000);
    DzmitryAcc.withdrawFunds(10000);

    }
}
