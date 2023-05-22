package presentation.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Graphical user interface for adding a product.
 */
public class AdaugareProdusGUI extends JFrame {

    private JPanel p1,p2,p3,p,p4,p5;
    private JLabel denumire,pretBuc,cantitate;
    private JTextField t1,t2,t3,t4;
    private JButton buton,butonBack;
    /**
     * Constructor for AdaugareProdusGUI.
     * Initializes the GUI components and sets up the layout.
     */
    public AdaugareProdusGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,150);

        denumire=new JLabel("Denumire produs");
        t1=new JTextField(30);
        t1.setPreferredSize(new Dimension(150,30));

        pretBuc=new JLabel("Pret/buc produs");
        t2=new JTextField(30);
        t2.setPreferredSize(new Dimension(150,30));

        cantitate=new JLabel("Cantitate produs");
        t3=new JTextField(30);
        t3.setPreferredSize(new Dimension(150,30));

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();

        p1.add(denumire);
        p1.add(t1);

        p2.add(pretBuc);
        p2.add(t2);

        p3.add(cantitate);
        p3.add(t3);

        buton=new JButton("Adauga");
        p4.add(buton);
        butonBack=new JButton("Inapoi");
        p5.add(butonBack);

        p=new JPanel();

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);

        p.setLayout(new GridLayout(8,1));
        this.setContentPane(p);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    /**
     * Retrieves the input value from the "Denumire produs" text field.
     *
     * @return the value entered the "Denumire produs" text field
     */

    public String getDenumireInput()
    {
        return t1.getText();
    }
    /**
     * Retrieves the input value from the "Pret/buc produs" text field.
     *
     * @return the value entered the "Pret/buc produs" text field
     */
    public String getPretbucInput()
    {
        return t2.getText();
    }
    /**
     * Retrieves the input value from the "Cantitate produs" text field.
     *
     * @return the value entered  the "Cantitate produs" text field
     */
    public String getCantitateInput()
    {
        return t3.getText();
    }

    public JPanel getP1() {
        return p1;
    }

    public void setP1(JPanel p1) {
        this.p1 = p1;
    }

    public JPanel getP2() {
        return p2;
    }

    public void setP2(JPanel p2) {
        this.p2 = p2;
    }

    public JPanel getP3() {
        return p3;
    }

    public void setP3(JPanel p3) {
        this.p3 = p3;
    }

    public JPanel getP() {
        return p;
    }

    public void setP(JPanel p) {
        this.p = p;
    }

    public JPanel getP4() {
        return p4;
    }

    public void setP4(JPanel p4) {
        this.p4 = p4;
    }

    public JLabel getDenumire() {
        return denumire;
    }

    public void setDenumire(JLabel denumire) {
        this.denumire = denumire;
    }

    public JLabel getPretBuc() {
        return pretBuc;
    }

    public void setPretBuc(JLabel pretBuc) {
        this.pretBuc = pretBuc;
    }

    public JLabel getCantitate() {
        return cantitate;
    }

    public void setCantitate(JLabel cantitate) {
        this.cantitate = cantitate;
    }

    public JTextField getT1() {
        return t1;
    }

    public void setT1(JTextField t1) {
        this.t1 = t1;
    }

    public JTextField getT2() {
        return t2;
    }

    public void setT2(JTextField t2) {
        this.t2 = t2;
    }

    public JTextField getT3() {
        return t3;
    }

    public void setT3(JTextField t3) {
        this.t3 = t3;
    }

    public JButton getButon() {
        return buton;
    }

    public void setButon(JButton buton) {
        this.buton = buton;
    }
    /**
     * Adds an action listener to the "Adauga" button.
     *
     * @param ac the action listener to be added
     */

    public void addAdaugareProdusFinalListener(ActionListener ac) {
        buton.addActionListener(ac);
    }
    /**
     * Adds an action listener to the "Inapoi" button.
     *
     * @param ac the action listener to be added
     */
    public void addBackListener(ActionListener ac) {
        butonBack.addActionListener(ac);
    }
    /**
     * Displays an error message dialog with the given message.
     *
     * @param s the error message to be displayed
     */
    public void aruncaEroare(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
}



