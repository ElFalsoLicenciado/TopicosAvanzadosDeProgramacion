package Practica3.services;

import Practica3.DBConnection;
import Practica3.model_layer.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Link
 */
public class CategoriaService {
    private DBConnection db = new DBConnection();
    
    public Categoria findCategoria(String id) throws Exception {
        Categoria categoria = null;
        
        String sql = "SELECT * FROM categorias WHERE id_categoria=?";
        
        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            categoria = new Categoria(
                rs.getString("id_categoria"),
                rs.getString("nombre_categoria")
            );
        }
        rs.close();
        ps.close();
        con.close();
        
        return categoria;
    }
}
