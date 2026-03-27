package com.co.examples;

public class ejemplo {

    public static void main(String[] args) {
        System.out.println("the result for given number is: " + checkOddEven("12"));

    }

    public static String checkOddEven(String stringParam){
        try{
            int num = Integer.parseInt(stringParam);
            if (num % 2 == 0){
                return("even");
            } else{
                return("odd");
            }
        }catch(Exception e){
            return "is not a number";
        }
    }

}
