package Practica1.model_layer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Link
 */
public class ProductoService {
    
    public static boolean create(String nombre) throws Exception {
        String sql = "INSERT INTO productos VALUES";
        sql += "(NULL, '" + nombre + "')";
        
        Connection con = DBConnection.open();
        Statement stm = con.createStatement();
        
        int rowsAffected = stm.executeUpdate(sql);
        
        stm.close();
        con.close();
        
        return rowsAffected > 0;
    }
    
    public static ArrayList<Producto> readAll() throws Exception {
        ArrayList<Producto> productos = new ArrayList<>();
        
        String sql = "SELECT * FROM productos";
        
        Connection con = DBConnection.open();
        Statement stm = con.createStatement();
        
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()) {
            Producto p = new Producto(
                rs.getInt("id_producto"),
                rs.getString("nombre_producto")
            );
            
            productos.add(p);
        }
        rs.close();
        stm.close();
        con.close();
        
        return productos;
    }
    
    public static boolean update(int id, String nombre) throws Exception {
        String sql = "UPDATE productos SET nombre_producto='";
        sql += nombre + "' WHERE id_producto=" + id;
        
        Connection con = DBConnection.open();
        Statement stm = con.createStatement();
        
        int rowsAffected = stm.executeUpdate(sql);
        
        stm.close();
        con.close();
        
        return rowsAffected > 0;
    }
    
    public static boolean delete (int id_producto) throws Exception {
        String sql = "DELETE FROM productos WHERE id_producto = " + id_producto;

        Connection con = DBConnection.open();
        Statement stm = con.createStatement();

        int rowsAffected = stm.executeUpdate(sql);

        stm.close();
        con.close();

        return rowsAffected > 0;
    }
    
}
