package Practica3.services;

import Practica3.DBConnection;
import Practica3.model_layer.Detalle;
import Practica3.model_layer.Venta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VentaServices {
    private DBConnection db = new DBConnection();

    public ArrayList<Venta> getVentas() throws Exception{
        ArrayList<Venta> ventas = new ArrayList<>();

        String sql = "SELECT * FROM ventas";

        Connection con =db.open();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            Venta v = new Venta(
                    rs.getString("id_venta"),
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

    public ArrayList<Detalle> getDetalles(String id_venta) throws Exception{
        ArrayList<Detalle> detalles = new ArrayList<>();

        String sql = "SELECT * FROM detalles_venta WHERE id_venta = '" + id_venta + "'";

        Connection con =db.open();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            Detalle d = new Detalle(
                    rs.getString("id_detalle"),
                    rs.getString("id_venta"),
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

}
