package model;
/**
 * Represents a command.
 */
public class Comanda {

    private int id;
    private int idCos;

    private int idProdus;
    private int pretBuc;
    private int cantitate;
    /**
     * Constructs a Comanda object with the specified ID, cart ID, product ID, unit price, and quantity.
     *
     * @param id         The ID of the command.
     * @param idCos      The ID of the cart associated with the command.
     * @param idProdus   The ID of the product associated with the command.
     * @param pretBucata The unit price of the product.
     * @param cantitate  The quantity of the product.
     */

    public Comanda(int id, int idCos, int idProdus, int pretBucata, int cantitate) {
        this.id = id;
        this.idCos = idCos;
        this.idProdus = idProdus;
        this.pretBuc = pretBucata;
        this.cantitate = cantitate;
    }
    /**
     * Constructs a Comanda object with the specified cart ID, product ID, unit price, and quantity.
     *
     * @param idCos      The ID of the cart associated with the command.
     * @param idProdus   The ID of the product associated with the command.
     * @param pretBucata The unit price of the product.
     * @param cantitate  The quantity of the product.
     */
    public Comanda(int idCos, int idProdus, int pretBucata, int cantitate) {
        this.idCos = idCos;
        this.idProdus = idProdus;
        this.pretBuc = pretBucata;
        this.cantitate = cantitate;
    }
    /**
     * Returns the ID of the command.
     *
     * @return The ID of the command.
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the ID of the command.
     *
     * @param id The ID of the command.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Returns the ID of the cart associated with the command.
     *
     * @return The ID of the cart.
     */
    public int getIdCos() {
        return idCos;
    }

    /**
     * Sets the ID of the cart associated with the command.
     *
     * @param idCos The ID of the cart.
     */
    public void setIdCos(int idCos) {
        this.idCos = idCos;
    }

    /**
     * Returns the quantity of the product.
     *
     * @return The quantity of the product.
     */
    public int getCantitate() {
        return cantitate;
    }

    /**
     * Sets the quantity of the product.
     *
     * @param cantitate The quantity of the product.
     */
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    /**
     * Returns the ID of the product associated with the command.
     *
     * @return The ID of the product.
     */
    public int getIdProdus() {
        return idProdus;
    }

    /**
     * Sets the ID of the product associated with the command.
     *
     * @param idProdus The ID of the product.
     */
    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    /**
     * Returns the unit price of the product.
     *
     * @return The unit price of the product.
     */
    public int getPretBuc() {
        return pretBuc;
    }

    /**
     * Sets the unit price of the product.
     *
     * @param pretBuc The unit price of the product.
     */
    public void setPretBuc(int pretBuc) {
        this.pretBuc = pretBuc;
    }
}
