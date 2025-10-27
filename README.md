# Trabajo Práctico - Programación Funcional

## 📋 OBJETIVO GENERAL

Practicar operaciones intermedias y terminales de los Streams en Java para procesar
colecciones de forma declarativa.

### ✅ Requisitos

- Java 8 o superior
- IDE compatible con Maven o Gradle (opcional)

## 📝 Uso del Sistema

### 1. Caso Práctico
   Dada la clase Alumno(nombre, nota, curso):
1. Obtener los nombres de los alumnos aprobados (nota ≥ 7) en mayúsculas y
   ordenados.
2. Calcular el promedio general de notas.
3. Agrupar alumnos por curso usando Collectors.groupingBy().
4. Obtener los 3 mejores promedios.

### Descripcion:
Utilizacion del paquete "Caso_1":\
Contiene a la clase `Alumno`, la clase enumerada `Curso` y a la interface funcional `PromedioNotas`.

### 2. Caso Práctico
   Dada la clase Producto(nombre, categoria, precio, stock):
1. Listar los productos con precio mayor a 100, ordenados por precio
   descendente.
2. Agrupar productos por categoría y calcular el stock total.
3. Generar un String separando con “;” cada producto que contenga nombre y
   precio, usando map + collect(joining).
4. Calcular el precio promedio general y por categoría.

### Descripcion:
Utilizacion del paquete "Caso_2":\
Contiene a la clase `Producto` y a la clase enumerada `ProductoCategoria`.

### 3. Caso Práctico
   Dada la clase Libro(titulo, autor, paginas, precio):
1. Listar los títulos de los libros con más de 300 páginas, ordenados
   alfabéticamente.
2. Calcular el promedio de páginas de todos los libros.
3. Agrupar los libros por autor y contar cuántos libros tiene cada uno.
4. Obtener el libro más caro de la lista

### Descripcion:
Utilizacion del paquete "Caso_3":\
Contiene a la clase `Libro`.

### 4. Caso Práctico
   Dada la clase Empleado(nombre, departamento, salario, edad):
1. Obtener la lista de empleados cuyo salario sea mayor a 2000, ordenados
   por salario descendente.
2. Calcular el salario promedio general.
3. Agrupar los empleados por departamento y calcular la suma de salarios de
   cada uno.
4. Obtener los nombres de los 2 empleados más jóvenes

### Descripcion:
Utilizacion del paquete "Caso_4":\
Contiene a la clase `Empleado` y a la clase enumerada `Departamento`.

### 🔍 Enumeraciones del Sistema a utilizar

- `Curso` con:

DESARROLLO_DE_SOFTWARE,\
FISICA_II,\
INGLES_I

- `ProductoCategoria` con:

ESCOLAR,\
LIMPIEZA,\
ELECTRODOMESTICO,\
EQUIPO_ELECTRONICO

- `Departamento` con:

RECURSOS_HUMANOS,\
LOGISTICA,\
FINANZAS,\
VENTAS