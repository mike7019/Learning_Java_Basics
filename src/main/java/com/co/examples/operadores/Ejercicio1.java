package com.co.examples.operadores;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        //determinar si un numero es par o impar

        Scanner scanner = new Scanner(System.in); // nos sirve para introducir texto en la consola

        System.out.println("Ingrese el valor de la operacion: ");
        int numero = scanner.nextInt();

        if (numero % 2 == 0){
            System.out.println("El valor de la operacion es par...");
        }else {
            System.out.println("El valor de la operacion es impar...");
        }

    }

}
