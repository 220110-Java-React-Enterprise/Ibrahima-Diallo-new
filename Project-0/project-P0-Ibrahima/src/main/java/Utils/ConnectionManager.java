package Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

    // class
public class ConnectionManager {
        // create the private connection here
    private static Connection connection;

        // private constructor with no arg
    private ConnectionManager() {
    }

        // getConnection() that invoke the connect() method
    public static Connection getConnection() {

        if(connection == null) {

            try {
                connection = connect();  // establish the connection

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

    private static Connection connect() {
        /*
                  jdbc:mariadb://<hostname>:<port>/<databaseName>?user=<username>&password=<password>
            This is the string we need to use to connect to our database. We will build this
            string with each of the variables filled out and qualified.
         */

    try {
        Properties props = new Properties();

        FileReader fr = new FileReader("src/main/resources/jdbc.properties");
        props.load(fr);

        String connectionString = "jdbc:mariadb://" + props.getProperty("hostname") + ":" +
                props.getProperty("port") + "/" +
                props.getProperty("dbname") + "?user=" +
                props.getProperty("username") + "&password=" +
                props.getProperty("password");

        connection = DriverManager.getConnection(connectionString);

       // System.out.println(connectionString); // Shows if connection works otherwise gives SQL Exception

        } catch (Exception e) {
                e.printStackTrace();
        }

        return connection;
    }
}