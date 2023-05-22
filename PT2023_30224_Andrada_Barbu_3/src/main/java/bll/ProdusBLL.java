package bll;

import bll.validator.*;
import dao.ProdusDAO;
import model.Client;
import model.Produs;
import java.util.ArrayList;
import java.util.List;
/**
 * Business logic for handling products.
 */
public class ProdusBLL {

    private List<Validator<Produs>> validatori;
    private ProdusDAO produsDAO;
    /**
     * Constructor for ProdusBLL.
     * Initializes the list of validators and the product DAO.
     */
    public ProdusBLL(){
        validatori=new ArrayList<Validator<Produs>>();
        validatori.add(new ValidareDenumireProdus());
        produsDAO=new ProdusDAO();
    }

    /**
     * Inserts a new product into the database.
     *
     * @param produs the product to be inserted
     */
    public void inserareProdus(Produs produs) {
        for(Validator<Produs> v:validatori) {
            v.validate(produs);
        }
        if (produsDAO.insert(produs) == null) {
            System.out.println("insert failed!");
        }
    }
    /**
     * Retrieves a product based on its name.
     *
     * @param denumire the name of the product
     * @return the product with the specified name
     */
    public Produs cautareProdusDupaDenumire(String denumire) {
        Produs p = produsDAO.findByDenumire(denumire);
        if (p == null) {
            throw new IllegalArgumentException("Denumire produs invalida!");
        }
        return p;
    }
    /**
     * Retrieves all products from the database.
     *
     * @return a list of all products
     */

    public List<Produs> cautareProdus() {
        return produsDAO.findAll();
    }
    /**
     * Updates the information of a product.
     *
     * @param produs the product to be updated
     */
    public void editareProdus(Produs produs) {
        for(Validator<Produs> v:validatori) {
            v.validate(produs);
        }
        produsDAO.update(produs);
    }
    /**
     * Deletes a product based on its name.
     *
     * @param denumire the name of the product to be deleted
     */
    public void stergereProdus(String denumire) {
        produsDAO.deleteByDenumire(denumire);
    }
}
