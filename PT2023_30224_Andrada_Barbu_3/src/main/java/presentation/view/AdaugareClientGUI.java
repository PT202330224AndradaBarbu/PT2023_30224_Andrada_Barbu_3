package presentation.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * Graphical user interface for adding a client.
 */
public class AdaugareClientGUI extends JFrame{

    private JLabel nume,adresa,telefon,email;
    private JPanel p1,p3,p4,p5,p6,pPr,p7;
    private JButton buton,butonBack;
    private JTextField t1,t3,t4,t5,t6;
    /**
     * Constructor for AdaugareClientGUI.
     * Initializes the GUI components and sets up the layout.
     */
    public AdaugareClientGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,150);

        nume=new JLabel("Nume client");
        t1=new JTextField(30);
        t1.setPreferredSize(new Dimension(150,30));

        telefon=new JLabel("Telefon client");
        t3=new JTextField(30);
        t3.setPreferredSize(new Dimension(150,30));

        email=new JLabel("Email client");
        t4=new JTextField(30);
        t4.setPreferredSize(new Dimension(150,30));

        adresa=new JLabel("Adresa Client");
        t5=new JTextField(30);
        t5.setPreferredSize(new Dimension(150,30));

        p1=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        p6=new JPanel();
        p7 = new JPanel();

        p1.add(nume);
        p1.add(t1);

        p3.add(telefon);
        p3.add(t3);

        p4.add(email);
        p4.add(t4);

        p5.add(adresa);
        p5.add(t5);


        buton=new JButton("Adauga");
        p6.add(buton);
        butonBack=new JButton("Inapoi");
        p7.add(butonBack);

        pPr=new JPanel();

        pPr.add(p1);
        pPr.add(p3);
        pPr.add(p4);
        pPr.add(p5);
        pPr.add(p6);
        pPr.add(p7);

        pPr.setLayout(new GridLayout(8,1));
        this.setContentPane(pPr);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Adds an ActionListener for the "Adauga" button.
     *
     * @param ac the ActionListener to be added
     */
    public void addAdaugareClientFinalListener(ActionListener ac) {
        buton.addActionListener(ac);
    }

    /**
     * Adds an ActionListener for the "Inapoi" button.
     *
     * @param ac the ActionListener to be added
     */
    public void addBackListener(ActionListener ac) {
        butonBack.addActionListener(ac);
    }

    /**
     * Retrieves the input value from the "Nume client" text field.
     *
     * @return the value entered the "Nume client" text field
     */
    public String getNumeInput()
    {
        return t1.getText();
    }

    /**
     * Retrieves the input value from the "Telefon client" text field.
     *
     * @return the value entered the "Telefon client" text field
     */
    public String getTelefonInput()
    {
        return t3.getText();
    }

    /**
     * Retrieves the input value from the "Email client" text field.
     *
     * @return the value entered  the "Email client" text field
     */
    public String getEmailInput()
    {
        return t4.getText();
    }

    /**
     * Retrieves the input value from the "Adresa client" text field.
     *
     * @return the value entered the "Adresa client" text field
     */
    public String getAdresaInput()
    {
        return t5.getText();
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
