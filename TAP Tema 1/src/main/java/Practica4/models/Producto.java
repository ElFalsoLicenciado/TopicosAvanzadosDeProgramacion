/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica4.models;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author michael
 */
public class Producto implements Serializable {
    private String id;
    private String nombreProducto;
    private String fotoProducto;
    private Double precio;
    private int cantidad;

    public Producto() {
        id = UUID.randomUUID().toString().substring(0, 5);

    }

    public Producto(String id, String nombreProducto, String fotoProducto, Double precio, int cantidad) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.fotoProducto = fotoProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(String fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getId() {
        return id;
    }
    

    @Override
    public String toString() {
        return "Producto{" + "nombreProducto=" + nombreProducto + ", fotoProducto=" + fotoProducto + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }
    
    
}
