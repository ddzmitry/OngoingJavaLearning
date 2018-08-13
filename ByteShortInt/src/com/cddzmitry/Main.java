package com.cddzmitry;

public class Main {

    public static void main(String[] args) {
//          byte has to be redeclared as byte
            byte myByteValue  = 120;
//          short has to be redeclared as short
            short myShortValue = 10;
            int myInteger = 100500;
//           long has to be redeclared as long
            long myChallangeValue = 50000L + (10L*(myShortValue+myInteger+myByteValue));
            System.out.println("myChallangeValue " + myChallangeValue );

    }
}
