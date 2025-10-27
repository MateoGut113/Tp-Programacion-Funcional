package org.example.entidades;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString

public class Producto {
    private String nombre;
    private ProductoCategoria categoria;
    private int precio;
    private int stock;

    public Producto(String nombre, ProductoCategoria categoria, int precio, int stock){
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo.");
        this.categoria = categoria;
        this.precio = validarCantidad(precio);
        this.stock = validarCantidad(stock);
    }

    private int validarCantidad(int number){
        Objects.requireNonNull(number, "La numero no puede ser nulo.");
        if(!(number >= 0)){
            throw new IllegalArgumentException("El numero debe ser mayor a 0.");
        }
        return number;
    }
}
