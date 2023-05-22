package presentation.view;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Graphical user interface for StergereProdusGUI.
 */
public class StergereProdusGUI extends JFrame{
    private JPanel p1,panel,p2;
    private JTextField textF1;
    private JButton buton;
    private JLabel denumire;

    /**
     * Constructor for StergereProdusGUI.
     * Initializes the GUI components and sets up the layout.
     */

    public StergereProdusGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,150);

        denumire=new JLabel("Denumire produs");
        textF1=new JTextField(30);
        textF1.setPreferredSize(new Dimension(150,30));


        p1=new JPanel();
        p2=new JPanel();

        p1.add(denumire);
        p1.add(textF1);

        buton=new JButton("Stergere");
        p2.add(buton);

        panel=new JPanel();

        panel.add(p1);
        panel.add(p2);

        panel.setLayout(new GridLayout(2,1));
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    /**
     * Retrieves the denumire input from the text field.
     *
     * @return the denumire input
     */
    public String getDenumireInput()
    {
        return textF1.getText();
    }

    /**
     * Adds an ActionListener for the "Stergere" button.
     *
     * @param ac the ActionListener to be added
     */
    public void addStergereProdusFinalListener(ActionListener ac) {
        buton.addActionListener(ac);
    }


}


