package Practica3.model_layer;

import java.io.Serializable;

/**
 *
 * @author Link
 */
public class Proveedor implements Serializable {
    private String id_proveedor;
    private String nombre_proveedor;
    private String fecha_surte;

    public Proveedor() {
    }

    public Proveedor(String id_proveedor, String nombre_proveedor, String fecha_surte) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.fecha_surte = fecha_surte;
    }

    public String getFecha_surte() {
        return fecha_surte;
    }

    public void setFecha_surte(String fecha_surte) {
        this.fecha_surte = fecha_surte;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_proveedor=" + id_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", fecha_surte=" + fecha_surte + '}';
    }
    
}
