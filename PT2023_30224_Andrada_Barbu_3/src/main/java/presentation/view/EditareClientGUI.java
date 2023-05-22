package presentation.view;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * Graphical user interface for EditareClientGUI.
 */
public class EditareClientGUI extends JFrame{

    private JButton buton, butonBack;
    private JPanel panel,p1,p2,p3,p4,p7,p8,p9;
    private JLabel nume,adresa,varsta,email,emailEditat;
    private JTextField t1,t2,t3,t4,t6,t7;

    /**
     * Constructor for EditareClientGUI.
     * Initializes the GUI components and sets up the layout.
     */
    public EditareClientGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,150);

        emailEditat=new JLabel("Email client editat");
        t6=new JTextField(30);
        t6.setPreferredSize(new Dimension(150,30));

        nume=new JLabel("Nume client");
        t1=new JTextField(30);
        t1.setPreferredSize(new Dimension(150,30));

        adresa=new JLabel("Adresa client");
        t2=new JTextField(30);
        t2.setPreferredSize(new Dimension(150,30));

        varsta=new JLabel("Telefon client");
        t3=new JTextField(30);
        t3.setPreferredSize(new Dimension(150,30));

        email=new JLabel("Email client");
        t4=new JTextField(30);
        t4.setPreferredSize(new Dimension(150,30));

        buton=new JButton("Editeaza");
        butonBack=new JButton("Inapoi");

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p7=new JPanel();
        p8=new JPanel();
        p9=new JPanel();

        panel=new JPanel();

        p8.add(emailEditat);
        p8.add(t6);

        p1.add(nume);
        p1.add(t1);

        p2.add(adresa);
        p2.add(t2);

        p3.add(varsta);
        p3.add(t3);

        p4.add(email);
        p4.add(t4);


        p7.add(buton);
        p9.add(butonBack);

        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p4);
        panel.add(p7);
        panel.add(p8);
        panel.add(p9);

        panel.setLayout(new GridLayout(8,1));
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    /**
     * Returns the value entered the "Nume client" field.
     *
     * @return the value entered the field
     */
    public String getNumeInput()
    {
        return t1.getText();
    }
    /**
     * Returns the value entered the "Adresa client" field.
     *
     * @return the value entered the field
     */
    public String getAdresaInput()
    {
        return t2.getText();
    }
    /**
     * Returns the value entered the "Telefon client" field.
     *
     * @return the value entered the field
     */
    public String getTelefonInput()
    {
        return t3.getText();
    }
    /**
     * Returns the value entered the "Email client" field.
     *
     * @return the value entered  the field
     */
    public String getEmailInput()
    {
        return t4.getText();
    }
    /**
     * Returns the value entered the "Email client editat" field.
     *
     * @return the value entered the field
     */

    public String getEditatInput()
    {
        return t6.getText();
    }

    /**
     * Adds an ActionListener for the "Editeaza" button.
     *
     * @param ac  the ActionListener to be added
     */
    public void addEditareClientFinalListener(ActionListener ac) {
        buton.addActionListener(ac);
    }
    /**
     * Adds an ActionListener for the "Inapoi" button.
     *
     * @param ac  the ActionListener to be added
     */
    public void addBackListener(ActionListener ac) {
        butonBack.addActionListener(ac);
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
