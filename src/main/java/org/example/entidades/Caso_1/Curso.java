package org.example.entidades.Caso_1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor

public enum Curso {
    DESARROLLO_DE_SOFTWARE("Desarrollo de Sotfware"),
    FISICA_II("Fisica II"),
    INGLES_I("Ingles I");

    @ToString.Include
    private final String descripcion;

    @Override
    public String toString() {
        return "Curso{" +
                "nombre=" + descripcion +
                '}';
    }
}
