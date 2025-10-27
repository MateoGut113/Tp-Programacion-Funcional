package org.example.entidades;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString

public class Libro {
    private String titulo;
    private String autor;
    private int paginas;
    private int precio;
    public Libro(String titulo, String autor, int paginas, int precio){
        this.titulo = Objects.requireNonNull(titulo, "El nombre no puede ser nulo.");
        this.autor = Objects.requireNonNull(autor, "El nombre no puede ser nulo.");
        this.paginas = validarCantidad(paginas);
        this.precio = validarCantidad(precio);
    }

    private int validarCantidad(int number){
        Objects.requireNonNull(number, "La numero no puede ser nulo.");
        if(!(number >= 0)){
            throw new IllegalArgumentException("El numero debe ser mayor a 0.");
        }
        return number;
    }
}
