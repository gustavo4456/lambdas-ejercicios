package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        /*
         *               Prácticando lambdas
         *               05/10/2026
         * */


        //Nivel Básico

        /*
         * 1) Dada una lista de números enteros, obtén una nueva lista que
         *    contenga únicamente los números impares.
         */

        List<Integer> listaEnteros = List.of(-3, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> listaImpares = listaEnteros.stream()
                .filter(n -> n % 2 != 0)
                .toList();

        System.out.println("================================");
        System.out.println("------Ejercicio 1: impares------");
        listaImpares.forEach(System.out::println);
        System.out.println("================================");



        /*
         *
         * 2) Dada una lista de cadenas de texto, devuelve una nueva lista
         *    con todas las cadenas convertidas a minúsculas.
         * */

        List<String> cadenas = List.of("Casa", "Auto", "PERRO", "Árbol");

        List<String> cadenasMinuscula = cadenas.stream()
                .map(String::toLowerCase)
                .toList();

        System.out.println("================================");
        System.out.println("------Ejercicio 2: minusculas------");
        cadenasMinuscula.forEach(System.out::println);
        System.out.println("================================");


        /*

         * 3) Dada una lista de números enteros, obtén la suma de los
         *    cuadrados de todos los números que sean estrictamente mayores a
         *    cero.
         * */

        List<Integer> listaEnteros2 = List.of(-1, -2, -3, 0, 1, 2, 3, 4, 5);
        int sumaCuadrados = listaEnteros2.stream()
                .filter(n -> n > 0)
                .mapToInt(n -> n * n)
                .sum();

        System.out.println("Resultado: " + sumaCuadrados);


        // EJERCICIOS INTERMEDIOS

        /*
         * Nivel Intermedio
         * 1) Dada una lista de cadenas de texto, devuelve una sola cadena que concatene todas aquellas palabras que
         * empiecen con la letra 'a' o 'A', separadas por una coma.
         * */

        System.out.println();
        System.out.println("Ejercicios intermedio");
        List<String> cadenas2 = List.of("Casa", "Auto oso perro arbol", "avion", "jirafa argentina");
        String cadenasUnidas = cadenas2.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .filter(s -> s.toLowerCase().trim().startsWith("a"))
                .collect(Collectors.joining(","));

        System.out.println(cadenasUnidas);



        /*
         * 2) Dada una clase Producto (con los atributos nombre de tipo String, categoria de tipo String y
         *    precio de tipo double), a partir de una lista de productos, obtén el nombre del producto más
         *    caro que pertenezca a la categoría "Electrónica".
         *
         * */

        System.out.println("Ejercicio intermedio 2");
        List<Producto> productos = List.of(
                new Producto("Notebook hp", "Electronica", 9200000.0),
                new Producto("Escritorio madera", "Muebles", 850999.0),
                new Producto("Macbook", "Electronica", 3200000.0),
                new Producto("Teclado gaming", "Electronica", 200000.0));

        Optional<Producto> prodCaroElectronica = productos.stream()
                .filter(p -> p.categoria().equals("Electronica"))
                .max(Comparator.comparing(Producto::precio));

        if (prodCaroElectronica.isEmpty()) {
            System.out.println("No hay productos cargados.");
        } else {
            System.out.println("El producto mas caro es:");
            System.out.println("Nombre: " + prodCaroElectronica.get().nombre());
            System.out.println("Categoria: " + prodCaroElectronica.get().categoria());
            System.out.println("Precio: " + prodCaroElectronica.get().precio());
        }


        /*
         *
         * 3) Dada una lista de palabras, devuelve un Map<Integer, List<String>> donde la clave del mapa sea la
         *    longitud de la palabra y el valor asociado sea la lista de palabras que comparten exactamente esa longitud.
         *
         * */

        List<String> palabras = List.of("Casa", "auto", "Computadora", "Mochila", "arbol", "tablero", "televisor", "cuaderno", "jirafa");

        Map<Integer, List<String>> mapPalabras = palabras.stream()
                .collect(Collectors.groupingBy(String::length));

        mapPalabras.forEach((key, value) -> System.out.println("Longitud: " + key + " Palabras: " + value));


        /*
         *
         * Nivel Avanzado
         *
         * */

        /*
         *  1) Dada una lista de listas de números enteros (List<List<Integer>>), aplana la estructura para obtener una única
         *    lista de números, elimina todos los duplicados y ordénala de mayor a menor.
         *
         * */

        System.out.println();
        System.out.println("Ejercicio avanzado 1");
        List<List<Integer>> listaNumeros12 = List.of(List.of(1, 1, 88, 88, 4, 3, 2), List.of(5, 1, 2, 5, 6, 2, 1, 1, 1, 2, 2));

        List<Integer> listaUnida12 = listaNumeros12.stream()
                .flatMap(List::stream)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();

        listaUnida12.forEach(System.out::println);

        /*
         * 2) Dada una clase Empleado (con atributos nombre de tipo String, departamento de tipo String y salario de tipo double),
         *    agrupa a todos los empleados por departamento y calcula el salario promedio de cada departamento, devolviendo el resultado en
         *    un Map<String, Double>.
         * */

        System.out.println();
        System.out.println("Ejercicio avanzado 2");

        List<Empleado> empleados = List.of(
                new Empleado("Juan Perez", "Marketing", 1200000.22),
                new Empleado("Maria Ramirez", "Marketing", 250999.12),
                new Empleado("Pedro Ruiz", "Informatica", 1500000.22),
                new Empleado("Sofia Silva", "Informatica", 1500000.22),
                new Empleado("Camila Artaza", "Ventas", 3200213.22),
                new Empleado("Magali Fernandez", "Ventas", 3200213.22)
        );

        Map<String, Double> departamentosRes = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::departamento, Collectors.averagingDouble(Empleado::salario)));

        System.out.println(departamentosRes);

        /*
         * 3) Dada una cadena de texto larga (por ejemplo, un artículo o párrafo de varias líneas), cuenta la frecuencia
         *    de cada palabra ignorando signos de puntuación y diferencias entre mayúsculas y minúsculas. El resultado final debe
         *    ser una lista de cadenas con las 3 palabras que más se repiten en el texto.
         * */

        System.out.println();
        System.out.println("Ejercicio avanzado 3");

        String cadenaLarga = "La tecnología avanza a un ritmo vertiginoso, transformando la manera en que interactuamos con el entorno digital. Desde el desarrollo de algoritmos de inteligencia artificial cada vez más sofisticados hasta la optimización de bases de datos masivas, los ingenieros y desarrolladores se enfrentan constantemente a nuevos retos técnicos. Probar y depurar código es una fase fundamental en cualquier ciclo de vida de desarrollo de software, ya que garantiza la robustez, escalabilidad y seguridad de las aplicaciones antes de su puesta en producción. Contar con datos de prueba variados, que incluyan caracteres especiales, tildes y diferentes longitudes de cadena, resulta indispensable para validar que el sistema maneje correctamente la codificación de caracteres y el formato de los textos sin generar errores inesperados.";

        Map<String, Long> mapaResString = Arrays.stream(cadenaLarga.split("\\W+"))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        List<String> listaMasRepetidas = mapaResString.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Long> e) -> e.getValue()).reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(listaMasRepetidas);



        /*
         * 4) Dada una clase Transaccion (con atributos id de tipo int, monto de tipo double, categoria de tipo String y
         *     fecha de tipo LocalDate), a partir de una lista de transacciones, genera un Map<String, Transaccion> que contenga
         *     la transacción de mayor valor para cada categoría, pero filtrando previamente para considerar únicamente aquellas
         *     transacciones realizadas durante el año en curso y cuyo monto sea superior a $1000.
         * */

        System.out.println();
        System.out.println("Ejercicio avanzado 4");

        List<Transaccion> transacciones = List.of(
                new Transaccion(1, 1500.00, "qr", LocalDate.now()),
                new Transaccion(2, 2500.00, "qr", LocalDate.now()),
                new Transaccion(3, 500.00, "qr", LocalDate.now()),
                new Transaccion(4, 2000.00, "qr", LocalDate.now().minusYears(1)),

                new Transaccion(5, 2500.00, "debito", LocalDate.now()),
                new Transaccion(6, 3500.00, "debito", LocalDate.now()),
                new Transaccion(7, 600.00, "debito", LocalDate.now()),
                new Transaccion(8, 3000.00, "debito", LocalDate.now().minusYears(1)),

                new Transaccion(9, 5500.00, "credito", LocalDate.now()),
                new Transaccion(10, 3500.00, "credito", LocalDate.now()),
                new Transaccion(11, 700.00, "credito", LocalDate.now()),
                new Transaccion(12, 5000.00, "credito", LocalDate.now().minusYears(1))
        );

        Map<String, Optional<Transaccion>> mapaTransacciones = transacciones.stream()
                .filter(t -> t.monto() > 1000 && t.fecha().getYear() == LocalDate.now().getYear())
                .collect(Collectors.groupingBy(Transaccion::categoria, Collectors.maxBy(Comparator.comparing(Transaccion::monto))));

        mapaTransacciones.forEach((clave, valor) -> System.out.println("Categoria: " + clave + " Monto: " + valor.get().monto()));


    }
}
