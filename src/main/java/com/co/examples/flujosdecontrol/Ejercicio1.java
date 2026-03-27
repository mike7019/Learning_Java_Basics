package com.co.examples.flujosdecontrol;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        //if & else + switch

        /*Crear un programa de manejo de calificaciones numericas que pueden ser 0 a 100

          devolver la categoria de la nota
          90 - 100 -> Aprobado con Excelente
          80 - 89 -> Aprobado con Bueno
          70 - 79 -> Aprobado con Regular
          menos de 70 -> Reprobado

          - if else para evaluar
          - switch para imprimir la categoria con su mensaje

          0 - 3 "Necesita mejorar"
          4 - 7 "Tuvo buen desempeño"
          8 - 9 "casi perfecto"

        */

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la nota del estudiante: ");
        int calificacion = sc.nextInt();

        if (calificacion < 0 || calificacion > 100) {
            System.out.println("La calificacion debe estar entre 0 a 100");
        } else if (calificacion >= 90) {
            System.out.println("Aprobado con Excelente");
        } else if (calificacion >= 80){
            System.out.println("Aprobado con Bueno");
        } else if (calificacion >= 70) {
            System.out.println("Aprobado con regular");
        }else {
            System.out.println("Reprobado");
        }

        int ultimoDigito = calificacion % 10;
        switch (ultimoDigito) {
            case 0, 1, 2 , 3:
                System.out.println("Necesita mejorar");
                break;
            case 4, 5, 6, 7:
                System.out.println("Tuvo buen desempeño");
                break;
            case 8, 9:
                System.out.println("Casi perfecto");
                break;
            case 10:
                System.out.println("El muchacho hizo trampa");
                break;
            default:
                System.out.println("calificacion no valida");
        }
        sc.close();
    }

}
