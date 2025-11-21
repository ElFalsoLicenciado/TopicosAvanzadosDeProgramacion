package proyecto.services;

import proyecto.enums.UserType;
import proyecto.models.User;
import proyecto.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserServicesSQL {


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

    public static User getUser(String id_user) throws Exception {
        User user = null;

        String sql = "SELECT * FROM users WHERE id_user = '" + id_user + "';";

        Connection con = DBConnection.open();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(sql);
        if (rs.next()) {
            user = new User(
                    rs.getString("id_user"),
                    Enum.valueOf(UserType.class,rs.getString("user_type")),
                    rs.getString("username"),
                    rs.getString("password")
            );
        }

        rs.close();
        stm.close();
        con.close();

        return user;
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
        if (rs.next()) {
            user = new User(
                    rs.getString("id_user"),
                    Enum.valueOf(UserType.class,rs.getString("user_type")),
                    rs.getString("username"),
                    rs.getString("password")
            );
        }

        rs.close();
        ps.close();
        con.close();

        return user;
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
}
