package presentation.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 * Graphical user interface for displaying clients.
 */
public class AfisareClientiGUI extends JFrame {

    private JTable table;
    /**
     * Constructor for AfisareClientiGUI.
     * Initializes the GUI components and sets up the layout.
     */
    public AfisareClientiGUI() {
        setLayout(new FlowLayout());
        table=new JTable(new String[][]{},new String[]{});
        table.setPreferredScrollableViewportSize(new Dimension(1500,1500));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane=new JScrollPane(table);
        add(scrollPane);
    }
    /**
     * Updates the table with the provided data and column names.
     *
     * @param randuri    the data rows to be displayed in the table
     * @param coloane the column names for the table
     */
    public void actualizareTabel(String[][] randuri, String[] coloane) {
        table.setModel(new DefaultTableModel(randuri, coloane));
    }
}
