package presentation.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * Graphical user interface for ComandaGUI.
 */
public class ComandaGUI extends JFrame {

    private JTable tableProdus, tableClient;

    private JLabel produs,cantitate,total, email;

    private JTextField t1,t2,t3,t4;

    private JPanel p,p1,p2,p3,p4,p5,p6,p7,p8;

    private JButton buton1, buton2, buton3;

    /**
     * Constructor for ComandaGUI.
     * Initializes the GUI components and sets up the layout.
     */
    public ComandaGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,300);
        setLayout(new FlowLayout());
        tableProdus=new JTable(new String[][]{},new String[]{});
        tableProdus.setPreferredScrollableViewportSize(new Dimension(1500,1500));
        tableProdus.setFillsViewportHeight(true);
        JScrollPane scrollPaneProdus=new JScrollPane(tableProdus);
        tableClient=new JTable(new String[][]{},new String[]{});
        tableClient.setPreferredScrollableViewportSize(new Dimension(1500,1500));
        tableClient.setFillsViewportHeight(true);
        JScrollPane scrollPaneClient=new JScrollPane(tableClient);
        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();
        JPanel p9 = new JPanel();
        p8.add(scrollPaneProdus);
        p9.add(scrollPaneClient);
        email=new JLabel("Email client");
        t4=new JTextField(30);
        t4.setPreferredSize(new Dimension(150,30));
        p4.add(email);
        p4.add(t4);
        produs=new JLabel("Produs");
        t1=new JTextField(30);
        t1.setPreferredSize(new Dimension(150,30));
        p1.add(produs);
        p1.add(t1);
        cantitate=new JLabel("Cantitate");
        t2=new JTextField(30);
        t2.setPreferredSize(new Dimension(150,30));
        p2.add(cantitate);
        p2.add(t2);
        total=new JLabel("Total");
        t3=new JTextField(30);
        t3.setPreferredSize(new Dimension(150,30));
        t3.setEnabled(false);
        p3.add(total);
        p3.add(t3);
        buton1=new JButton("Comanda noua");
        p5.add(buton1);
        buton2=new JButton("Adaugare produs");
        p6.add(buton2);
        buton3=new JButton("Finalizare comanda");
        p7.add(buton3);
        p.add(p9);
        p.add(p4);
        p.add(p5);
        p.add(p8);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p6);
        p.add(p7);
        p.setLayout(new GridLayout(9,1));
        this.setContentPane(p);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Updates the product table with the provided data.
     *
     * @param randuri  the data rows for the table
     * @param coloane  the column names for the table
     */
    public void actualizareTabelProdus(String[][] randuri, String[] coloane) {
        tableProdus.setModel(new DefaultTableModel(randuri, coloane));
    }
    /**
     * Updates the client table with the provided data.
     *
     * @param randuri  the data rows for the table
     * @param coloane  the column names for the table
     */
    public void actualizareTabelClient(String[][] randuri, String[] coloane) {
        tableClient.setModel(new DefaultTableModel(randuri, coloane));
    }
    /**
     * Adds an ActionListener for the "Comanda noua" button.
     *
     * @param acn  the ActionListener to be added
     */
    public void addComandaNouaListener(ActionListener acn) {
        buton1.addActionListener(acn);
    }
    /**
     * Adds an ActionListener for the "Adaugare produs" button.
     *
     * @param ap  the ActionListener to be added
     */
    public void addAdaugareProdusListener(ActionListener ap) {
        buton2.addActionListener(ap);
    }
    /**
     * Adds an ActionListener for the "Finalizare comanda" button.
     *
     * @param fc  the ActionListener to be added
     */
    public void addFinalizareComandaListener(ActionListener fc) {
        buton3.addActionListener(fc);
    }
    /**
     * Returns the email entered in the email field.
     *
     * @return the email entered
     */
    public String getEmail() {
        return t4.getText();
    }
    /**
     * Enables or disables the email text field.
     *
     * @param enabled  true to enable the field, false to disable
     */
    public void setEmailTextEnabled(boolean enabled) {
        t4.setEnabled(enabled);
    }
    /**
     * Resets the email field.
     */
    public void resetEmail() {
        t4.setText("");
    }
    /**
     * Resets the product field.
     */
    public void resetProdus() {
        t1.setText("");
    }
    /**
     * Resets the quantity field.
     */
    public void resetCantitate() {
        t2.setText("");
    }
    /**
     * Returns the product entered the product field.
     *
     * @return the product entered
     */

    public String getProdus() {
        return t1.getText();
    }

    /**
     * Returns the quantity entered the quantity field.
     *
     * @return the quantity entered
     */
    public String getCantitate() {
        return t2.getText();
    }
    /**
     * Returns the total value displayed in the total field.
     *
     * @return the total value
     */

    public String getTotal() {
        return t3.getText();
    }

    /**
     * Sets the total value to be displayed in the total field.
     *
     * @param total  the total value to be set
     */
    public void setTotal(int total) {
        t3.setText(String.valueOf(total));
    }

    /**
     * Displays an error message dialog with the provided message.
     *
     * @param s  the error message to be displayed
     */
    public void aruncaEroare(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
}
