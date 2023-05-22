package bll;

import dao.ComandaDAO;
import model.Comanda;

import java.util.List;

/**
 * Business logic for handling orders.
 */
public class ComandaBLL {
    /**
     * Constructor for ComandaBLL.
     * Initializes the order DAO.
     */
    private ComandaDAO comandaDAO;
    public ComandaBLL() {
        comandaDAO = new ComandaDAO();
    }
    /**
     * Inserts a new order into the database.
     *
     * @param comanda the order to be inserted
     */
    public void inserareComanda(Comanda comanda) {
        comandaDAO.insert(comanda);
    }
    /**
     * Retrieves a list of orders for a given shopping cart.
     *
     * @param idCos the ID of the shopping cart
     * @return the list of orders
     */

    public List<Comanda> cautareDupaCos(int idCos) {
        return comandaDAO.findByIdCos(idCos);
    }
}
