package com.cddzmitry;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int score = 3;
        switch (score){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("The value is 3 or 4 or 5");
                break;
            default:
                System.out.println("Something new");
                break;
        }

        char letter = 'A';

        switch(letter){
            case 'A':
                System.out.println("Value was A");
                break;
            case 'B':
                System.out.println("Value was B");
                break;
            case 'C': case 'D': case 'E':
                System.out.println("The value is C D or E");
                break;
            default:
                System.out.println("Some other char was passed");
                break;

        }



    }
}
