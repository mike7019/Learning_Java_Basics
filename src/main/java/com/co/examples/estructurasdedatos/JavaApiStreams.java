package com.co.examples.estructurasdedatos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaApiStreams {

	public static void main(String[] args) {
		imprimirTitulo();

		// Nivel basico
		ejercicio01_crearStreamYRecorrer();
		ejercicio02_filter();
		ejercicio03_map();
		ejercicio04_distinctYSorted();
		ejercicio05_limitYSkip();

		// Nivel intermedio
		ejercicio06_reduce();
		ejercicio07_collectToListSet();
		ejercicio08_groupingBy();
		ejercicio09_partitioningBy();
		ejercicio10_toMapConMerge();

		// Nivel avanzado
		ejercicio11_flatMap();
		ejercicio12_optionalConFindFirst();
		ejercicio13_intStreamYEstadisticas();
		ejercicio14_pipelineCompletoDeNegocio();
		ejercicio15_parallelStream();

		imprimirCierre();
	}

	public static void imprimirTitulo() {
		System.out.println("==============================================");
		System.out.println("  Java API Streams - Clase completa de ejercicios");
		System.out.println("==============================================\n");
	}

	public static void imprimirCierre() {
		System.out.println("\n==============================================");
		System.out.println("Fin de la guia de ejercicios de Streams.");
		System.out.println("Tip: comenta ejercicios y resuelvelos por tu cuenta.");
		System.out.println("==============================================");
	}

	public static void ejercicio01_crearStreamYRecorrer() {
		System.out.println("EJERCICIO 01 - Crear Stream y recorrer con forEach");
		List<String> lenguajes = Arrays.asList("Java", "Python", "Kotlin", "Go");

		lenguajes.stream().forEach(l -> System.out.println("Lenguaje: " + l));
		System.out.println();
	}

	public static void ejercicio02_filter() {
		System.out.println("EJERCICIO 02 - filter (numeros pares)");
		List<Integer> numeros = Arrays.asList(3, 8, 11, 20, 15, 24, 31);

		List<Integer> pares = numeros.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toList());

		System.out.println("Numeros originales: " + numeros);
		System.out.println("Numeros pares: " + pares);
		System.out.println();
	}

	public static void ejercicio03_map() {
		System.out.println("EJERCICIO 03 - map (transformar datos)");
		List<String> nombres = Arrays.asList("ana", "luis", "maria", "pedro");

		List<String> enMayuscula = nombres.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());

		System.out.println("Nombres originales: " + nombres);
		System.out.println("Nombres en mayuscula: " + enMayuscula);
		System.out.println();
	}

	public static void ejercicio04_distinctYSorted() {
		System.out.println("EJERCICIO 04 - distinct y sorted");
		List<Integer> notas = Arrays.asList(5, 2, 4, 2, 1, 5, 3, 4, 3);

		List<Integer> notasUnicasOrdenadas = notas.stream()
				.distinct()
				.sorted()
				.collect(Collectors.toList());

		System.out.println("Notas originales: " + notas);
		System.out.println("Notas unicas ordenadas: " + notasUnicasOrdenadas);
		System.out.println();
	}

	public static void ejercicio05_limitYSkip() {
		System.out.println("EJERCICIO 05 - limit y skip (paginacion basica)");
		List<String> alumnos = Arrays.asList("A", "B", "C", "D", "E", "F", "G");

		List<String> pagina2 = alumnos.stream()
				.skip(3)
				.limit(3)
				.collect(Collectors.toList());

		System.out.println("Lista completa: " + alumnos);
		System.out.println("Pagina 2 (tamano 3): " + pagina2);
		System.out.println();
	}

	public static void ejercicio06_reduce() {
		System.out.println("EJERCICIO 06 - reduce (sumatoria y concatenacion)");
		List<Integer> ventas = Arrays.asList(100, 250, 300, 50);
		int total = ventas.stream().reduce(0, Integer::sum);

		List<String> palabras = Arrays.asList("Java", "API", "Streams");
		String frase = palabras.stream().reduce("", (a, b) -> (a + " " + b).trim());

		System.out.println("Ventas: " + ventas + " -> Total: " + total);
		System.out.println("Palabras: " + palabras + " -> Frase: " + frase);
		System.out.println();
	}

	public static void ejercicio07_collectToListSet() {
		System.out.println("EJERCICIO 07 - collect a List y Set");
		List<String> tecnologias = Arrays.asList("Java", "SQL", "Java", "Git", "Git", "Docker");

		List<String> lista = tecnologias.stream().collect(Collectors.toList());
		Set<String> conjunto = tecnologias.stream().collect(Collectors.toSet());

		System.out.println("Como List (permite repetidos): " + lista);
		System.out.println("Como Set (sin repetidos): " + conjunto);
		System.out.println();
	}

	public static void ejercicio08_groupingBy() {
		System.out.println("EJERCICIO 08 - groupingBy (agrupar por categoria)");
		List<Producto> productos = obtenerProductos();

		Map<String, List<Producto>> porCategoria = productos.stream()
				.collect(Collectors.groupingBy(Producto::getCategoria));

		porCategoria.forEach((categoria, lista) -> System.out.println(categoria + " -> " + lista));
		System.out.println();
	}

	public static void ejercicio09_partitioningBy() {
		System.out.println("EJERCICIO 09 - partitioningBy (cumple o no cumple)");
		List<Estudiante> estudiantes = obtenerEstudiantes();

		Map<Boolean, List<Estudiante>> aprobados = estudiantes.stream()
				.collect(Collectors.partitioningBy(e -> e.getNota() >= 3.0));

		System.out.println("Aprobados: " + aprobados.get(true));
		System.out.println("No aprobados: " + aprobados.get(false));
		System.out.println();
	}

	public static void ejercicio10_toMapConMerge() {
		System.out.println("EJERCICIO 10 - toMap con funcion de merge");
		List<Producto> productos = obtenerProductos();

		Map<String, Double> precioPorCategoria = productos.stream()
				.collect(Collectors.toMap(
						Producto::getCategoria,
						Producto::getPrecio,
						Double::sum,
						LinkedHashMap::new
				));

		System.out.println("Suma de precios por categoria: " + precioPorCategoria);
		System.out.println();
	}

	public static void ejercicio11_flatMap() {
		System.out.println("EJERCICIO 11 - flatMap (aplanar listas)");
		List<List<String>> cursos = Arrays.asList(
				Arrays.asList("Java", "POO"),
				Arrays.asList("SQL", "Base de Datos"),
				Arrays.asList("Git", "Docker")
		);

		List<String> temas = cursos.stream()
				.flatMap(List::stream)
				.collect(Collectors.toList());

		System.out.println("Cursos (anidado): " + cursos);
		System.out.println("Temas (plano): " + temas);
		System.out.println();
	}

	public static void ejercicio12_optionalConFindFirst() {
		System.out.println("EJERCICIO 12 - Optional con findFirst");
		List<String> nombres = Arrays.asList("Carlos", "Luisa", "Marta", "Pedro");

		Optional<String> nombreConL = nombres.stream()
				.filter(n -> n.startsWith("L"))
				.findFirst();

		String resultado = nombreConL.orElse("No se encontro nombre con L");
		System.out.println("Resultado: " + resultado);
		System.out.println();
	}

	public static void ejercicio13_intStreamYEstadisticas() {
		System.out.println("EJERCICIO 13 - IntStream y estadisticas");
		IntStream rango = IntStream.rangeClosed(1, 10);
		int suma = rango.sum();

		DoubleSummaryStatistics estadisticas = obtenerProductos().stream()
				.collect(Collectors.summarizingDouble(Producto::getPrecio));

		System.out.println("Suma del 1 al 10: " + suma);
		System.out.println("Cantidad productos: " + estadisticas.getCount());
		System.out.println("Precio minimo: " + estadisticas.getMin());
		System.out.println("Precio maximo: " + estadisticas.getMax());
		System.out.println("Promedio precio: " + estadisticas.getAverage());
		System.out.println();
	}

	public static void ejercicio14_pipelineCompletoDeNegocio() {
		System.out.println("EJERCICIO 14 - Pipeline completo (filtro + orden + top N)");
		List<Producto> productos = obtenerProductos();

		List<Producto> topCarosActivos = productos.stream()
				.filter(Producto::isActivo)
				.filter(p -> p.getPrecio() >= 50)
				.sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
				.limit(3)
				.collect(Collectors.toList());

		System.out.println("Top 3 productos activos mas caros (precio >= 50): " + topCarosActivos);
		System.out.println();
	}

	public static void ejercicio15_parallelStream() {
		System.out.println("EJERCICIO 15 - parallelStream (uso responsable)");
		List<Integer> numeros = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());

		int sumaSecuencial = numeros.stream().mapToInt(Integer::intValue).sum();
		int sumaParalela = numeros.parallelStream().mapToInt(Integer::intValue).sum();

		System.out.println("Suma secuencial: " + sumaSecuencial);
		System.out.println("Suma paralela: " + sumaParalela);
		System.out.println("Nota: para listas pequenas, parallelStream no siempre mejora rendimiento.");
		System.out.println();
	}

	public static List<Producto> obtenerProductos() {
		List<Producto> productos = new ArrayList<>();
		productos.add(new Producto("Laptop", "Tecnologia", 2500.0, true));
		productos.add(new Producto("Mouse", "Tecnologia", 80.0, true));
		productos.add(new Producto("Teclado", "Tecnologia", 120.0, false));
		productos.add(new Producto("Cafe", "Alimentos", 15.5, true));
		productos.add(new Producto("Pan", "Alimentos", 8.0, true));
		productos.add(new Producto("Leche", "Alimentos", 12.0, false));
		productos.add(new Producto("Cuaderno", "Papeleria", 9.5, true));
		productos.add(new Producto("Lapiz", "Papeleria", 2.0, true));
		productos.add(new Producto("Marcador", "Papeleria", 6.5, true));
		return productos;
	}

	public static List<Estudiante> obtenerEstudiantes() {
		List<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.add(new Estudiante("Ana", 4.5));
		estudiantes.add(new Estudiante("Luis", 2.8));
		estudiantes.add(new Estudiante("Marta", 3.2));
		estudiantes.add(new Estudiante("Carlos", 1.9));
		estudiantes.add(new Estudiante("Sofia", 4.0));
		return estudiantes;
	}

	static class Estudiante {
		private final String nombre;
		private final double nota;

		public Estudiante(String nombre, double nota) {
			this.nombre = nombre;
			this.nota = nota;
		}

		public String getNombre() {
			return nombre;
		}

		public double getNota() {
			return nota;
		}

		@Override
		public String toString() {
			return "Estudiante{" +
					"nombre='" + nombre + '\'' +
					", nota=" + nota +
					'}';
		}
	}

	static class Producto {
		private final String nombre;
		private final String categoria;
		private final double precio;
		private final boolean activo;

		public Producto(String nombre, String categoria, double precio, boolean activo) {
			this.nombre = nombre;
			this.categoria = categoria;
			this.precio = precio;
			this.activo = activo;
		}

		public String getNombre() {
			return nombre;
		}

		public String getCategoria() {
			return categoria;
		}

		public double getPrecio() {
			return precio;
		}

		public boolean isActivo() {
			return activo;
		}

		@Override
		public String toString() {
			return "Producto{" +
					"nombre='" + nombre + '\'' +
					", categoria='" + categoria + '\'' +
					", precio=" + precio +
					", activo=" + activo +
					'}';
		}
	}
}
