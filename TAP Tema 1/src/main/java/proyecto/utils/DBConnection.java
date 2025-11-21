package proyecto.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static String host = "localhost";
    private static int port = 3306;
    private static String dbName = "proyecto_t3";
    private static String dbUser = "root";
    private static String dbPass = null;


    public static Connection open() throws Exception {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://"+host+":"+port+"/" + dbName,
                dbUser, dbPass
        );
        return connection;
    }

    public void close(Connection connection) throws Exception {
        connection.close();
    }
}
