package start;


import model.Comanda;
import presentation.controller.Controller;
import presentation.view.*;

import java.sql.SQLException;
import java.util.logging.Logger;
/**
 * The entry point of the application.
 */
public class Start {
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());
    /**
     * The main method that starts the application.
     *
     * @param args the command line arguments
     * @throws SQLException if a database access error occurs
     */
    public static void main(String[] args) throws SQLException {
        PrincipalGUI principalGUI = new PrincipalGUI();
        ClientGUI clientGUI = new ClientGUI();
        ProdusGUI produsGUI = new ProdusGUI();
        ComandaGUI comandaGUI = new ComandaGUI();
        StergereProdusGUI stergereProdusGUI = new StergereProdusGUI();
        StergereClientGUI stergereClientGUI = new StergereClientGUI();

        AdaugareClientGUI adaugareClientGUI = new AdaugareClientGUI();
        AdaugareProdusGUI adaugareProdusGUI = new AdaugareProdusGUI();

        EditareClientGUI editareClientGUI = new EditareClientGUI();
        EditareProdusGUI editareProdusGUI = new EditareProdusGUI();

        AfisareClientiGUI afisareClientiGUI = new AfisareClientiGUI();
        AfisareProduseGUI afisareProduseGUI = new AfisareProduseGUI();

        Controller controller = new Controller(principalGUI, clientGUI, produsGUI, adaugareClientGUI,adaugareProdusGUI,stergereProdusGUI,stergereClientGUI,editareProdusGUI,editareClientGUI, afisareClientiGUI, afisareProduseGUI, comandaGUI);
        principalGUI.setVisible(true);
    }
}
