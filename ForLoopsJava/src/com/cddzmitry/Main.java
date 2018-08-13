package com.cddzmitry;

public class Main {

    public static void main(String[] args) {
//        check the interest rate
//        generic for loop with 5 increment



        for (double i = 5; i < 20 ; i+=5d) {

            System.out.println(CalculateInterest(1000,i));
        }


//        backwards for loop
        for (double i = 8; i > 0 ; i-=2) {

            System.out.println(i);
            System.out.println("The interest rate at " + i + "% is " + CalculateInterest(1000,i));
        }



//        ***PRIME number Search!
        int TotalPrimeNumber = 0;
        for (int i = 0; i <=100 ; i++) {
            if(isPrime(i)){
                System.out.println("The number " + i + " is PrimeNumber!");
                TotalPrimeNumber++;
                if(TotalPrimeNumber==10)
                    break;
            }

        }
        System.out.println("The total number of prime numbers is " + TotalPrimeNumber);


    }
    public  static  double CalculateInterest(double amount,double interestRate){
        return(amount * (interestRate/100));
    }


    public static boolean isPrime(int n){
        if(n==1){
            return false;

        }
        for (int i = 2; i <=(long) Math.sqrt(n); i++) {
            if(n%i ==0){
                return false;
            }
        }
        return true;
    }

}
