package com.co.examples.arrays;

public class ArrayTridimensional {

    public static void main(String[] args) {
        int [][][] cubo = {
                {{1,2}, {3,4}},
                {{5,6}, {7,8}}
        };

        for(int i = 0; i < cubo.length; i++){
            for(int j = 0; j < cubo.length; j++){
                for(int k = 0; k < cubo.length; k++){
                    System.out.print(cubo[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }

}
