package org.example;

import org.example.entidades.Caso_1.*;
import org.example.entidades.Caso_2.*;
import org.example.entidades.Caso_3.*;
import org.example.entidades.Caso_4.*;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        System.out.println("===Probamos: Caso Práctico 1.===");
        List<Alumno> alumnos = List.of(
                new Alumno("Ana", 8.5, Curso.DESARROLLO_DE_SOFTWARE),
                new Alumno("Luis", 5.5, Curso.FISICA_II),
                new Alumno("Pedro", 7.5, Curso.INGLES_I),
                new Alumno("Juan", 9.0, Curso.INGLES_I),
                new Alumno("Rocio", 8.0, Curso.FISICA_II),
                new Alumno("Manuel", 4.5, Curso.DESARROLLO_DE_SOFTWARE),
                new Alumno("Abril", 6.0, Curso.FISICA_II),
                new Alumno("Nahuel", 10.0, Curso.DESARROLLO_DE_SOFTWARE)
        );


        System.out.println("\n=> Ejercicio 1:");
        String nombres = alumnos.stream()
                .filter(a -> a.getNota() >= 7.0)
                .map(Alumno::getNombre)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println("Los alumnos con nota mayor o igual a 7 son: " +nombres);


        System.out.println("\n=>Ejercicio 2:");
        Double sumatoriaNotas = alumnos.stream()
                .map(Alumno::getNota)
                .reduce(0.0, (a, b) -> (Double) a + b);
        double sumatoriaAlumnos = (double) alumnos.stream()
                        .count();
        System.out.println("Notas total: "+sumatoriaNotas);
        System.out.println("Cantidad de alumnos: " +sumatoriaAlumnos);
        PromedioNotas promedioNotas = (a, b) -> (double) a / b; //Implementacion de Interface Funcional
        System.out.println("El promedio de notas general es: " + promedioNotas.divide(sumatoriaNotas, sumatoriaAlumnos) );


        System.out.println("\n=>Ejercicio 3:");
        Map<Curso, List<Alumno>> porCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));
        System.out.println("Alumnos ordenados por curso:\n" +porCurso);


        System.out.println("\n=>Ejercicio 4:");
        List<Alumno> mejoresAlumnos = alumnos.stream()
                .sorted(Comparator.comparing(Alumno::getNota).reversed())
                .limit(3)
                .toList();
        System.out.println("Los tres mejores promedios son:");
        mejoresAlumnos.forEach(a -> System.out.println(a.getNombre() + " - Promedio: " + a.getNota()));


        //------------------------------------------------------
        System.out.println("\n===Probamos: Caso Práctico 2.===");
        List<Producto> productos = List.of(
                new Producto("Cuaderno", ProductoCategoria.ESCOLAR,5, 60),
                new Producto("Esponja de baño", ProductoCategoria.LIMPIEZA,3, 70),
                new Producto("Detergente", ProductoCategoria.LIMPIEZA,7, 40),
                new Producto("Lapicera", ProductoCategoria.ESCOLAR,1, 100),
                new Producto("Heladera", ProductoCategoria.ELECTRODOMESTICO,450, 30),
                new Producto("Microondas", ProductoCategoria.ELECTRODOMESTICO,150, 20),
                new Producto("Computadora", ProductoCategoria.EQUIPO_ELECTRONICO,400, 25),
                new Producto("TV", ProductoCategoria.EQUIPO_ELECTRONICO,250, 20)
        );


        System.out.println("\n=>Ejercicio 1:");
        List<Producto> precioMayor100 = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .toList();
        System.out.println("Los productos con precio mayor a $100 son: \n");
        precioMayor100.forEach(p ->
                System.out.println(p.getNombre() + " - $" + p.getPrecio()));


        System.out.println("\n=>Ejercicio 2:");
        Map<ProductoCategoria, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock) //Realiza una sumatoria interna
                ));
        System.out.println("Cálculo de stock total por categoria:\n "+stockPorCategoria);


        System.out.println("\n=>Ejercicio 3:");
        String productosNombreYPrecio= productos.stream()
                .map(p -> p.getNombre() + " - $" + p.getPrecio())
                .collect(Collectors.joining("; "));
        System.out.println(productosNombreYPrecio);


        System.out.println("\n=>Ejercicio 4:");
        Map<ProductoCategoria, Double> precioPromedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
        System.out.println("Promedio por categoria:\n " + precioPromedioPorCategoria);

        OptionalDouble precioPromedioTotal = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average();
        precioPromedioTotal.ifPresent(p -> System.out.println("Precio promedio general: $" + p));


        //------------------------------------------------------
        System.out.println("\n===Probamos: Caso Práctico 3.===");
        List<Libro> libros = List.of(
                new Libro("Harry Potter y la camara secreta", "J. K. Rowling",350, 60),
                new Libro("Harry Potter y el cáliz de fuego", "J. K. Rowling",380, 70),
                new Libro("Los juegos del hambre: Sinsajo", "Suzanne Collins",200, 45),
                new Libro("Los juegos del hambre: En llamas", "Suzanne Collins",210, 50),
                new Libro("La Odisea", "Homero",230, 40),
                new Libro("La Iliada", "Homero",210, 45),
                new Libro("El equipo de los sueños", "Sergio Olguín",150, 15)
                );


        System.out.println("\n=>Ejercicio 1:");
        List<String> librosMasPaginas = libros.stream()
                .filter(l -> l.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .toList();
        System.out.println("Los libros con mas de 300 paginas son: "+librosMasPaginas);


        System.out.println("\n=>Ejercicio 2:");
        OptionalDouble promedioPaginasTotal = libros.stream()
                .mapToDouble(Libro::getPaginas)
                .average();
        promedioPaginasTotal.ifPresent(l -> System.out.println("Paginas promedio total: " + l));


        System.out.println("\n=>Ejercicio 3:");
        Map<String, Long> cantidadLibrosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()
                ));
        System.out.println("Cantidad de libros por autor:\n " + cantidadLibrosPorAutor);


        System.out.println("\n=>Ejercicio 4:");
        Optional<Libro> libroMasCaro = libros.stream()
                .sorted(Comparator.comparingInt(Libro::getPrecio).reversed())
                .findFirst();
        libroMasCaro.ifPresent(l ->
                System.out.println("Libro más caro: " + l.getTitulo() + " - Precio $" + l.getPrecio()));


        //------------------------------------------------------
        System.out.println("\n===Probamos: Caso Práctico 4.===");
        List<Empleado> empleados = List.of(
                new Empleado("Jorge", Departamento.RECURSOS_HUMANOS,2350, 30),
                new Empleado("Luis", Departamento.RECURSOS_HUMANOS,1850, 35),
                new Empleado("Gerardo", Departamento.LOGISTICA,2050, 40),
                new Empleado("Sebastian", Departamento.LOGISTICA,3350, 60),
                new Empleado("Amanda", Departamento.FINANZAS,2550, 30),
                new Empleado("Valentina", Departamento.FINANZAS,1550, 25),
                new Empleado("Lucas", Departamento.VENTAS,1650, 27),
                new Empleado("Vanessa", Departamento.VENTAS,1750, 28)
        );


        System.out.println("\n=>Ejercicio 1:");
        List<Empleado> mejoresPagos = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .toList();
        System.out.println("Los empleados con salario mayor a $2000 son:\n ");
        mejoresPagos.forEach(e ->
                System.out.println(e.getNombre() + " - $" + e.getSalario()));


        System.out.println("\n=>Ejercicio 2:");
        OptionalDouble promedioSalarioGeneral = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average();
        promedioSalarioGeneral.ifPresent(l -> System.out.println("Salario promedio general: $" + l));


        System.out.println("\n=>Ejercicio 3:");
        Map<Departamento, Double> salarioPorDepartamento = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));
        System.out.println("Cálculo de salario total por departamento:\n "+salarioPorDepartamento);


        System.out.println("\n=>Ejercicio 4:");
        List<Empleado> empleadosMasJovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .toList();

        System.out.println("Los 2 empleados mas jovenes son: \n");
        empleadosMasJovenes.forEach(e ->
                System.out.println(e.getNombre() + " - Edad: " + e.getEdad()));
    }
}