package Practica3.services;

import Practica3.DBConnection;
import Practica3.model_layer.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProveedorService {
    private DBConnection db = new DBConnection();
    
    public Proveedor findProveedor(String id) throws Exception {
        Proveedor proveedor = null;
        
        String sql = "SELECT * FROM proveedores WHERE id_proveedor=?";
        
        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            proveedor = new Proveedor(
                rs.getString("id_proveedor"),
                rs.getString("nombre_proveedor"),
                rs.getString("fecha_surte")
            );
        }
        rs.close();
        ps.close();
        con.close();
        
        return proveedor;
    }
    
    public ArrayList<Proveedor> showProveedores(String buscar) throws Exception {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        
        String sql = "SELECT * FROM proveedores";
        if (! buscar.isEmpty()) {
            sql += " WHERE nombre_proveedor LIKE '%" + buscar + "%' AND is_hidden = 0 ORDER BY nombre_proveedor ASC";
        }else {
            sql += " WHERE is_hidden = 0 ORDER BY nombre_proveedor ASC";
        }
        
        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Proveedor proveedor = new Proveedor(
                rs.getString("id_proveedor"),
                rs.getString("nombre_proveedor"),
                rs.getString("fecha_surte")
            );
            
            proveedores.add(proveedor);
        }
        rs.close();
        ps.close();
        con.close();
        
        return proveedores;
    }

    public boolean addProveedor(Proveedor proveedor) throws Exception {
        String sql = "INSERT INTO proveedores VALUES (UUID(),?,?,0)";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, proveedor.getNombre_proveedor());
        ps.setString(2, proveedor.getFecha_surte());

        int rows = ps.executeUpdate();

        ps.close();
        con.close();

        return rows > 0;
    }

    public boolean editProveedor(Proveedor proveedor) throws Exception {
        String sql = "UPDATE proveedores SET nombre_proveedor=?,fecha_surte=? WHERE id_proveedor=?";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, proveedor.getNombre_proveedor());
        ps.setString(2, proveedor.getFecha_surte());
        ps.setString(3, proveedor.getId_proveedor());

        int rows = ps.executeUpdate();

        ps.close();
        con.close();

        return rows > 0;
    }

    public boolean deleteProveedor(Proveedor p) throws Exception {
        String sql = "UPDATE proveedores SET is_hidden = 1 WHERE id_proveedor=?;";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, p.getId_proveedor());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }
}
