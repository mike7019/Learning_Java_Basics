package com.co.examples.tiposdedatos;

public class TiposDeDatos {

    /*
     * Tipos de datos primitivos
     * son aquellos que inician en minuscula y se muestran en azul, son primitivos de Java
     * */
    static final int ENTERO = 10; //constante -> valor que no puede ser cambiado
    static int numeroEntero = 15; //variable -> el valor puede ser cambiado

    static double precio = 10.40;
    static char tipo = 'A';
    static boolean falso = false; //true or false
    static float decimal = 20.5432F;
    /*
     * Tipos de datos No Primitivos
     * Son aquellos que inician en Mayuscula y que se muestran en un color diferente a azul y contiene metodos
     * */
    static String nombre = "Tatiana y Lorena";
    static Integer edad = 19;
     //                            0      1     2              3
    // nombre -> array SPLIT = [tatiana] [y] [Lorena]  OutOfBoundsExcepcion

    public static void main(String[] args) {
        try{
            System.out.println("Ella es: " + nombre.split(" ")[2] +" y tiene " + ENTERO);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("message: " + e.getMessage());
        }
    }

}
