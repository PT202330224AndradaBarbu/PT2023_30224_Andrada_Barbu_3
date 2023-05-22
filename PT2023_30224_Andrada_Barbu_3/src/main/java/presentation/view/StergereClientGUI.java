package presentation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * Graphical user interface for StergereClientGUI.
 */
public class StergereClientGUI extends JFrame {
    private JPanel p2,panel,p3;
    private JLabel email;
    private JTextField t2;
    private JButton buton;

    /**
     * Constructor for StergereClientGUI.
     * Initializes the GUI components and sets up the layout.
     */
    public StergereClientGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,150);

        email=new JLabel("Email client");
        t2=new JTextField(30);
        t2.setPreferredSize(new Dimension(150,30));

        p2=new JPanel();
        p3=new JPanel();
        panel=new JPanel();


        p2.add(email);
        p2.add(t2);

        buton=new JButton("Stergere");
        p3.add(buton);

        panel.add(p2);
        panel.add(p3);

        panel.setLayout(new GridLayout(3,1));
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    /**
     * Adds an ActionListener for the "Stergere" button.
     *
     * @param ac the ActionListener to be added
     */
    public void addStergereClinetFinalListener(ActionListener ac) {
        buton.addActionListener(ac);
    }
    /**
     * Retrieves the email input from the text field.
     *
     * @return the email input
     */
    public String getEmailInput()
    {
        return t2.getText();
    }


}
