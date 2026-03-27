package com.co.examples.flujosdecontrol;

import java.util.List;

public class BucleForEach {

    public static void main(String[] args) {
                                        //numero =-  -  -  -  -
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        for (int numero : numeros){
            System.out.println(numero);
        }
    }

}
