package Practica3.services;

import Practica3.DBConnection;
import Practica3.model_layer.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Link
 */
public class UsuarioService {
    private DBConnection db = new DBConnection();
    
    public Usuario findUser(String id) throws Exception {
        Usuario usuario = null;
        
        String sql = "SELECT * FROM usuarios WHERE id_usuario='" + id + "' ";
        
        Connection con = db.open();
        Statement stm = con.createStatement();
        
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next()) {
            usuario = new Usuario(
                rs.getString("id_usuario"),
                rs.getString("usuario"),
                rs.getString("contrasenia"),
                rs.getBoolean("es_admin")
            );
        }
        rs.close();
        stm.close();
        con.close();
        
        return usuario;
    }
    
    public Usuario findUser(String usr, String pass) throws Exception {
        Usuario usuario = null;
        
        String sql = "SELECT * FROM usuarios";
        sql += " WHERE usuario=? AND contrasenia=SHA2(?,256)";
        
        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usr);
        ps.setString(2, pass);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            usuario = new Usuario(
                rs.getString("id_usuario"),
                rs.getString("usuario"),
                rs.getString("contrasenia"),
                rs.getBoolean("es_admin")
            );
        }
        rs.close();
        ps.close();
        con.close();
        
        return usuario;
    }
    
    public boolean addUser(String usr, String pass) throws Exception {
        String sql = "INSERT INTO usuarios VALUES ";
        sql += "(UUID(), ?, SHA2(?,256), 0)";
        
        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usr);
        ps.setString(2, pass);
        
        int rowsAffected = ps.executeUpdate();
        
        ps.close();
        con.close();
        
        return rowsAffected > 0;
    }
    
}
