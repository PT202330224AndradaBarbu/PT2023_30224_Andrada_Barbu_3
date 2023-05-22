package dao;

import conectare.Conectare;
import model.Cos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Data Access Object (DAO) for accessing and manipulating Cos objects in the database.
 */
public class CosDAO extends AbstractDAO<Cos> {
    /**
     * Constructs a new CosDAO object.
     */
    public CosDAO(){
        super();
    }

    /**
     * Creates the select query for retrieving a Cos object based on the specified field and finalizat value.
     *
     * @param field The field to search for.
     * @return The select query string.
     */
    protected String createSelectQueryCos(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =? AND finalizat =?");
        return sb.toString();
    }

    /**
     * Finds the finalizat Cos object associated with a specific idClient.
     *
     * @param idClient The idClient to search for.
     * @param finalizat The finalizat value to search for.
     * @return The finalizat Cos object associated with the specified idClient and finalizat value.
     */
    public Cos findFinalizatByIDClient(int idClient, int finalizat) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQueryCos("idClient");
        try {
            connection= Conectare.getConnection();
            statement= connection.prepareStatement(query);
            statement.setInt(1,idClient);
            statement.setInt(2,finalizat);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findFinalizatByIDClient " + e.getMessage());
        } finally {
            Conectare.close(resultSet);
            Conectare.close(statement);
            Conectare.close(connection);
        }
        return null;
    }
}