package com.cddzmitry;

public class Main {

    public static void main(String[] args) {
	// Generic While loop
        int count = 0;
        while(count !=5){
            System.out.println("Count value is " + count );
            count ++;
        }

    // ====Same concept
        count =0;
        while (true){
            if(count==5)
                break;

            System.out.println("Count value is " + count );
            count ++;
        }
    // ==== Do while will execute once
        count = 1;
        do{
            System.out.println("Count value was  "+count);
            count++;
        }while (count!=6);
    // ===== Even number counter
        count = 200;
        while (true){
            if (count == 0)
                break;
            if(isEven(count)){
                System.out.println("The even number is " + count);
            }
            count--;
        }
    }



    public static boolean isEven(int number){
        if(number%2==0 && number!=0){
            return true;
        }
        return false;
    }
}
