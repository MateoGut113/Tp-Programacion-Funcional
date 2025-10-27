package org.example.entidades.Caso_4;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString

public class Empleado {
    private String nombre;
    private Departamento departamento;
    private int salario;
    private int edad;

    public Empleado(String nombre, Departamento departamento, int salario, int edad){
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.departamento = departamento;
        this.salario = validarCantidad(salario);
        this.edad = validarCantidad(edad);
    }
    private int validarCantidad(int number){
        Objects.requireNonNull(number, "La numero no puede ser nulo.");
        if(!(number >= 0)){
            throw new IllegalArgumentException("El numero debe ser mayor a 0.");
        }
        return number;
    }
}
