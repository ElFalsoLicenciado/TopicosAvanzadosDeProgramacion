package proyecto.services;

import proyecto.models.Record;
import proyecto.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RecordServicesSQL {

    public static boolean addRecord(Record r) throws Exception {
        int record_number = r.getRecord_number() + 1;

        String sql = "INSERT INTO records VALUES ";
        sql += "(UUID(),?,?,?,?,?,?,?,?,?,?);";
        //(id_record, record_number, id_author, state_name, record_type, title, description, image, image_name, is_hidden, is_public)

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, record_number);
        ps.setString(2, r.getId_author());
        ps.setString(3, r.getState_name().toString());
        ps.setString(4, r.getRecord_type().toString());
        ps.setString(5, r.getTitle());
        ps.setString(6, r.getDescription());
        ps.setString(7, r.getImage());
        ps.setString(8, r.getImage_name());
        ps.setInt(9, r.is_hidden());
        ps.setInt(10, r.is_public());

        int rows = ps.executeUpdate();

        ps.close();
        con.close();

        return rows > 0;
    }

    public static boolean deleteRecord(Record r) throws Exception {
        String sql = "UPDATE FROM records SET is_hidden = 1 WHERE id_record =? AND record_number=?;";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, r.getId_record());
        ps.setInt(2, r.getRecord_number());

        int rows = ps.executeUpdate();

        ps.close();
        con.close();

        return rows > 0;
    }
}
