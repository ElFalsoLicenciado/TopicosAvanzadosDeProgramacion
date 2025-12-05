package proyecto.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import proyecto.enums.UserType;
import proyecto.models.User;
import proyecto.utils.DBConnection;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;


public class UserServicesSQL {

    private static final String url =  "http://localhost/TAP_2025/Proyecto/";

    public static boolean addUser(User u) throws Exception {
        String sql = "INSERT INTO users VALUES (UUID(), ?, ?, ?)";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, u.getUser_type().toString());
        ps.setString(2, u.getUsername());
        ps.setString(3, u.getPassword());

        int rowsAffected = ps.executeUpdate();

        ps.close();
        con.close();

        return rowsAffected > 0;
    }

    public static boolean addUser2(User u) throws Exception {
        Form form = Form.form();
        form.add("operation", "add");
        form.add("type", u.getUser_type().toString());
        form.add("username", u.getUsername());
        form.add("password", u.getPassword());

        String result = Request.post(
                url + "end_point_users.php"
        ).bodyForm(form.build()).execute().returnContent().asString();

        System.out.println(result);

        return ! result.contains("\"error\"");
    }

    public static ArrayList<User> getUsers() throws Exception {
        ArrayList<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        Connection con = DBConnection.open();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            User u = getUser(rs.getString("id_user"));
            System.out.println(u.getUsername());
            users.add(u);
        }

        rs.close();
        stm.close();
        con.close();

        return users;
    }

    public static ArrayList<User> getUsers2() throws Exception {
        ArrayList<User> users = new ArrayList<>();

        String results = Request.get(
                url + "end_point_users.php?operation=getAll"
        ).execute().returnContent().asString();

        Type listType = new TypeToken<ArrayList<User>>(){}.getType();
        users = new Gson().fromJson(results, listType);

        return users;
    }

    public static User getUser(String id_user) throws Exception {
        User user = null;

        String sql = "SELECT * FROM users WHERE id_user = '" + id_user + "';";

        Connection con = DBConnection.open();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        user = getQueryResult(rs);

        rs.close();
        stm.close();
        con.close();

        return user;
    }

    public static User getUser2(String id_user) throws Exception {
        ArrayList<User> users = new ArrayList<>();

        Form form = Form.form();
        form.add("operation", "getById");
        form.add("id_user", id_user);

        String results = Request.post(
                url + "end_point_users.php"
        ).bodyForm(form.build()).execute().returnContent().asString();

        System.out.println(results);

        Type listType = new TypeToken<ArrayList<User>>(){}.getType();
        users = new Gson().fromJson(results, listType);

        return users.getFirst();
    }

    public static User getUser(String username, String password) throws Exception {
        User user = null;

        String sql = "SELECT * FROM users";
        sql += " WHERE username=? AND password=?";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        user = getQueryResult(rs);

        rs.close();
        ps.close();
        con.close();


        return user;
    }

    public static User getUser2(String username, String password) throws Exception {
        ArrayList<User> users = new ArrayList<>();

        Form form = Form.form();
        form.add("operation", "getByCredentials");
        form.add("username", username );
        form.add("password", password);

        String results = Request.post(
                url + "end_point_users.php"
        ).bodyForm(form.build()).execute().returnContent().asString();

        System.out.println(results);

        Type listType = new TypeToken<ArrayList<User>>(){}.getType();
        users = new Gson().fromJson(results, listType);

        return users.getFirst();
    }

    public static boolean checkUsername(String username) throws Exception {
        boolean result = false;
        String sql = "SELECT * FROM users WHERE username='" + username + "';";

        Connection con = DBConnection.open();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        if (rs.next()) {
            result = true;
        }

        rs.close();
        stm.close();
        con.close();

        return result;
    }

    public static boolean checkUsername2(String username) throws Exception {
        Form form = Form.form();
        form.add("operation", "checkUsername");
        form.add("username", username );

        String result = Request.post(
                url + "end_point_users.php"
        ).bodyForm(form.build()).execute().returnContent().asString();

        System.out.println(result);

        return ! result.contains("\"error\"");
    }


    public static int numberOfUsers() throws Exception {
        int numberOfUsers = 0;

        String sql = "SELECT COUNT(*) FROM users;";

        Connection con = DBConnection.open();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(sql);
        if (rs.next()) {
            numberOfUsers = rs.getInt(1);
        }
        rs.close();
        stm.close();
        con.close();

        System.out.println(numberOfUsers);

        return numberOfUsers;
    }

    public static int numberOfUsers2() throws Exception {
        int numberOfUsers = 0;

        String results = Request.get(
                url + "end_point_users.php?operation=number"
        ).execute().returnContent().asString();

        System.out.println(results);

        numberOfUsers = Integer.parseInt(results);

        return numberOfUsers;
    }

    private static User getQueryResult(ResultSet rs) throws SQLException {
        User u = null;
        if (rs.next()) {
            u = new User(
                    rs.getString("id_user"),
                    Enum.valueOf(UserType.class,rs.getString("user_type")),
                    rs.getString("username"),
                    rs.getString("password")
            );
        }
        return u;
    }
}
