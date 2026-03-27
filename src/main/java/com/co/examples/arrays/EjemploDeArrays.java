package com.co.examples.arrays;

public class EjemploDeArrays {

    public static void main(String[] args) {
        // indice     0   1   2   3   4       5
        // numeros = [1] [2] [3] [4] [5] OutOfBounds

        try{
            int[] numeros = new int[5];
            numeros[0] = 1;
            numeros[1] = 2;
            numeros[2] = 3;
            numeros[3] = 4;
            numeros[4] = 5;
            //numeros[5] = 6;
            System.out.println("el tamaño del array es: " + numeros.length);

            System.out.println("El valor del array es: " + numeros[2]);
        }catch(Exception e){
            System.out.println("Mensaje de la excepcion: " + e.getMessage());
        }


    }

}
