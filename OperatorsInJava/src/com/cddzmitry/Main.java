package com.cddzmitry;

public class Main {

    public static void main(String[] args) {
	// write your code here
    int result = 1+2;
        System.out.println("1 + 2 = "+result);
    int preveiousResult = result;
    result = result -1;
        System.out.println(preveiousResult);
        System.out.println(result);

    preveiousResult = result;

    result = result %3;
        System.out.println(result);

        result --;
        System.out.println(result);
        boolean isAlien = true;
        if(isAlien){
            System.out.println("This is an alien");
        }else{
            System.out.println("This not Alien");
        }


        double myValue = 20;
        double mySecondValue = 40;
        double sumTotal = (double) (myValue + mySecondValue)*25;
        System.out.println(sumTotal%40);
        if (sumTotal%40 <= 20){
            System.out.println("Total was over limit");
        }else{
            System.out.println("All good");
        }

    }







}
