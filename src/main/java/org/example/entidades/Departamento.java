package org.example.entidades;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor

public enum Departamento {
    RECURSOS_HUMANOS("Recursos Humanos"),
    LOGISTICA("Logistica"),
    FINANZAS("Finanzas"),
    VENTAS("Ventas");

    @ToString.Include
    private final String descripcion;

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre=" + descripcion +
                '}';
    }
}
