package conectare;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 * Utility class for connecting to a MySQL database.
 */
public class Conectare {

    private static final Logger LOGGER = Logger.getLogger(Conectare.class.getName());
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/ordersmanagement";
    private static final String USER = "root";
    private static final String PASS = "Andra2002*";

    private static Conectare singleInstance = new Conectare();

    private Conectare() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Creates a connection to the MySQL database.
     *
     * @return the connection object
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * Retrieves the connection to the MySQL database.
     *
     * @return the connection object
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }
    /**
     * Closes the given database connection.
     *
     * @param connection the connection object to close
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }
    /**
     * Closes the given prepared statement.
     *
     * @param statement the prepared statement to close
     */

    public static void close(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }
    /**
     * Closes the given database connection.
     *
     * @param resultSet the connection object to close
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }

}
