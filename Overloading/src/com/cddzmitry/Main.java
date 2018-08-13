package com.cddzmitry;

public class Main {

    public static void main(String[] args) {

//        Overloading stuff
        int newScore = calculateScore("Dzmityry",500);
        calculateScore(newScore);
        calculateScore();

        System.out.println(calcFeetAndInchesToCentimeters(5,10));
        System.out.println(calcFeetAndInchesToCentimeters(10));


    }


//    overloading using same name but with different number
    public static int calculateScore(String playerName, int score){

        System.out.println("Player " + playerName+ " scored " + score + " points");
        return score *1000;


    }
    public static int calculateScore(int score){
        System.out.println("Unnamed scored " + score + " points");
        return score *1000;

    }
    public static int calculateScore(){
        System.out.println("No player Score was provided and no name");
        return 0;

    }


    public static  double calcFeetAndInchesToCentimeters(double foot, double inches){

        if(isValid(foot,inches)){
//
            double footToInchesTotal = inches + foot *12;
            double inchToSm = 2.54d;
            return footToInchesTotal * inchToSm;
        }

        return 0d;

    }

    public static  double calcFeetAndInchesToCentimeters(double foot){
        if(isValid(foot)){
            double inchToSm = 2.54d;
            return (foot *12)*inchToSm;
        }
        return  0d;
    }

    public static boolean isValid(double foot, double inches){
        if (inches >12d || inches < 0d || foot <0d){
            return false;
        }
        return true;
    }

    public static boolean isValid(double footOrInch){

        if (footOrInch <0d){
            return false;
        }

        return true;

    }


}
