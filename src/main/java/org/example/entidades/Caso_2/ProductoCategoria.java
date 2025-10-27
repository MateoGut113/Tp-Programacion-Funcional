package org.example.entidades.Caso_2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor

public enum ProductoCategoria {
    ESCOLAR("Escolar"),
    LIMPIEZA("Limpieza"),
    ELECTRODOMESTICO("Electrodoméstico"),
    EQUIPO_ELECTRONICO("Equipo Electrónico");

    @ToString.Include
    private final String descripcion;

    @Override
    public String toString() {
        return "Categoria{" +
                "nombre=" + descripcion +
                '}';
    }
}