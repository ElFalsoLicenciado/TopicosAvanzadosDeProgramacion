package Practica3.model_layer;

public class Detalle {
    private String id_detalle;
    private String id_venta;
    private int numero;
    private String id_producto;
    private int numero_producto;
    private int cantidad;
    private double precio_unitario;
    private double subtotal;
    private Producto producto;

    public Detalle() {
    }

    public Detalle(String id_detalle, String id_venta, int numero, String id_producto, int numero_producto, int cantidad, double precio_unitario, double subtotal) {
        this.id_detalle = id_detalle;
        this.id_venta = id_venta;
        this.numero = numero;
        this.id_producto = id_producto;
        this.numero_producto = numero_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
    }

    public Detalle(String id_detalle, String id_venta, int numero, String id_producto, int numero_producto, int cantidad, double precio_unitario, double subtotal, Producto producto) {
        this.id_detalle = id_detalle;
        this.id_venta = id_venta;
        this.numero = numero;
        this.id_producto = id_producto;
        this.numero_producto = numero_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public String getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(String id_detalle) {
        this.id_detalle = id_detalle;
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

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public int getNumero_producto() {
        return numero_producto;
    }

    public void setNumero_producto(int numero_producto) {
        this.numero_producto = numero_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
