package com.co.examples.estructurasdedatos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaCollections {

    public static void main(String[] args) {
        System.out.println("=== Ejemplos de la clase Collections ===\n");

        ejemploAgregarEliminarModificar();
        ejemploOrdenamiento();
        ejemploReverseYShuffle();
        ejemploBusquedaBinaria();
        ejemploMinYMax();
        ejemploSwapYRotate();
        ejemploFillYCopy();
        ejemploFrequencyYDisjoint();
        ejemploListasEspeciales();
        ejemploListasSeguras();
    }

    public static void ejemploAgregarEliminarModificar() {
        System.out.println("1) Agregar, eliminar y modificar");
        List<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        lista.add("Kotlin");
        lista.add("Java");

        lista.remove("Python");
        lista.set(1, "C#");

        System.out.println("Lista final: " + lista);
        System.out.println("Tamano de la lista: " + lista.size());
        System.out.println();
    }

    public static void ejemploOrdenamiento() {
        System.out.println("2) Ordenamiento con Collections.sort");
        List<Integer> numeros = new ArrayList<>(Arrays.asList(9, 2, 8, 1, 5, 3));
        Collections.sort(numeros);
        System.out.println("Numeros ordenados ascendente: " + numeros);

        List<String> nombres = new ArrayList<>(Arrays.asList("Lorena", "Tatiana", "Pavel", "Doggy", "Mike", "Luisa"));
        Collections.sort(nombres, Comparator.reverseOrder());
        System.out.println("Nombres ordenados descendente: " + nombres);
        System.out.println();
    }

    public static void ejemploReverseYShuffle() {
        System.out.println("3) Reverse y Shuffle");
        List<String> colores = new ArrayList<>(Arrays.asList("Rojo", "Verde", "Azul", "Amarillo"));

        Collections.reverse(colores);
        System.out.println("Lista invertida: " + colores);

        Collections.shuffle(colores);
        System.out.println("Lista mezclada aleatoriamente: " + colores);
        System.out.println();
    }

    public static void ejemploBusquedaBinaria() {
        System.out.println("4) Busqueda binaria");
        List<Integer> numeros = new ArrayList<>(Arrays.asList(70, 10, 40, 20, 50));

        // binarySearch requiere que la lista este ordenada
        Collections.sort(numeros);
        int posicion20 = Collections.binarySearch(numeros, 20);
        int posicion100 = Collections.binarySearch(numeros, 100);

        System.out.println("Lista ordenada: " + numeros);
        System.out.println("Posicion del numero 20: " + posicion20);
        System.out.println("Resultado al buscar 100 (no existe): " + posicion100);
        System.out.println();
    }

    public static void ejemploMinYMax() {
        System.out.println("5) Minimo y maximo");
        List<Integer> edades = Arrays.asList(18, 22, 35, 16, 29);

        int minimo = Collections.min(edades);
        int maximo = Collections.max(edades);

        System.out.println("Edades: " + edades);
        System.out.println("Edad minima: " + minimo);
        System.out.println("Edad maxima: " + maximo);
        System.out.println();
    }

    public static void ejemploSwapYRotate() {
        System.out.println("6) Intercambio (swap) y rotacion (rotate)");
        List<String> turnos = new ArrayList<>(Arrays.asList("Ana", "Luis", "Carlos", "Marta"));

        Collections.swap(turnos, 0, 2);
        System.out.println("Despues de swap entre posiciones 0 y 2: " + turnos);

        Collections.rotate(turnos, 1);
        System.out.println("Despues de rotate +1: " + turnos);
        System.out.println();
    }

    public static void ejemploFillYCopy() {
        System.out.println("7) Fill y Copy");
        List<String> estados = new ArrayList<>(Arrays.asList("pendiente", "pendiente", "pendiente"));
        Collections.fill(estados, "completado");
        System.out.println("Lista despues de fill: " + estados);

        List<String> origen = Arrays.asList("A", "B", "C");
        List<String> destino = new ArrayList<>(Arrays.asList("", "", ""));
        Collections.copy(destino, origen);
        System.out.println("Lista destino despues de copy: " + destino);
        System.out.println();
    }

    public static void ejemploFrequencyYDisjoint() {
        System.out.println("8) Frequency y Disjoint");
        List<String> materias = Arrays.asList("Java", "SQL", "Java", "Git", "Java");
        int repeticionesJava = Collections.frequency(materias, "Java");

        List<String> grupoA = Arrays.asList("Ana", "Luis", "Sofia");
        List<String> grupoB = Arrays.asList("Mario", "Pedro", "Sofia");
        boolean sonDisjuntos = Collections.disjoint(grupoA, grupoB);

        System.out.println("Materias: " + materias);
        System.out.println("Frecuencia de 'Java': " + repeticionesJava);
        System.out.println("Grupo A y Grupo B son disjuntos?: " + sonDisjuntos);
        System.out.println();
    }

    public static void ejemploListasEspeciales() {
        System.out.println("9) Listas especiales");
        List<String> unaSolaMateria = Collections.singletonList("Programacion");
        List<Integer> cincoCeros = Collections.nCopies(5, 0);

        System.out.println("singletonList: " + unaSolaMateria);
        System.out.println("nCopies: " + cincoCeros);
        System.out.println();
    }

    public static void ejemploListasSeguras() {
        System.out.println("10) Listas seguras");
        List<String> base = new ArrayList<>(Arrays.asList("uno", "dos", "tres"));

        List<String> listaSoloLectura = Collections.unmodifiableList(base);
        List<String> listaSincronizada = Collections.synchronizedList(base);

        System.out.println("unmodifiableList: " + listaSoloLectura);
        System.out.println("synchronizedList: " + listaSincronizada);



        // Si descomentas la linea siguiente, lanzara UnsupportedOperationException
        // listaSoloLectura.add("cuatro");
        listaSincronizada.add("cuatro");
        System.out.println("synchronizedList despues de agregar: " + listaSincronizada);
        System.out.println();
    }

}
