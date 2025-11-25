package Practica3.services;

import Practica3.DBConnection;
import Practica3.model_layer.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


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

    public boolean addCategoria (Categoria categoria) throws Exception {
        String sql = "INSERT INTO categorias VALUES (UUID(), ?,0);";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, categoria.getNombre_categoria());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

    public boolean updateCategoria (Categoria categoria) throws Exception {
        String sql = "UPDATE categorias SET nombre_categoria=? WHERE id_categoria=?";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, categoria.getNombre_categoria());
        ps.setString(2, categoria.getId_categoria());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }
    
    public ArrayList<Categoria> showCategorias(String buscar) throws Exception {
        ArrayList<Categoria> categorias = new ArrayList<>();
        
        String sql = "SELECT * FROM categorias";
        if (! buscar.isEmpty()) {
            sql += " WHERE nombre_categoria LIKE '%" + buscar + "%' AND is_hidden = 0 ORDER BY nombre_categoria ASC";
        }else{
            sql += " WHERE is_hidden = 0 ORDER BY nombre_categoria ASC";
        }
        
        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Categoria categoria = new Categoria(
                rs.getString("id_categoria"),
                rs.getString("nombre_categoria")
            );
            
            categorias.add(categoria);
        }
        rs.close();
        ps.close();
        con.close();
        
        return categorias;
    }

    public boolean deleteCategoria(Categoria c) throws Exception {
        String sql = "UPDATE categorias SET is_hidden = 1 WHERE id_categoria=?;";

        Connection con = db.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, c.getId_categoria());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }
}
