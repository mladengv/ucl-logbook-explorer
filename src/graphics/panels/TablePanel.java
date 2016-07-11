package graphics.panels;

import graphics.ViewTable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mladen on 11/07/16.
 */
public class TablePanel
        extends JPanel {

    private ViewTable table;

    private JScrollPane scrollPane;


    public TablePanel() {

        initialise();

        // Table.
        table = new ViewTable();
        table.setFillsViewportHeight(true);

        scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void initialise() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setBackground(Color.BLACK);
    }

    public ViewTable getTable() {
        return table;
    }

    /**
     * Clear the entries in the table.
     */
    public void clearTable() {
        table.deleteRows();
    }
}
