package Practica3.model_layer;

public class ItemCarrito {

    private int cantidad;
    private double precio;
    private double subtotal;
    private Producto producto;


    public ItemCarrito() {

    }

    public ItemCarrito(int cantidad, double precio, double subtotal, Producto producto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
