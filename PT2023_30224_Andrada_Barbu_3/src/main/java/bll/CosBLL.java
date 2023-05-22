package bll;

import dao.ClientDAO;
import dao.CosDAO;
import model.Cos;
/**
 * Business logic for handling shopping carts.
 */
public class CosBLL {

    private CosDAO cosDAO;
    /**
     * Constructor for CosBLL.
     * Initializes the shopping cart DAO.
     */
    public CosBLL() {
        cosDAO = new CosDAO();
    }
    /**
     * Inserts a new shopping cart into the database.
     *
     * @param cos the shopping cart to be inserted
     */
    public void inserareCos(Cos cos) {
        cosDAO.insert(cos);
    }
    /**
     * Retrieves a completed shopping cart for a given client.
     *
     * @param idClient  the ID of the client
     * @param finalizat the flag indicating if the cart is finalized or not
     * @return the completed shopping cart
     */
    public Cos cautareCosFinalizatDupaIdClient(int idClient, int finalizat) {
        return cosDAO.findFinalizatByIDClient(idClient, finalizat);
    }
    /**
     * Updates the information of a shopping cart.
     *
     * @param cos the shopping cart to be updated
     */
    public void editareCos(Cos cos) {
        cosDAO.update(cos);
    }
}
