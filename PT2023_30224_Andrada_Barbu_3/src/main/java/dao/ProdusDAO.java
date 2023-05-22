package dao;

import conectare.Conectare;
import model.Produs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

/**
 * Data Access Object (DAO) for accessing and manipulating Produs objects in the database.
 */
public class ProdusDAO extends AbstractDAO<Produs> {
    /**
     * Constructs a new ProdusDAO object.
     */
    public ProdusDAO() {
        super();
    }

    /**
     * Deletes a Produs object from the database based on the specified denumire.
     *
     * @param denumire The denumire of the Produs object to delete.
     */
    public void deleteByDenumire(String denumire) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createDeleteQuery("denumire");
        try {
            connection= Conectare.getConnection();
            statement= connection.prepareStatement(query);
            statement.setString(1,denumire);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteByDenumire " + e.getMessage());
        } finally {
            Conectare.close(resultSet);
            Conectare.close(statement);
            Conectare.close(connection);
        }
    }

    /**
     * Finds a Produs object in the database based on the specified denumire.
     *
     * @param denumire The denumire to search for.
     * @return The Produs object associated with the specified denumire, or null if not found.
     */
    public Produs findByDenumire(String denumire) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("denumire");
        try {
            connection = Conectare.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, denumire);
            resultSet = statement.executeQuery();
            List<Produs> produse = createObjects(resultSet);
            if (produse != null && produse.size() > 0) {
                return produse.get(0);
            }
            return null;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findByDenumire " + e.getMessage());
        } finally {
            Conectare.close(resultSet);
            Conectare.close(statement);
            Conectare.close(connection);
        }
        return null;
    }
}