package dao;

import conectare.Conectare;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

/**
 * Data Access Object (DAO) for accessing and manipulating Client objects in the database.
 */
public class ClientDAO extends AbstractDAO<Client> {
    /**
     * Constructs a new ClientDAO object.
     */
    public ClientDAO() {
        super();
    }

    /**
     * Deletes a client from the database based on the specified email.
     *
     * @param email The email of the client to be deleted.
     */
    public void deleteByEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createDeleteQuery("email");
        try {
            connection = Conectare.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteByEmail " + e.getMessage());
        } finally {
            Conectare.close(resultSet);
            Conectare.close(statement);
            Conectare.close(connection);
        }
    }

    /**
     * Finds a client in the database based on the specified email.
     *
     * @param email The email of the client to find.
     * @return The found client, or null if no client is found.
     */
    public Client findByEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("email");
        try {
            connection = Conectare.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            List<Client> clients = createObjects(resultSet);
            if (clients != null && clients.size() > 0) {
                return clients.get(0);
            }
            return null;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findByEmail " + e.getMessage());
        } finally {
            Conectare.close(resultSet);
            Conectare.close(statement);
            Conectare.close(connection);
        }
        return null;
    }
}