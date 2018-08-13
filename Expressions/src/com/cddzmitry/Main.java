package com.cddzmitry;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus =100;
        int finalScore = 0;

//
//        if(score<=5000 && score> 100){
//            System.out.println("Your Score was less then 5000");
//        } else if (score < 1000){
//            System.out.println("Your score was less then 1000");
//        }
//        else{
//            System.out.println("Got here");
//        }

        if(gameOver){
            finalScore = score + (levelCompleted*bonus);
            System.out.println("Your final score is " + score);

        }

        int savedFinalScore = finalScore;

        levelCompleted =  8;
        bonus = 100;
        int secondScore = 10000;


        if(secondScore<=10000 && secondScore> 1000){
            System.out.println("Your Score was less then 5000");
        } else if (score < 1000){
            System.out.println("Your score was less then 1000");
        }
        else{
            System.out.println("Got here");
        }

        if(gameOver){
            finalScore = secondScore + (levelCompleted*bonus);
            System.out.println("Your final score is " + finalScore);

        }


    }
}
