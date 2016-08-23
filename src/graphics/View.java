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

    public ProgressPanel getProgressPanel() {
        return progressPanel;
    }
    public void showProgress() {
        progressPanel.resetProgress();

        add(progressPanel, BorderLayout.NORTH);
        forceRevalidate();
    }
    public void removeProgress() {
        remove(progressPanel);
        forceRevalidate();
    }

    public void showTable() {
        add(tablePanel, BorderLayout.CENTER);
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    /**
     * Display Viewer layout
     */
    public void showViewer() {
        removeIntro();

        showProgress();
        showTable();

        forceRevalidate();
    }

    /**
     * Force re-validation and repainting.
     */
    public void forceRevalidate() {
        getContentPane().invalidate();
        getContentPane().validate();
        getContentPane().repaint();
    }

}
