package com.co.examples.flujosdecontrol;

public class ControlDeFlujoConBucles {

    public static void main(String[] args) {

        System.out.println("Ejemplo con break");
        for (int i = 0; i < 11; i++) {
            if (i == 5){
                break;
            }
            System.out.println(i);
        }

        System.out.println("Ejemplo con continue");
        for (int i = 0; i < 11; i++) {
            if (i == 5){
                continue;
            }
            System.out.println(i);
        }
        
    }

}
