package bll;

import bll.validator.*;
import dao.ClientDAO;
import model.Client;
import model.Produs;

import java.util.ArrayList;
import java.util.List;

/**
 * Business logic for handling clients.
 */
public class ClientBLL {

    private List<Validator<Client>> validatori;
    private ClientDAO clientDAO;
    /**
     * Constructor for ClientBLL.
     * Initializes the list of validators and the client DAO.
     */
    public ClientBLL(){
        validatori=new ArrayList<Validator<Client>>();
        validatori.add(new ValidareEmail());
        validatori.add(new ValidareNume());
        validatori.add(new ValidareTelefon());
        clientDAO=new ClientDAO();
    }
    /**
     * Retrieves a list of all clients.
     *
     * @return the list of clients
     */
    public List<Client> cautareClienti() {
        return clientDAO.findAll();
    }
    /**
     * Inserts a new client into the database.
     *
     * @param client the client to be inserted
     */
    public void inserareClient(Client client) {
        for(Validator<Client> v:validatori) {
            v.validate(client);
        }
       if (clientDAO.insert(client) == null) {
           System.out.println("insert failed!");
       }
    }

    /**
     * Searches for a client with the given email.
     *
     * @param email the email to search for
     * @return the found client
     * @throws IllegalArgumentException if no client is found with the given email
     */
    public Client cautareClientDupaEmail(String email){
        Client c = clientDAO.findByEmail(email);
        if (c == null) {
            throw new IllegalArgumentException("Email-ul nu este valid!");
        }
        return c;
    }
    /**
     * Updates an existing client in the database.
     *
     * @param client the client to be updated
     */
    public void editareClient(Client client) {
        for(Validator<Client> v:validatori) {
            v.validate(client);
        }
        clientDAO.update(client);
    }

    /**
     * Deletes a client with the given email from the database.
     *
     * @param email the email of the client to be deleted
     */

    public void stergereClient(String email) {
        clientDAO.deleteByEmail(email);
    }
}