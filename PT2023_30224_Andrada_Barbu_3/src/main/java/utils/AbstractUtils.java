package utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
/**
 * Utility class for handling generic operations on objects of type T.
 *
 * @param <T> the type of objects handled by this utility class
 */
public class AbstractUtils<T> {

    protected final Class<T> type;

    /**
     * Constructs an instance of AbstractUtils.
     */
    public AbstractUtils() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    /**
     * Retrieves the values of the specified objects and converts them into a two-dimensional array.
     *
     * @param obiecte the list of objects to retrieve values from
     * @return a two-dimensional array containing the values of the objects
     */
    public String[][] getValues(List<T> obiecte) {
        Field[] fields = type.getDeclaredFields();
        String[][] data = new String[obiecte.size()][fields.length];
        try {
            int index = 0;
            for (T obiect : obiecte) {
                String[] values = new String[fields.length];
                for (int i = 0; i< fields.length; i++) {
                    String fieldName = fields[i].getName();
                    fields[i].setAccessible(true);
                    Object attributeValue = fields[i].get(obiect);
                    if (attributeValue instanceof String) {
                        values[i] = (String) attributeValue;
                    } else if (attributeValue instanceof Integer) {
                        values[i] = String.valueOf(attributeValue);
                    }

                }
                data[index] = values;
                index++;
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    /**
     * Retrieves the header values for the object's fields.
     *
     * @return an array containing the names of the object's fields
     */
    public String[] getHeader() {
        Field[] fields = type.getDeclaredFields();
        String[] header = new String[fields.length];
        int i = 0;
        for (Field f : fields) {
            String fieldName = f.getName();
            header[i] = fieldName;
            i++;
        }
        return header;
    }
}
