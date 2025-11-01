
package Practica1.model_layer;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {

    public DBConnection() {
    }


    /** <h2> Cachar excepciones para evitar conflictos ocn las capas.</h2>
     * <p> Si ocurre un error en una de las capas:</p>
     * <ul>
     *     <li>Visual</li>
     *     <li>Controller</li>
     *     <li>Model</li>
     * </ul>
     * @throws Exception
     */

    public static Connection open() throws Exception{
        Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/practica1_agodic25",
                "root",
                null
        );
        return connection;
    }

    public static void close(Connection connection) throws Exception {
        connection.close();

    }
    
}
