package Practica3.model_layer;

import java.util.ArrayList;

public class Venta {
    private String id_venta;
    private int numero;
    private String id_usuario;
    private String fecha;
    private Double total;
    private ArrayList<Detalle> detalles;
    private Usuario usuario;

    public Venta() {

    }

    public Venta(String id_venta, int numero, String id_usuario, String fecha, Double total) {
        this.id_venta = id_venta;
        this.numero = numero;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.total = total;
    }

    public Venta(String id_venta, int numero, String id_usuario, String fecha, Double total, ArrayList<Detalle> detalles, Usuario usuario) {
        this.id_venta = id_venta;
        this.numero = numero;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.total = total;
        this.detalles = detalles;
        this.usuario = usuario;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ArrayList<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<Detalle> detalles) {
        this.detalles = detalles;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
