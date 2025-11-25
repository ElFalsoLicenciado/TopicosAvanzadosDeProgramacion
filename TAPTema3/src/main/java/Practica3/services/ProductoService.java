package Practica3.services;

import Practica3.DBConnection;
import Practica3.model_layer.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoService {
    private DBConnection db = new DBConnection();

    public ArrayList<Producto> getProductos(String buscar) throws Exception {
        ArrayList<Producto> productos = new ArrayList<>();

        String sql = "SELECT * FROM productos ";
        if(! buscar.isEmpty()) {
            sql += " WHERE nombre_producto LIKE '%" + buscar + "%' AND is_hidden = 0 ORDER BY nombre_producto ASC";
        }else {
            sql += " WHERE is_hidden = 0 ORDER BY nombre_producto ASC";
        }
        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Producto p = new Producto(
                    rs.getString("id_producto"),
                    rs.getString("id_categoria"),
                    rs.getString("id_proveedor"),
                    rs.getString("nombre_producto"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad"),
                    rs.getString("foto_producto"),
                    rs.getString("nombre_foto_producto")
            );

            p.setCategoria(
                    new CategoriaService().findCategoria(
                            p.getId_categoria()
                    )
            );

            p.setProveedor(
                    new ProveedorService().findProveedor(
                            p.getId_proveedor()
                    )
            );

            productos.add(p);
        }
        rs.close();
        ps.close();
        con.close();

        return productos;
    }

    public boolean addProducto(Producto p) throws Exception {
        String sql = "INSERT INTO productos VALUES";
        sql += "(UUID(),?,?,?,?,?,?,?,0)";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, p.getId_categoria());
        ps.setString(2, p.getId_proveedor());
        ps.setString(3, p.getNombre_producto());
        ps.setDouble(4, p.getPrecio());
        ps.setInt(5, p.getCantidad());
        ps.setString(6, p.getFoto_producto());
        ps.setString(7, p.getNombre_foto_producto());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

    public boolean editProducto(Producto p) throws Exception {
        String sql = "UPDATE productos SET ";
        sql += "id_categoria=?, ";
        sql += "id_proveedor=?, ";
        sql += "nombre_producto=?, ";
        sql += "precio=?, ";
        sql += "cantidad=?, ";
        sql += "foto_producto=?, ";
        sql += "nombre_foto_producto=? ";
        sql += " WHERE id_producto=? ";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, p.getId_categoria());
        ps.setString(2, p.getId_proveedor());
        ps.setString(3, p.getNombre_producto());
        ps.setDouble(4, p.getPrecio());
        ps.setInt(5, p.getCantidad());
        ps.setString(6, p.getFoto_producto());
        ps.setString(7, p.getNombre_foto_producto());
        ps.setString(8, p.getId_producto());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

    public boolean deleteProducto(Producto p) throws Exception {
        String sql = "UPDATE productos SET is_hidden = 1 WHERE id_producto=?;";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, p.getId_producto());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

}
