package presentation.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * Graphical user interface for EditareProdusGUI.
 */
public class EditareProdusGUI extends JFrame{

    private JPanel p1,p2,p3,panel,p7,p8,p9;
    private JLabel denumire,pretBuc,cantitate,denumireProdEd;
    private JTextField t1,t2,t3,t4,t5;
    private JButton buton,butonBack;

    /**
     * Constructor for EditareProdusGUI.
     * Initializes the GUI components and sets up the layout.
     */
    public EditareProdusGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,150);

        denumireProdEd=new JLabel("Denumire produs editat");
        t4=new JTextField(30);
        t4.setPreferredSize(new Dimension(150,30));

        denumire=new JLabel("Denumire produs");
        t1=new JTextField(30);
        t1.setPreferredSize(new Dimension(150,30));

        pretBuc=new JLabel("Pret/bucata");
        t2=new JTextField(30);
        t2.setPreferredSize(new Dimension(150,30));

        cantitate=new JLabel("Cantitate");
        t3=new JTextField(30);
        t3.setPreferredSize(new Dimension(150,30));

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p7=new JPanel();
        p8=new JPanel();
        p9=new JPanel();
        panel=new JPanel();

        p8.add(denumireProdEd);
        p8.add(t4);

        p1.add(denumire);
        p1.add(t1);

        p2.add(pretBuc);
        p2.add(t2);

        p3.add(cantitate);
        p3.add(t3);

        buton=new JButton("Editeaza");
        p7.add(buton);
        butonBack=new JButton("Inapoi");
        p9.add(butonBack);

        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p7);
        panel.add(p8);
        panel.add(p9);

        panel.setLayout(new GridLayout(8,1));
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    /**
     * Adds an ActionListener for the "Editeaza" button.
     *
     * @param a  the ActionListener to be added
     */
    public void addEditareProdusFinalListener(ActionListener a) {
        buton.addActionListener(a);
    }
    /**
     * Adds an ActionListener for the "Inapoi" button.
     *
     * @param a  the ActionListener to be added
     */
    public void addBackListener(ActionListener a) {
        butonBack.addActionListener(a);
    }
    /**
     * Returns the value entered the "Denumire produs editat" field.
     *
     * @return the value entered the field
     */
    public String getDenumireeditatInput()
    {
        return t4.getText();
    }
    /**
     * Returns the value entered the "Denumire produs" field.
     *
     * @return the value entered the field
     */
    public String getDenumireInput()
    {
        return t1.getText();
    }
    /**
     * Returns the value entered in the "Pret/bucata" field.
     *
     * @return the value entered  the field
     */
    public String getPretbucInput()
    {
        return t2.getText();
    }
    /**
     * Returns the value entered the "Cantitate" field.
     *
     * @return the value entered  the field
     */
    public String getCantitateInput()
    {
        return t3.getText();
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

