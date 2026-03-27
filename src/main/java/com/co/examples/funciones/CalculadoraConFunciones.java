package com.co.examples.funciones;


public class CalculadoraConFunciones {

    public static void main(String[] args) {
        System.out.println("La suma de los valores son: " + suma(10, 50));
        System.out.println("La resta de los valores son: " + resta(10, 50));
        System.out.println("La multiplicacion de los valores son: " + multiplicacion(10, 50));
        System.out.println("La division de los valores son: " + division(10, 50));
    }

    private static int suma(int a, int b) {
        return a + b;
    }

    private static int resta(int a, int b) {
        return a - b;
    }

    private static int multiplicacion(int a, int b) {
        return a * b;
    }

    private static double division(int a, int b) {
        return (double) a / b;
    }

}
