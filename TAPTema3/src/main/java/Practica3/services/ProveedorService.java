package Practica3.services;

import Practica3.DBConnection;
import Practica3.model_layer.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Link
 */
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
}
