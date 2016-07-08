package graphics;

import config.Config;
import entity.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by mladen on 08/07/16.
 */
public class ViewTable
        extends JTable {


    private DefaultTableModel model;

    /**
     * Default constructor.
     */
    public ViewTable() {
        // Set basic properties.
        initialise();
        // Set the data model.
        prepareModel();
        // Create elements.
        createColumns();
    }

    /**
     * Set default properties for the table.
     */
    public void initialise() {
        setPreferredSize(new Dimension(
                Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT
        ));

        // Disable column ordering.
        getTableHeader().setReorderingAllowed(false);
    }

    /**
     *
     */
    public void prepareModel() {
        model = (DefaultTableModel) this.getModel();
        setModel(model);
    }

    /**
     * Create and style all columns.
     */
    public void createColumns() {
        // Add the columns.
        model.addColumn("#");
        model.addColumn("Student Name");
        model.addColumn("Username");
        model.addColumn("Number of Patients");
        model.addColumn("Number of Visits");

        // Set custom width for fields.
        getColumn("#").setMaxWidth(50);
        getColumn("Student Name").setMinWidth(200);
    }

    /**
     * Delete all rows of the table.
     */
    public void deleteRows() {
        int rows = model.getRowCount();
        for(int i = rows - 1; i >= 0 ; i--) {
            model.removeRow(i);
        }
    }

    /**
     * Add a row to the table.
     *
     * @param index The position of the row.
     * @param student The team to add.
     */
    public void addRow(int index, Student student) {

        // Specify each column.
        model.addRow(new Object[]{
                index,
                student.getName(),
                student.getUsername(),
                0,
                0,
        });
    }

    /**
     * Make sure cells are not editable.
     *
     * @return Always <tt>False</tt>.
     */
    public boolean isCellEditable(int row, int column){
        return false;
    }
}
