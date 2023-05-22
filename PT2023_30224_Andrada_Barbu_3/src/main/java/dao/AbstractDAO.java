package dao;

import conectare.Conectare;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A generic abstract Data Access Object (DAO) class.
 *
 * @param <T> The type of the object handled by the DAO.
 */
public class AbstractDAO<T>{
    protected final Logger LOGGER= Logger.getLogger(getClass().getName());
    protected final Class<T> type;

    /**
     * Constructs a new AbstractDAO object.
     */
    public AbstractDAO() {
        this.type=(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    /**
     * Creates a SELECT query for retrieving a record based on a specific field.
     *
     * @param field The field to filter the record by.
     * @return The SELECT query as a string.
     */
    protected String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }
    /**
     * Creates a SELECT query for retrieving all records.
     *
     * @return The SELECT query as a string.
     */
    protected String createSelectQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }
    /**
     * Creates an INSERT query for inserting a new record.
     *
     * @param fields The fields of the record.
     * @return The INSERT query as a string.
     */
    protected String createInsertQuery(Field[] fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append("(");
        for(int i=1; i < fields.length-1; i++) {
            sb.append(fields[i].getName());
            sb.append(",");
        }
        sb.append(fields[fields.length-1].getName());
        sb.append(")");
        sb.append(" VALUES (");
        for (int i=1; i< fields.length-1; i++) {
            sb.append("?,");
        }
        sb.append("?)");
        return sb.toString();
    }
    /**
     * Creates a DELETE query for deleting a record based on a specific field.
     *
     * @param field The field to filter the record by.
     * @return The DELETE query as a string.
     */
    protected String createDeleteQuery(String field) {
        StringBuilder sb= new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }
    /**
     * Creates an UPDATE query for updating a record.
     *
     * @param fields The fields of the record.
     * @return The UPDATE query as a string.
     */
    protected String createUpdateQuery(Field[] fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        for(int i=1; i < fields.length-1; i++) {
            sb.append(fields[i].getName());
            sb.append("=?,");
        }
        sb.append(fields[fields.length-1].getName()+"=? WHERE "+fields[0].getName()+"=?");
        return sb.toString();
    }

    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createDeleteQuery("id");
        try {
            connection= Conectare.getConnection();
            statement= connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteById " + e.getMessage());
        } finally {
            Conectare.close(resultSet);
            Conectare.close(statement);
            Conectare.close(connection);
        }
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = Conectare.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            Conectare.close(resultSet);
            Conectare.close(statement);
            Conectare.close(connection);
        }
        return null;
    }

    protected List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery();
        try {
            connection = Conectare.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            Conectare.close(resultSet);
            Conectare.close(statement);
            Conectare.close(connection);
        }
        return new ArrayList<T>();
    }

    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Field[] fields = t.getClass().getDeclaredFields();
        String query = createInsertQuery(fields);
        try {
            connection = Conectare.getConnection();
            statement = connection.prepareStatement(query);
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                Object attributeValue = fields[i].get(t);
                if (attributeValue instanceof Integer) {
                    statement.setInt(i, (Integer)attributeValue);
                } else if (attributeValue instanceof String) {
                    statement.setString(i, (String) attributeValue);
                }
            }
            statement.executeUpdate();
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.SEVERE, type.getName() + "DAO:update " + e.getMessage());
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            Conectare.close(resultSet);
            Conectare.close(statement);
            Conectare.close(connection);
        }
        return t;
    }

    public T update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Field[] fields = t.getClass().getDeclaredFields();
        String query = createUpdateQuery(fields);
        try{
            connection = Conectare.getConnection();
            statement = connection.prepareStatement(query);
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                Object attributeValue = fields[i].get(t);
                if (attributeValue instanceof Integer) {
                    statement.setInt(i, (Integer)attributeValue);
                } else if (attributeValue instanceof String) {
                    statement.setString(i, (String) attributeValue);
                }
            }
            fields[0].setAccessible(true);
            Object valoareId = fields[0].get(t);
            statement.setInt(fields.length, (Integer)valoareId);
            statement.executeUpdate();
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.SEVERE, type.getName() + "DAO:update " + e.getMessage());
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            Conectare.close(resultSet);
            Conectare.close(statement);
            Conectare.close(connection);
        }
        return t;
    }
}
