package com.co.examples.arrays;

public class ArrayBidimensional {


    public static void main(String[] args) {

        int[][] matriz = { // Array Bidimensional
                {1, 2, 3},   // [0][0], [0][1], [0][2] i controlando la columna
                {4, 5, 6},   // [1][0], [1][1], [1][2] j controla las filas
                {7, 8, 9}   //  [2][0], [2][1], [2][2]
        };

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
        }

    }

}
