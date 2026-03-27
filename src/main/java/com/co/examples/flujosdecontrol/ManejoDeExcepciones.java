package com.co.examples.flujosdecontrol;

public class ManejoDeExcepciones {

    public static void main(String[] args) {
        try{
            int numero = 10/0;
        }catch(ArithmeticException e){
            System.out.println("Error, Division by zero not possible");
        }finally {
            System.out.println("Este bloque siempre se va a ejecutar");
        }
    }

}
