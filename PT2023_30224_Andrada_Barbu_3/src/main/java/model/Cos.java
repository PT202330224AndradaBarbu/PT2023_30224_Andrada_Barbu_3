package model;
/**
 * Represents a shopping cart.
 */
public class Cos {
    private int id;
    private int idClient;
    private int total;
    private int finalizat;

    /**
     * Constructs an empty shopping cart.
     */
    public Cos() {
    }

    /**
     * Constructs a shopping cart for the specified client.
     *
     * @param idClient The ID of the client.
     */
    public Cos(int idClient) {
        this.id = 0;
        this.idClient = idClient;
        this.total = 0;
        this.finalizat = 0;
    }

    /**
     * Constructs a shopping cart with the specified ID, client ID, and finalization status.
     *
     * @param id       The ID of the shopping cart.
     * @param idClient The ID of the client.
     * @param finalizat The finalization status of the shopping cart.
     */
    public Cos(int id, int idClient, int finalizat) {
        this.id = id;
        this.idClient = idClient;
        this.total = 0;
        this.finalizat = finalizat;
    }

    /**
     * Returns the ID of the shopping cart.
     *
     * @return The ID of the shopping cart.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the shopping cart.
     *
     * @param id The ID of the shopping cart.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the ID of the client associated with the shopping cart.
     *
     * @return The ID of the client.
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Sets the ID of the client associated with the shopping cart.
     *
     * @param idClient The ID of the client.
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Returns the total amount of the shopping cart.
     *
     * @return The total amount of the shopping cart.
     */
    public int getTotal() {
        return total;
    }

    /**
     * Sets the total amount of the shopping cart.
     *
     * @param total The total amount of the shopping cart.
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * Returns the finalization status of the shopping cart.
     *
     * @return The finalization status of the shopping cart.
     */
    public int getFinalizat() {
        return finalizat;
    }

    /**
     * Sets the finalization status of the shopping cart.
     *
     * @param finalizat The finalization status of the shopping cart.
     */
    public void setFinalizat(int finalizat) {
        this.finalizat = finalizat;
    }
}