package Practica3.model_layer;

import java.io.Serializable;

/**
 *
 * @author Link
 */
public class Producto implements Serializable {
    private String id_producto;
    private String id_categoria;
    private String id_proveedor;
    private String nombre_producto;
    private Double precio;
    private int cantidad;
    private String foto_producto;
    private String nombre_foto_producto;
    private Categoria categoria;
    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(String id_producto, String id_categoria, String id_proveedor, String nombre_producto, Double precio, int cantidad, String foto_producto, String nombre_foto_producto) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.id_proveedor = id_proveedor;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.foto_producto = foto_producto;
        this.nombre_foto_producto = nombre_foto_producto;
    }

    public Producto(String id_producto, String id_categoria, String id_proveedor, String nombre_producto, Double precio, int cantidad, String foto_producto, String nombre_foto_producto, Categoria categoria, Proveedor proveedor) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.id_proveedor = id_proveedor;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.foto_producto = foto_producto;
        this.nombre_foto_producto = nombre_foto_producto;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFoto_producto() {
        return foto_producto;
    }

    public void setFoto_producto(String foto_producto) {
        this.foto_producto = foto_producto;
    }

    public String getNombre_foto_producto() {
        return nombre_foto_producto;
    }

    public void setNombre_foto_producto(String nombre_foto_producto) {
        this.nombre_foto_producto = nombre_foto_producto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", id_categoria=" + id_categoria + ", id_proveedor=" + id_proveedor + ", nombre_producto=" + nombre_producto + ", precio=" + precio + ", cantidad=" + cantidad + ", foto_producto=" + foto_producto + ", nombre_foto_producto=" + nombre_foto_producto + ", categoria=" + categoria.toString() + ", proveedor=" + proveedor.toString() + '}';
    }
    
}
