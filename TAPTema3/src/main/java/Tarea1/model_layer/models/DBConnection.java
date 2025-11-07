
package Tarea1.model_layer.models;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {

    public DBConnection() {
    }

    public static Connection open() throws Exception{
        Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tema3_tarea1",
                "root",
                null
        );
        return connection;
    }

    public static void close(Connection connection) throws Exception {
        connection.close();

    }
    
}
