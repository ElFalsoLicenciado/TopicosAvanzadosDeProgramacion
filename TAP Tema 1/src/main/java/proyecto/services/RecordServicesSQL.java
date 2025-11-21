package proyecto.services;

import proyecto.enums.RecordType;
import proyecto.enums.StateNames;
import proyecto.models.Record;
import proyecto.models.User;
import proyecto.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordServicesSQL {

    public static Record getRecord(String id_record, int record_number) throws Exception {
        Record record = null;
        String sql = "SELECT * FROM record WHERE id_record = ? AND record_number = ?;";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id_record);
        ps.setInt(2, record_number);

        ResultSet rs = ps.executeQuery();

        record = getQueryResult(rs);

        rs.close();
        ps.close();
        con.close();

        return record;
    }

    public static ArrayList<Record> getUserRecords(String id_user) throws Exception {
        ArrayList<Record> records = new ArrayList<>();

        String sql = "SELECT * FROM records WHERE id_author = ? AND is_hidden = 0";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id_user);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Record r = getRecord(rs.getString("id_record"), rs.getInt("record_number"));
            records.add(r);
        }

        rs.close();
        ps.close();
        con.close();

        return records;
    }

    public static ArrayList<Record> getApprovedRecords() throws Exception {
        ArrayList<Record> records = new ArrayList<>();

        String sql = "SELECT * FROM records WHERE is_approved = 1 AND is_hidden = 0";

        Connection con = DBConnection.open();

        ResultSet rs = con.prepareStatement(sql).executeQuery();

        while (rs.next()) {
            Record r = getRecord(rs.getString("id_record"), rs.getInt("record_number"));
            records.add(r);
        }

        rs.close();
        con.close();

        return records;
    }

    public static ArrayList<Record> getUnapprovedRecords() throws Exception {}

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

    private static Record getQueryResult(ResultSet rs) throws SQLException {
        Record r = null;
        try {
            if (rs.next()) {
                r = new Record(
                        rs.getString("id_record"),
                        rs.getInt("record_number"),
                        rs.getString("id_author"),
                        Enum.valueOf(StateNames.class, rs.getString("state_name")),
                        Enum.valueOf(RecordType.class, rs.getString("record_type")),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("image_name"),
                        rs.getInt("is_hidden"),
                        rs.getInt("is_public"),
                        UserServicesSQL.getUser(rs.getString("id_author"))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
