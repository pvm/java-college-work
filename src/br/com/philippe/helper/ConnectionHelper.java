package br.com.philippe.helper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Philippe Moreira on 18/05/17.
 */
public class ConnectionHelper {

    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {
            try {
                // Get the properties from file
                Properties p = getProperties();

                // ?
                Class.forName(p.getProperty("driver"));

                //
                connection = DriverManager.getConnection(
                        p.getProperty("url"),
                        p.getProperty("user"),
                        p.getProperty("password")
                );

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    private static Properties getProperties() throws IOException {

        // Create the properties
        Properties prop = new Properties();

        // Get file contents
        InputStream inputStream = ConnectionHelper.class.getClassLoader().getResourceAsStream("/db.properties");

        // Load to properties
        prop.load(inputStream);

        return prop;
    }
}
