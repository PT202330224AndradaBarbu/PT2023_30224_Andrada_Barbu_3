package presentation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * Graphical user interface for ProdusGUI.
 */
public class ProdusGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton b1,b2,b3,b4,butonBack;
    private JPanel panel,panel1,panel2,panel3,panel4,panel5;
    /**
     * Constructor for ProdusGUI.
     * Initializes the GUI components and sets up the layout.
     */

    public ProdusGUI()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280,720);
        panel=new JPanel();
        b1=new JButton("Adaugare produs");
        b2=new JButton("Editare produs");
        b3=new JButton("Sterge produs");
        b4=new JButton("Vizualizare produse");
        butonBack=new JButton("Inapoi");
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        panel5=new JPanel();

        panel1.add(b1);
        panel2.add(b2);
        panel3.add(b3);
        panel4.add(b4);
        panel5.add(butonBack);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);

        panel.setLayout(new GridLayout(9,1));
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    /**
     * Adds an ActionListener for the "Adaugare produs" button.
     *
     * @param ac  the ActionListener to be added
     */
    public void addAdaugareProdusListener(ActionListener ac) {
        b1.addActionListener(ac);
    }

    /**
     * Adds an ActionListener for the "Vizualizare produse" button.
     *
     * @param vc  the ActionListener to be added
     */
    public void addVizualizareProduseListener(ActionListener vc) {
        b4.addActionListener(vc);
    }

    /**
     * Adds an ActionListener for the "Sterge produs" button.
     *
     * @param sc  the ActionListener to be added
     */
    public void addStergereProdusListener(ActionListener sc) {
        b3.addActionListener(sc);
    }
    /**
     * Adds an ActionListener for the "Editare produs" button.
     *
     * @param ec  the ActionListener to be added
     */
    public void addEditareProdusListener(ActionListener ec) {
        b2.addActionListener(ec);
    }
    /**
     * Adds an ActionListener for the "Inapoi" button.
     *
     * @param ec  the ActionListener to be added
     */
    public void addBackListener(ActionListener ec) {
        butonBack.addActionListener(ec);
    }
}
