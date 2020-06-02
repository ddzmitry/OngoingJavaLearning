package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    //    new Thread(new CodeToRun()).start();

    new Thread(()-> {
        System.out.println("Printing from the Runnable");
        System.out.println("This is another line here ");

    }).start();
    }
}
