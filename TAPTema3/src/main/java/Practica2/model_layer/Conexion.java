package Practica2.model_layer;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Link
 */
public class Conexion {
    private String host;
    private int port;
    private String dbName;
    private String dbUser;
    private String dbPassword;

    public Conexion() {
        host = "localhost";
        port = 3306;
        dbName = "practica2_agodic25";
        dbUser = "root";
        dbPassword = null;
    }

    public Conexion(String host, int port, String dbName, String dbUser, String dbPassword) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }
    
    public Connection open() throws Exception {
        Connection connection = DriverManager.getConnection(
            "jdbc:mysql://"+host+":"+port+"/" + dbName,
            dbUser, dbPassword
        );
        return connection;
    }
    
    public void close(Connection connection) throws Exception {
        connection.close();
    }
}
