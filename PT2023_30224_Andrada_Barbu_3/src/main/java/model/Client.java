package model;

/**
 * The client class reprezents a client entity with properties such name,id,address,phone number and email
 */
public class Client {

    private int id;
    private String nume;
    private String adresa;
    private String telefon;
    private String email;
    /**
     * Constructs an empty Client object.
     */
    public Client(){

    }
    /**
     * Constructs a Client object with the specified id, name, phone number, email, and address.
     *
     * @param id     The id of the client.
     * @param nume   The name of the client.
     * @param nrTel  The phone number of the client.
     * @param email  The email address of the client.
     * @param adresa The address of the client.
     */
    public Client(int id,String nume,String nrTel,String email,String adresa){
        this.id=id;
        this.nume=nume;
        this.email=email;
        this.adresa=adresa;
        this.telefon = nrTel;
    }

    /**
     * Constructs a Client object with the specified name, phone number, email, and address.
     *
     * @param nume   The name of the client.
     * @param nrTel  The phone number of the client.
     * @param email  The email address of the client.
     * @param adresa The address of the client.
     */
    public Client(String nume,String nrTel,String email,String adresa){
        this.nume=nume;
        this.telefon = nrTel;
        this.email=email;
        this.adresa=adresa;
    }


    /**
     * Returns the id of the client.
     *
     * @return The id of the client.
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the id of the client.
     *
     * @param id The id of the client.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Returns the name of the client.
     *
     * @return The name of the client.
     */
    public String getNume() {
        return nume;
    }
    /**
     * Sets the name of the client.
     *
     * @param nume The name of the client.
     */
    public void setNume(String nume) {
        this.nume = nume;
    }
    /**
     * Returns the phone number of the client.
     *
     * @return The phone number of the client.
     */
    public String getTelefon() {
        return telefon;
    }
    /**
     * Sets the phone number of the client.
     *
     * @param telefon The phone number of the client.
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    /**
     * Returns the email address of the client.
     *
     * @return The email address of the client.
     */

    public String getEmail() {
        return email;
    }
    /**
     * Sets the email address of the client.
     *
     * @param email The email address of the client.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Returns the address of the client.
     *
     * @return The address of the client.
     */
    public String getAdresa() {
        return adresa;
    }
    /**
     * Sets the address of the client.
     *
     * @param adresa The address of the client.
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    /**
     * Returns a string representation of the Client object.
     *
     * @return A string representation of the Client object.
     */
    public String toString()
    {
        return "Clientul cu id="+id+" nume="+nume + " email="+email+" nr tel= "+telefon;
    }

}
