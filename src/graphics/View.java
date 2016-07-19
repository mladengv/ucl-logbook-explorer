package graphics;

import config.MenuConfig;
import entity.Logbook;
import graphics.menus.Menu;
import graphics.menus.MenuItem;
import graphics.panels.IntroPanel;
import graphics.panels.ProgressPanel;
import graphics.panels.TablePanel;

import javax.swing.*;
import java.awt.BorderLayout;

/**
 * Created by mladen on 08/07/16.
 */
public class View
        extends JFrame {

    // Local copy of Logbook.
    public Logbook book;

    /**
     * Panels
     */
    private IntroPanel introPanel;
    private ProgressPanel progressPanel;
    private TablePanel tablePanel;

    /**
     * Default constructor.
     */
    public View() {
        initialise();

        // Create all elements.
        createMenu();
        createPanels();
        showIntro();
    }

    /**
     * Set default properties of the frame.
     */
    private void initialise() {
        setLayout(new BorderLayout());
    }

    /**
     * Create the menu.
     */
    public void createMenu() {
        /*
        JMenuBar menuBar = new JMenuBar();

        // The menu.
        JMenu menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);

        // The items.
        JMenuItem menuItem = new JMenuItem("Load CSV");
        menuItem.setMnemonic(KeyEvent.VK_L);
        menuItem.setToolTipText("Select a file to load.");
        menuItem.addActionListener(new FileLoadAction(this));
        menu.add(menuItem);

        menuItem = new JMenuItem("Exit");
        menuItem.setMnemonic(KeyEvent.VK_E);
        menuItem.setToolTipText("Exit the program");
        menuItem.addActionListener(new ExitAction());
        menu.add(menuItem);

        // Add the menu to the frame.
        menuBar.add(menu);

        // Generate.
        menu = new JMenu("Generate");
        menu.setMnemonic(KeyEvent.VK_G);

        // Student JSON file.
        menuItem = new JMenuItem("Student JSON file");
        menuItem.setMnemonic(KeyEvent.VK_J);
        menuItem.setToolTipText("Generate an output file for the selected student.");
        menuItem.addActionListener(new ExportAction(this));
        menu.add(menuItem);

        menuBar.add(menu);
        */

        JMenuBar menuBar = new JMenuBar();
        for (Menu menu: MenuConfig.viewMenus) {
            for (MenuItem menuItem : menu.getItems()) {
                menuItem.getMenuAction().setContext(this);
            }
            menuBar.add(menu);
        }
        setJMenuBar(menuBar);
    }

    public void createPanels() {
        introPanel = new IntroPanel();
        progressPanel = new ProgressPanel();
        tablePanel = new TablePanel();
    }

    public void showIntro() {
        add(introPanel);
    }
    public void removeIntro() {
        remove(introPanel);
    }

    public void showProgress() {
        add(progressPanel, BorderLayout.NORTH);
    }
    public void removeProgress() {
        remove(progressPanel);
    }

    public void showTable() {
        add(tablePanel, BorderLayout.CENTER);
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    /**
     *
     */
    public void showViewer() {
        removeIntro();

        showProgress();
        showTable();

        getContentPane().invalidate();
        getContentPane().validate();
        getContentPane().repaint();
    }
}
