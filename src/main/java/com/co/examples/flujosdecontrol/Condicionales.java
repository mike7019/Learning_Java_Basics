package com.co.examples.flujosdecontrol;

public class Condicionales {

    public static void main(String[] args) {
        System.out.println("el valor " + esparOImpar("abc"));
    }

    private static String esparOImpar(String numero) {
        try{
            int num = Integer.parseInt(numero);

            if (num % 2 == 0){
                return "es par";
            }else {
                return "es impar";
            }
        } catch (Exception e) {
           return "no es un numero -> mensaje de excepcion: " + e.getMessage();
        }
    }
}
