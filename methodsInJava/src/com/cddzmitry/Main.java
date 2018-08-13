package com.cddzmitry;

public class Main {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;
//        high score
        int highestScore = calculateScore(gameOver,score,levelCompleted,bonus);
        int position = calculateHighScore(highestScore);
        String message = displayHighScorePosition("Dzmitry",position);
        System.out.println(message);


        score = 10000;
        levelCompleted = 8;
        bonus = 200;
        highestScore = calculateScore(gameOver,score,levelCompleted,bonus);
        position = calculateHighScore(highestScore);
        message = displayHighScorePosition("Peter",position);
        System.out.println(message);

        score = 20;
        levelCompleted = 1;
        bonus = 5;
        highestScore = calculateScore(gameOver,score,levelCompleted,bonus);
        position = calculateHighScore(highestScore);
        message = displayHighScorePosition("Rob",position);
        System.out.println(message);

        score = 10;
        levelCompleted = 2;
        bonus = 10;
        highestScore = calculateScore(gameOver,score,levelCompleted,bonus);
        position = calculateHighScore(highestScore);
        message = displayHighScorePosition("Alex",position);
        System.out.println(message);

        score = 15;
        levelCompleted = 3;
        bonus = 50;
        highestScore = calculateScore(gameOver,score,levelCompleted,bonus);
        position = calculateHighScore(highestScore);
        message = displayHighScorePosition("Odyssey",position);
        System.out.println(message);



    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted,int bonus){
//        code that will calculate score
        if(gameOver){
            int finalScore = score + (levelCompleted*bonus);
            finalScore += 2000;

            return finalScore;
        } else {
            return -1;

        }
    }
//    display highest Position Method
//    void doesnot return anything
    public  static String displayHighScorePosition(String name,int pos){
        String message = name + " managed out to come with " + pos;
        return message;
    }
//    calculate high score method
    public  static int calculateHighScore(int score){
        if (score > 5000){
            return  1;
        } else if(score >= 500 && score < 5000){
            return 2;
        } else if (score > 100 && score < 500){
            return 3;
        }else {
            return 4;
        }

    }
}
