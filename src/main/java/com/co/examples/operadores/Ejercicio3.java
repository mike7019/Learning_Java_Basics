package com.co.examples.operadores;

import java.util.Scanner;

public class Ejercicio3 {


    public static void main(String[] args) {
        // construir una calculadora, esta va recibir 3 datos, num1, num2 y result

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el valor de la operacion: +, -, * o /");
        char operacion = scanner.next().charAt(0);

        System.out.println("Ingrese el valor de numero1: ");
        double num1 =  scanner.nextDouble();

        System.out.println("Ingrese el valor de numero2: ");
        double num2 =  scanner.nextDouble();

        double resultado;

        switch (operacion) {
            case '+':
                resultado = num1 + num2;
                System.out.println("El resultado es: " + resultado);
                break;
            case '-':
                resultado = num1 - num2;
                System.out.println("El resultado es: " + resultado);
                break;
            case '*':
                resultado = num1 * num2;
                System.out.println("El resultado es: " + resultado);
                break;
            case '/':
                resultado = (double) num1 / num2;
                System.out.println("El resultado es: " + resultado);
                break;
            default:
                System.out.println("operacion no valida " + operacion);
        }
    }

}
