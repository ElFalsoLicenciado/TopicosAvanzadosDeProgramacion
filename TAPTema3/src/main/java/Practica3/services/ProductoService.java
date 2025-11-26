package Practica3.services;

import Practica3.DBConnection;
import Practica3.model_layer.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

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
                    rs.getInt("numero_producto"),
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
        int edition = getEditionNumber(p.getId_producto())+1;
        String id_producto = p.getId_producto();

        if (id_producto.isEmpty()) id_producto = UUID.randomUUID().toString().substring(0, 35);

        String sql = "INSERT INTO productos VALUES";
        sql += "(?,?,?,?,?,?,?,?,?,0)";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id_producto);
        ps.setInt(2, edition);
        ps.setString(3, p.getId_categoria());
        ps.setString(4, p.getId_proveedor());
        ps.setString(5, p.getNombre_producto());
        ps.setDouble(6, p.getPrecio());
        ps.setInt(7, p.getCantidad());
        ps.setString(8, p.getFoto_producto());
        ps.setString(9, p.getNombre_foto_producto());

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            deleteProducto(p);
        }

        ps.close();
        con.close();

        return rowsAffected > 0;
    }


    public boolean deleteProducto(Producto p) throws Exception {
        String sql = "UPDATE productos SET is_hidden = 1 WHERE id_producto=? AND numero_producto=?;";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, p.getId_producto());
        ps.setInt(2, p.getNumero_producto());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

    public int getEditionNumber(String id_producto) throws  Exception{
        int editions = 0;
        String sql = "SELECT * FROM productos WHERE id_producto = ?;";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id_producto);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            editions++;
        }

        rs.close();
        ps.close();
        con.close();

        return editions;
    }



    public Producto getProducto(String id_producto, int numero_producto) throws Exception {
        Producto p = new Producto();
        String sql = "SELECT * FROM productos WHERE id_producto = ? AND numero_producto = ?;";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id_producto);
        ps.setInt(2, numero_producto);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
             p = new Producto(
                    rs.getString("id_producto"),
                    rs.getInt("numero_producto"),
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
        }

        rs.close();
        ps.close();
        con.close();

        return p;
    }

    public boolean updateStock(String id_producto, int numero_producto, int vendido) throws Exception {
        int restante = getProducto(id_producto, numero_producto).getCantidad() - vendido;

        String sql = "UPDATE productos SET cantidad = ? WHERE id_producto = ? AND numero_producto = ?; ";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, restante);
        ps.setString(2, id_producto);
        ps.setInt(3, numero_producto);

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

}
