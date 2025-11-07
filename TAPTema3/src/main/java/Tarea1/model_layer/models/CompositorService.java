package Tarea1.model_layer.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class CompositorService {

    public static boolean create(byte [] foto_compositor, String nombre_compositor, Epoca epoca, int num_composiciones, Boolean vive) throws Exception {
        Connection con = DBConnection.open();

        String sql = "INSERT INTO compositores VALUES";
        sql += "(NULL, ?, ?, ?, ?, ?);";


        PreparedStatement ps = con.prepareStatement(sql);
        ps.setBytes(1, foto_compositor);
        ps.setString(2, nombre_compositor);
        ps.setString(3, epoca.toString());
        ps.setInt(4, num_composiciones);
        ps.setBoolean(5, vive);

        int rowsAffected = ps.executeUpdate();

        System.out.println(sql);

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

    public static ArrayList<Compositor> readAll() throws Exception {
        ArrayList<Compositor> compositores = new ArrayList<>();

        String sql = "SELECT * FROM compositores";

        Connection con = DBConnection.open();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()) {
            Compositor p = new Compositor(
                    rs.getInt("id_compositor"),
                    rs.getBytes("foto_compositor"),
                    rs.getString("nombre_compositor"),
                    Enum.valueOf(Epoca.class,rs.getString("epoca")),
                    rs.getInt("num_composiciones"),
                    rs.getObject("vive", Boolean.class)
            );

            compositores.add(p);
        }
        rs.close();
        stm.close();
        con.close();

        System.out.println(sql);

        return compositores;
    }

    public static boolean delete (int id_compositor) throws Exception {
        String sql = "DELETE FROM compositores WHERE id_compositor = " + id_compositor;

        Connection con = DBConnection.open();
        Statement stm = con.createStatement();

        System.out.println(sql);

        int rowsAffected = stm.executeUpdate(sql);

        stm.close();
        con.close();

        return rowsAffected > 0;
    }

    public static boolean update(int id_compositor,byte [] foto_compositor, String nombre_compositor, Epoca epoca, int num_composiciones, Boolean vive) throws Exception {
        Connection con = DBConnection.open();

        String sql = "UPDATE compositores SET foto_compositor = ?, nombre_compositor = ?, epoca = ?, num_composiciones = ?, vive = ? WHERE id_compositor = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setBytes(1, foto_compositor);
        ps.setString(2, nombre_compositor);
        ps.setString(3, epoca.toString());
        ps.setInt(4, num_composiciones);
        ps.setBoolean(5, vive);
        ps.setObject(6, id_compositor); //

        int rowsAffected = ps.executeUpdate();

        System.out.println(sql);

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

}
