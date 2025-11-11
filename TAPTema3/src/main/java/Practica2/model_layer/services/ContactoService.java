package Practica2.model_layer.services;

import Practica2.model_layer.Conexion;
import Practica2.model_layer.models.Contacto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactoService {
    private Conexion conexion = new Conexion();

    public ArrayList<Contacto> showAll(int idUsuario, String busqueda) throws Exception {
        ArrayList<Contacto> contactos = new ArrayList<>();

        String sql = "SELECT * FROM contactos";
        sql += " WHERE id_usuario = ? ";
        if(! busqueda.isEmpty()) {
            sql += " AND nombre_contacto LIKE '%" + busqueda + "%'";
        }
        sql += " ORDER BY nombre_contacto ";

        Connection con = conexion.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idUsuario);

        System.out.println(ps);

        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Contacto contacto = new Contacto(
                    rs.getInt("id_contacto"),
                    rs.getInt("id_usuario"),
                    rs.getString("nombre_contacto"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getBytes("foto_contacto"),
                    rs.getString("nombre_foto")
            );

            contacto.setUsuario(
                    new UsuarioService().findUsr(
                            contacto.getId_usuario()
                    )
            );

            contactos.add(contacto);
        }
        rs.close();
        ps.close();
        con.close();

        return contactos;
    }

    public ArrayList<Contacto> showAll(String busqueda) throws Exception {
        ArrayList<Contacto> contactos = new ArrayList<>();

        String sql = "SELECT * FROM contactos";
        if(! busqueda.isEmpty()) {
            sql += " WHERE nombre_contacto LIKE '%" + busqueda + "%'";
        }
        sql += " ORDER BY nombre_contacto ";


        Connection con = conexion.open();
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.println(ps);

        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Contacto contacto = new Contacto(
                    rs.getInt("id_contacto"),
                    rs.getInt("id_usuario"),
                    rs.getString("nombre_contacto"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getBytes("foto_contacto"),
                    rs.getString("nombre_foto")
            );

            contacto.setUsuario(
                    new UsuarioService().findUsr(
                            contacto.getId_usuario()
                    )
            );

            contactos.add(contacto);
        }
        rs.close();
        ps.close();
        con.close();

        return contactos;
    }

    public boolean addContacto(Contacto contacto) throws Exception {
        String sql = "INSERT INTO contactos VALUES";
        sql += "(NULL,?,?,?,?,?,?)";

        Connection con = conexion.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, contacto.getId_usuario());
        ps.setString(2, contacto.getNombre_contacto());
        ps.setString(3, contacto.getTelefono());
        ps.setString(4, contacto.getCorreo());
        ps.setBytes(5, contacto.getFoto_contacto());
        ps.setString(6, contacto.getNombre_foto());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

    public boolean editContacto(Contacto contacto) throws Exception {
        String sql = "UPDATE contactos SET nombre_contacto=?, telefono=?," +
                " correo=?, foto_contacto=?, nombre_foto=? WHERE id_contacto=?";

        Connection con = conexion.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, contacto.getNombre_contacto());
        ps.setString(2, contacto.getTelefono());
        ps.setString(3, contacto.getCorreo());
        ps.setBytes(4, contacto.getFoto_contacto());
        ps.setString(5, contacto.getNombre_foto());
        ps.setInt(6, contacto.getId_contacto());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

    public boolean deleteContacto(Contacto contacto) throws Exception {
        String sql = "DELETE FROM contactos WHERE id_contacto=?";

        Connection con = conexion.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, contacto.getId_contacto());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

}
