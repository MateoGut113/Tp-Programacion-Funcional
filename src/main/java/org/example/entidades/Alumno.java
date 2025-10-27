package org.example.entidades;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString

public class Alumno {
    private String nombre;
    private Double nota;
    private Curso curso;

    public Alumno(String nombre, Double nota, Curso curso){
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo.");
        this.nota = validarNota(nota);
        this.curso = curso;
    }

    private Double validarNota(Double nota){
        Objects.requireNonNull(nota, "La nota no puede ser nula.");
        if(nota > 10.0 || nota < 0){
            throw new IllegalArgumentException("La nota debe estar entre 0 o 10");
        }
        return nota;
    }
}
