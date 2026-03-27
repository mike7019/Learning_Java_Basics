package com.co.examples.operadores;

public class OperadoresDeAsignacion {

    public static void main(String[] args) {
        int numero = 10;

        System.out.println("El numero es: " + numero); //10
        numero += 1; //11
        System.out.println("El numero + 1 es: " + numero); //11
        numero -= 2; //9
        System.out.println("El numero - 2 es: " + numero); //9
        numero *= 2; //18
        System.out.println("El numero * 2 es: " + numero); //18
        numero /= 2; //9
        System.out.println("El numero /= 2 es: " + numero); //9
    }

}
