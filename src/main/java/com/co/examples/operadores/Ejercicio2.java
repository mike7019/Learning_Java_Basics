package com.co.examples.operadores;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        // ingresar dos numeros y comprarlos si son mayor o menos o iguales

        //pedir numeros
        Scanner scanner = new Scanner(System.in); //pedir datos a traves de la consola

        System.out.println("Ingrese el numero 1 : ");
        int numero1 = scanner.nextInt(); // 3

        System.out.println("Ingrese el numero 2 : ");
        int numero2 = scanner.nextInt(); // 10

        if (numero1 > numero2){
            System.out.println("El " + numero1+ " es mayor a " + numero2);
        }else if (numero1 < numero2){
            System.out.println("El " + numero1+ " es menor a " + numero2);
        }else {
            System.out.println("los numeros " + numero1 + " y el " + numero2 + " son iguales");
        }

    }

}
