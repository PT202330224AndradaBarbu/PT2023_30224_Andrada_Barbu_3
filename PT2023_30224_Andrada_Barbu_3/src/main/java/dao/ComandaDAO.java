package dao;

import model.Comanda;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for accessing and manipulating Comanda objects in the database.
 */
public class ComandaDAO extends AbstractDAO<Comanda> {
    /**
     * Constructs a new ComandaDAO object.
     */
    public ComandaDAO() {
        super();
    }

    /**
     * Finds all the Comanda objects associated with a specific idCos.
     *
     * @param idCos The idCos to search for.
     * @return A list of Comanda objects associated with the specified idCos.
     */
    public List<Comanda> findByIdCos(int idCos) {
        List<Comanda> comenzi = new ArrayList<>();
        List<Comanda> toateComenzile = findAll();
        for (Comanda comanda : toateComenzile) {
            if (comanda.getIdCos() == idCos) {
                comenzi.add(comanda);
            }
        }
        return comenzi;
    }
}