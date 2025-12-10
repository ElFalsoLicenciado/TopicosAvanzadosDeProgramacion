package Practica4.models;

import java.io.Serializable;

public class Venta implements Serializable{

    private Producto producto;
    private int cantidadVendida;
    private Double total;
    private String fecha;

    public Venta() {
    }

    public Venta(Producto producto, int cantidadVendida, Double total,
            String fecha) {
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
        this.total = total;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta{" + "producto=" + producto + ", cantidadVendida=" + cantidadVendida + ", total=" + total + ", fecha=" + fecha + '}';
    }
    
    
    
}
