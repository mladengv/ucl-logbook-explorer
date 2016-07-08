package graphics;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by mladen on 08/07/16.
 */
public class View
        extends JFrame {

    // The table and scroll pane of the view.
    private ViewTable table;
    private JScrollPane scrollPane;


    /**
     * Default constructor.
     */
    public View() {
        initialise();

        // Create all elements.
        createMenu();
        createTable();
    }

    /**
     * Set default properties of the frame.
     */
    public void initialise() {
        //setBackground();
    }

    /**
     * Create the menu.
     */
    public void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        // The menu.
        JMenu menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);

        // The items.
        JMenuItem menuItem = new JMenuItem("Load CSV");
        menuItem.setMnemonic(KeyEvent.VK_L);
        menuItem.setToolTipText("Select a file to load.");
        //menuItem.addActionListener(new LoadAction());
        menu.add(menuItem);

        menuItem = new JMenuItem("Exit");
        menuItem.setMnemonic(KeyEvent.VK_E);
        menuItem.setToolTipText("Exit the program.");
        //menuItem.addActionListener(new ExitAction());
        menu.add(menuItem);

        // Add the menu to the frame.
        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    /**
     * Create the table view.
     */
    public void createTable() {
    }
}
