package com.co.examples.operadores;

public class OperadoresLogicos {

    /*
    * |V|F| resultado|
    * |v|v| verdadero|
    * |v|f| falso    |
    * |f|v| falso    |
    * |f|f| false    |
    * */

    public static void main(String[] args) {
        boolean a = false;
        boolean b = true;

        System.out.println("a && b = " + (a && b)); //and
        System.out.println("a || b = " + (a || b)); //or
        System.out.println("!a = " + (!a) ); //negacion
    }

}
