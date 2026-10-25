package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main2 {
    static void main() {
        /*
            Nivel Básico

            1) Dada una lista de números enteros, devuelve el primer número de la lista
            que sea múltiplo de 5 y mayor a 20. Si ningún número cumple la condición,
            el resultado debe ser -1.
         */

        System.out.println();
        System.out.println("Ejercicio basico 1");

        List<Integer> numeros1 = List.of(1, 2, 3, -3, -5, 1, 2, 3, 4, -25, 20, 20, 1);
        Optional<Integer> numOpt = numeros1.stream()
                .filter(n -> n % 5 != 1 && n > 20)
                .findFirst();

        if (numOpt.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(numOpt.get());
        }

        /*
            2) Dada una lista de cadenas de texto, obtén dos valores booleanos
            separados: uno que indique si todas las palabras tienen más de 3
            caracteres, y otro que indique si alguna palabra contiene la letra 'z'.
         */

        System.out.println();
        System.out.println("Ejercicio basico 2");

        List<String> listaCadenas = List.of("Hola, agua, perrzo camion. ARBOL", "orro", "apato", "silla", "escritorio calabaa, avion, ");
        boolean todosSonMayoresA3 = listaCadenas.stream()
                .map(s -> s.split("\\W+"))
                .flatMap(Arrays::stream)
                .allMatch(s -> s.length() > 3);

        System.out.println("¿Todas las palabras son de una longitud mayor a 3? --> " + todosSonMayoresA3);

        boolean algunoContieneZ = listaCadenas.stream()
                .map(s -> s.split("\\W+"))
                .flatMap(Arrays::stream)
                .anyMatch(s -> s.toLowerCase().contains("z"));

        System.out.println("¿Alguna de las palabras contiene z? --> " + algunoContieneZ);


        /*
            3) Dada una lista de números enteros generada del 1 al 100, ignora
            (salta) los primeros 15 elementos, toma únicamente los siguientes
            10 elementos, multiplícalos por 2 y devuelve la lista resultante.
         */

        System.out.println();
        System.out.println("Ejercicio basico 3");

        List<Integer> listaEnteros1 = IntStream.range(1, 101)
                .skip(15)
                .limit(10)
                .map(n -> n * 2)
                .boxed()
                .toList();

        System.out.println(listaEnteros1);

        /*
            Nivel Intermedio

            4) Dada una lista de números enteros, divídela en dos grupos utilizando un
            Map<Boolean, List<Integer>>: un grupo para los números pares (clave true) y
            otro para los impares (clave false).
         */


        System.out.println();
        System.out.println("Ejercicio Intermedio 4");

        List<Integer> enteros2 = IntStream.range(-5, 5).boxed().toList();

        Map<Boolean, List<Integer>> mapaEnteros2 = enteros2.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));

        mapaEnteros2.forEach((clave, valor) -> System.out.println("Clave: " + clave + " Valor: " + valor));

        /*
            5. Dada una clase Estudiante (con atributos nombre de tipo String y
            nota de tipo double), filtra aquellos estudiantes que hayan aprobado
            (nota mayor o igual a 6) y devuelve un único String con este formato
            exacto: "Aprobados: [nombre1, nombre2, nombre3]!".
         */



        /*
            6) Dada una clase Libro (con atributos titulo de tipo String,
            autor de tipo String y anioPublicacion de tipo int), devuelve la
            lista de libros ordenada con un criterio doble: primero ordenado
            por el nombre del autor alfabéticamente y, en caso de empate
            (mismo autor), ordenado por anioPublicacion de más reciente a más
            antiguo.
         */

        /*
            Nivel Avanzado
            7) Dada una lista de números enteros que incluye algunos ceros
            (ej: [2, 0, 4, 5, 0, 1]), calcula el producto de todos los números
            (multiplicarlos entre sí), pero ignorando completamente los ceros en el
            cálculo.
         */

        /*
            8) Dada una clase Venta (con atributos vendedor de tipo String,
            producto de tipo String, cantidad de tipo int y precioUnitario de
            tipo double), calcula el monto total recaudado por cada vendedor.
            El resultado debe ser un Map<String, Double> (Nota: el monto de una
            venta es cantidad * precioUnitario).
         */

        /*
             9) Dada una clase Vehiculo (con atributos marca de tipo String,
             modelo de tipo String, y tipo de tipo String -ej. "Auto", "Moto",
             "Camioneta"-), agrupa los vehículos primero por su tipo y, dentro
              de cada tipo, agrupa por marca contando cuántos vehículos hay de
              esa marca. El resultado final debe ser de tipo Map<String,
              Long Map<String,>>.
         */

        /*
                10. Dada una clase Proyecto (con atributos id de tipo int,
                nombre de tipo String, estado de tipo String -valores: "EN_CURSO" o
                "FINALIZADO"-, y desarrolladores de tipo List<String>), obtén un
                Set<String> que contenga los nombres de todos los desarrolladores
                únicos que están trabajando actualmente en al menos un proyecto que
                esté "EN_CURSO".
         */
    }
}
