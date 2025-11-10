package Practica2.model_layer.services;

import Practica2.model_layer.Conexion;
import Practica2.model_layer.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Link
 */
public class UsuarioService {
    private Conexion conexion = new Conexion();

    public Usuario findUsr(int idUsuario) throws Exception {
        Usuario user = null;

        String sql = "SELECT * FROM usuarios WHERE id_usuario=" + idUsuario;

        Connection con = conexion.open();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(sql);
        if(rs.next()) {
            user = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("correo"),
                    rs.getString("contrasenia"),
                    rs.getString("nombre_completo"),
                    rs.getObject("es_admin", Boolean.class),
                    rs.getBytes("foto")
            );
        }
        rs.close();
        stm.close();
        con.close();

        return user;
    }

    public Usuario findUsr(String email, String pass) throws Exception {
        Usuario user = null;

        String sql = "SELECT * FROM usuarios WHERE correo=? AND contrasenia=SHA2(?,256)";

        Connection con = conexion.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, pass);

        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            user = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("correo"),
                    rs.getString("contrasenia"),
                    rs.getString("nombre_completo"),
                    rs.getObject("es_admin", Boolean.class),
                    rs.getBytes("foto")
            );
        }
        rs.close();
        ps.close();
        con.close();

        return user;
    }

    public boolean addUsr(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuarios VALUES";
        sql += "(NULL,?,SHA2(?,256),?,?,NULL)";

        Connection con = conexion.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getCorreo());
        ps.setString(2, usuario.getContrasenia());
        ps.setString(3, usuario.getNombre_completo());
        ps.setObject(4, usuario.getEs_admin());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

    public boolean editUsr(Usuario usuario, boolean esCambioPass) throws Exception {
        String sql = "UPDATE usuarios SET nombre_completo=? ";
        if(esCambioPass) {
            sql += ", contrasenia=SHA2(?,256) ";
        }
        sql += ", foto=? WHERE id_usuario=" + usuario.getId_usuario();

        Connection con = conexion.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNombre_completo());
        if(esCambioPass) {
            ps.setString(2, usuario.getContrasenia());
            ps.setBytes(3, usuario.getFoto());
        } else {
            ps.setBytes(2, usuario.getFoto());
        }

        System.out.println(sql);

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

}
