package com.co.examples.funciones;

import java.util.Scanner;

public class MenuCalculadora {

    static Scanner scanner = new Scanner(System.in);
    static char option;

    public static void main(String[] args) {

        do {
            imprimirMenu();
            option = scanner.next().charAt(0);

            switch (option) {
                case '+':
                    System.out.println("el resultado de la suma es: " + suma());
                    break;
                case '-':
                    System.out.println("el resultado de la resta es: " + resta());
                    break;
                case '*':
                    System.out.println("el resultado de la multiplicacion es: " + multiplicacion());
                    break;
                case '/':
                    System.out.println("el resultado de la division es: " + division());
                    break;
                default:
                    System.out.println("la opcion no es valida" + (option=0));
            }

        } while (option != 0);
    }

    private static void imprimirMenu() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║          Menú de la Calculadora        ║");
        System.out.println("╠══════════════╦═════════════════════════╣");
        System.out.println("║ Opción       ║ Operación               ║");
        System.out.println("╠══════════════╬═════════════════════════╣");
        System.out.println("║ +            ║ Sumar                   ║");
        System.out.println("║ -            ║ Restar                  ║");
        System.out.println("║ *            ║ Multiplicar             ║");
        System.out.println("║ /            ║ Dividir                 ║");
        System.out.println("║ 0            ║ Salir                   ║");
        System.out.println("╠══════════════╬═════════════════════════╣");
        System.out.print("Elige una opción: ");
    }

    private static int suma(){
        System.out.println("Ingrese el valor de numero1: ");
        int num1 =  scanner.nextInt();

        System.out.println("Ingrese el valor de numero2: ");
        int num2 =  scanner.nextInt();

        return num1 + num2;
    }

    private static int resta(){
        System.out.println("Ingrese el valor de numero1: ");
        int num1 =  scanner.nextInt();

        System.out.println("Ingrese el valor de numero2: ");
        int num2 =  scanner.nextInt();

        return num1 - num2;
    }

    private static int multiplicacion(){
        System.out.println("Ingrese el valor de numero1: ");
        int num1 =  scanner.nextInt();

        System.out.println("Ingrese el valor de numero2: ");
        int num2 =  scanner.nextInt();

        return num1 * num2;
    }

    private static double division(){
        System.out.println("Ingrese el valor de numero1: ");
        int num1 =  scanner.nextInt();

        System.out.println("Ingrese el valor de numero2: ");
        int num2 =  scanner.nextInt();

        return (double) num1 / num2;
    }
}
