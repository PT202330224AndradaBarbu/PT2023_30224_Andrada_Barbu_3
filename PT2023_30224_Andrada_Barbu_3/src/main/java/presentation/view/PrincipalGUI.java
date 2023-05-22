package presentation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * Graphical user interface for PrincipalGUI.
 */
public class PrincipalGUI extends JFrame {

    private JButton b1,b2,b3;
    private JPanel p,p1,p2,p3;

    /**
     * Constructor for PrincipalGUI.
     * Initializes the GUI components and sets up the layout.
     */
    public PrincipalGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        b1=new JButton("Clienti");
        b2=new JButton("Produse");
        b3=new JButton("Comanda");
        p=new JPanel();
        p1 = new JPanel();
        p1.add(b1);
        p2 = new JPanel();
        p2.add(b2);
        p3 = new JPanel();
        p3.add(b3);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.setLayout(new GridLayout(3,1));
        this.setContentPane(p);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Adds an ActionListener for the "Clienti" button.
     *
     * @param clientiListener  the ActionListener to be added
     */
    public void addClientiListener(ActionListener clientiListener) {
        b1.addActionListener(clientiListener);
    }
    /**
     * Adds an ActionListener for the "Produse" button.
     *
     * @param produseListener  the ActionListener to be added
     */
    public void addCProduseListener(ActionListener produseListener) {
        b2.addActionListener(produseListener);
    }
    /**
     * Adds an ActionListener for the "Comanda" button.
     *
     * @param comandaListener  the ActionListener to be added
     */
    public void addComandaListener(ActionListener comandaListener) {
        b3.addActionListener(comandaListener);
    }
}
