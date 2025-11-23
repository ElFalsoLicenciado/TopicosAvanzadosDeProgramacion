package proyecto.services;

import proyecto.enums.RequestStatus;
import proyecto.models.Record;
import proyecto.models.Request;
import proyecto.utils.DBConnection;
import proyecto.utils.DialogHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequestServicesSQL {

    public static Request getRequest(String id_request) throws Exception {
        Request request = null;
        String sql = "SELECT * FROM record WHERE id_request = ? ;";

        Connection conn = DBConnection.open();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, id_request);

        ResultSet rs = ps.executeQuery();

        request = getQueryResult(rs);

        rs.close();
        ps.close();
        conn.close();

        return request;
    }

    public static boolean requestQuery(Record r) {
        boolean result = false;
        try {
            if (checkForRequest(r)) {
                if(updateRequest(r)) result = true;
            } else if (createRequest(r)) result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static boolean createRequest(Record r) throws Exception{
        String sql = "INSERT INTO requests VALUES (UUID(),?,?,?,?,?);";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, r.getId_record());
        ps.setInt(2, r.getRecord_number());
        ps.setString(3, r.getId_author());
        ps.setString(4, "WAITING");
        ps.setString(5,"");

        int rows = ps.executeUpdate();

        ps.close();
        con.close();

        if (rows > 0) {
            DialogHelper.infoMessageDialog("Espera a la aprobación de un administrador para que sea público.", "Guardado exitoso.");
            return true;
        }
        DialogHelper.errorMessageDialog("Error al guardar, intente de nuevo.", "Error de guardado.");
        return false;
    }

    private static boolean updateRequest(Record r) throws Exception{
        String sql = "UPDATE requests SET record_number=? WHERE id_record =? AND id_author=? AND status = 'WAITING';";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, r.getRecord_number());
        ps.setString(2, r.getId_record());
        ps.setString(3, r.getId_author());

        int rows = ps.executeUpdate();

        ps.close();
        con.close();

        if (rows > 0) {
            DialogHelper.infoMessageDialog("Espera a la aprobación de un administrador para que sea público.", "Guardado exitoso.");
            return true;
        }
        DialogHelper.errorMessageDialog("Error al guardar, intente de nuevo.", "Error de guardado.");
        return false;
    }

    public static ArrayList<Request> getRequests() throws Exception {
        ArrayList<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM requests;";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Request r = getRequest(rs.getString("id_request"));
            requests.add(r);
        }

        rs.close();
        ps.close();
        con.close();

        return requests;
    }

    public static ArrayList<Request> getUserRequests(String id_author) throws Exception {
        ArrayList<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM requests WHERE id_author = ?;";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id_author);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Request r = getRequest(rs.getString("id_request"));
            requests.add(r);
        }

        rs.close();
        ps.close();
        con.close();

        return requests;
    }

    public static boolean setRequestStatus(Record r, RequestStatus status, String reason) throws Exception{
        String sql = "UPDATE requests SET status = ?, reason = ? WHERE id_record =? AND id_author =? AND status = 'WAITING';";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, status.toString());
        ps.setString(2, reason);
        ps.setString(3, r.getId_record());
        ps.setString(4, r.getId_author());

        int rows = ps.executeUpdate();

        ps.close();
        con.close();

        if (rows > 0) {
            if (status == RequestStatus.APPROVED)
                if (RecordServicesSQL.setPublic(r)) {
                    DialogHelper.infoMessageDialog("La aprobación ha sido revisada y guardada.", "Guardado exitoso." );
                    return true;
            }
        }
        DialogHelper.errorMessageDialog("Error al guardar, intente de nuevo", "Error de guardado");
        return false;
    }

    private static boolean checkForRequest(Record r) throws Exception{
        String sql = "SELECT * FROM requests WHERE id_record = ? AND id_author = ? AND status = 'WAITING';";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, r.getId_record());
        ps.setString(2, r.getId_author());

        int rows = ps.executeUpdate();

        ps.close();
        con.close();

        return rows > 0;
    }

    private static Request getQueryResult(ResultSet rs) throws SQLException {
        Request r = null;
        try {
            if (rs.next()) {
                r = new Request(
                        rs.getString("id_request"),
                        rs.getString("id_record"),
                        rs.getInt("record_number"),
                        rs.getString("id_author"),
                        Enum.valueOf(RequestStatus.class, rs.getString("status")),
                        rs.getString("reason"),
                        RecordServicesSQL.getRecord(rs.getString("id_record"), rs.getInt("record_number"))

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

}
