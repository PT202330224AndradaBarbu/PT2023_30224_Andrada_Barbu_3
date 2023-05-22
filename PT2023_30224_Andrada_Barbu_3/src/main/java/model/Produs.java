package model;

/**
 * Represents a product.
 */
public class Produs {

    private int id;
    private String denumire;
    private int pretBuc;
    private int cantitate;

    /**
     * Constructs an empty product.
     */
    public Produs() {
    }

    /**
     * Constructs a product with the specified ID, name, unit price, and quantity.
     *
     * @param id         The ID of the product.
     * @param denumire   The name of the product.
     * @param pretBucata The unit price of the product.
     * @param cantitate  The quantity of the product.
     */
    public Produs(int id, String denumire, int pretBucata, int cantitate) {
        this.id = id;
        this.denumire = denumire;
        this.pretBuc = pretBucata;
        this.cantitate = cantitate;
    }

    /**
     * Constructs a product with the specified name, unit price, and quantity.
     *
     * @param denumire   The name of the product.
     * @param pretBucata The unit price of the product.
     * @param cantitate  The quantity of the product.
     */
    public Produs(String denumire, int pretBucata, int cantitate) {
        this.denumire = denumire;
        this.pretBuc = pretBucata;
        this.cantitate = cantitate;
    }

    /**
     * Returns the ID of the product.
     *
     * @return The ID of the product.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     *
     * @param id The ID of the product.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the product.
     *
     * @return The name of the product.
     */
    public String getDenumire() {
        return denumire;
    }

    /**
     * Sets the name of the product.
     *
     * @param denumire The name of the product.
     */
    public void setDenumire(String denumire) {
        this.denumire = denumire;
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
     * Returns a string representation of the product.
     *
     * @return A string representation of the product.
     */
    public String toString() {
        return "Produs cu id=" + id + " denumire=" + denumire + " pret/buc=" + pretBuc + " cantitate=" + cantitate;
    }
}
