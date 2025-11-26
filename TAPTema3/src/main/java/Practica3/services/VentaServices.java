package Practica3.services;

import Practica3.DBConnection;
import Practica3.model_layer.Detalle;
import Practica3.model_layer.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VentaServices {
    private DBConnection db = new DBConnection();

    public ArrayList<Venta> getVentas() throws Exception{
        ArrayList<Venta> ventas = new ArrayList<>();

        String sql = "SELECT * FROM ventas ORDER BY fecha DESC";

        Connection con =db.open();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            Venta v = new Venta(
                    rs.getString("id_venta"),
                    rs.getInt("numero"),
                    rs.getString("id_usuario"),
                    rs.getString("fecha"),
                    rs.getDouble("total"),
                    getDetalles(rs.getString("id_venta")),
                    new UsuarioService().findUser(rs.getString("id_usuario"))
            );
            ventas.add(v);
        }
        rs.close();
        st.close();
        con.close();

        return ventas;
    }

    public int numeroDeVentas() throws Exception{
        int numero = 0;
        String sql = "SELECT COUNT(*) FROM ventas";

        Connection con =db.open();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);

        if (rs.next()){
            numero = rs.getInt(1);
        }

        rs.close();
        st.close();
        con.close();

        return numero;
    }

    private Venta getVenta(Venta v) throws Exception{
        Venta venta = new Venta();
        String sql = "SELECT * FROM ventas WHERE total = ? AND id_usuario = ? AND numero = ?";

        Connection con =db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, v.getTotal());
        ps.setString(2, v.getId_usuario());
        ps.setInt(3, v.getNumero());

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            venta = new Venta(
                    rs.getString("id_venta"),
                    rs.getInt("numero"),
                    rs.getString("id_usuario"),
                    rs.getString("fecha"),
                    rs.getDouble("total"),
                    getDetalles(rs.getString("id_venta")),
                    new UsuarioService().findUser(rs.getString("id_usuario"))
            );
        }

        rs.close();
        ps.close();
        con.close();

        return venta;
    }

    public Venta addVenta(Venta v) throws Exception {

        String sql = "INSERT INTO ventas VALUES";
        sql += "(UUID(),?,?,?,?)";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, v.getNumero());
        ps.setString(2, v.getId_usuario());
        ps.setString(3, v.getFecha());
        ps.setDouble(4, v.getTotal());

        int rowsAffected = ps.executeUpdate();

        if(rowsAffected > 0){
            v = getVenta(v);
        }

        ps.close();
        con.close();

        return v;
    }

    public ArrayList<Detalle> getDetalles(String id_venta) throws Exception{
        ArrayList<Detalle> detalles = new ArrayList<>();

        String sql = "SELECT * FROM detalles_venta WHERE id_venta = '" + id_venta + "' ORDER BY numero ASC" ;

        Connection con =db.open();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            Detalle d = new Detalle(
                    rs.getString("id_detalle"),
                    rs.getString("id_venta"),
                    rs.getInt("numero"),
                    rs.getString("id_producto"),
                    rs.getInt("numero_producto"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio_unitario"),
                    rs.getDouble("subtotal"),
                    new ProductoService().getProducto(rs.getString("id_producto"), rs.getInt("numero_producto"))
            );
            detalles.add(d);
        }

        rs.close();
        st.close();
        con.close();

        return detalles;
    }

    public boolean addDetalle(Detalle d) throws Exception{
        String sql = "INSERT INTO detalles_venta VALUES (UUID(),?,?,?,?,?,?,?)";

        Connection con =db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, d.getId_venta());
        ps.setInt(2, d.getNumero());
        ps.setString(3, d.getId_producto());
        ps.setInt(4, d.getNumero_producto());
        ps.setInt(5, d.getCantidad());
        ps.setDouble(6, d.getPrecio_unitario());
        ps.setDouble(7, d.getSubtotal());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        if (rowsAffected > 0 ) {
            new ProductoService().updateStock(d.getId_producto(), d.getNumero_producto(), d.getCantidad());
            return true;
        }
        return false;
    }

    public ArrayList<Venta> getVentasUsuario(String id_usuario) throws Exception{
        ArrayList<Venta> ventas = new ArrayList<>();

        String sql = "SELECT * FROM ventas WHERE id_usuario = '" + id_usuario + "' ORDER BY fecha DESC";

        Connection con =db.open();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            Venta v = new Venta(rs.getString("id_venta"),
                    rs.getInt("numero"),
                    rs.getString("id_usuario"),
                    rs.getString("fecha"),
                    rs.getDouble("total"),
                    getDetalles(rs.getString("id_venta")),
                    new UsuarioService().findUser(rs.getString("id_usuario"))
            );
            ventas.add(v);
        }

        rs.close();
        st.close();
        con.close();

        return ventas;
    }

}
