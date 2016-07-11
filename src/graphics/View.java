package graphics;

import data.DataParser;
import data.export.DataExportJSON;
import entity.Logbook;
import entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ListIterator;

/**
 * Created by mladen on 08/07/16.
 */
public class View
        extends JFrame {

    // Local copy of Logbook.
    Logbook book;

    // The table and scroll pane of the view.
    private ViewTable table;
    private JScrollPane scrollPane;


    /**
     * FileLoadAction
     */
    private class FileLoadAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Display the file dialog.
            FileDialog fd = new FileDialog(View.this, "Choose a file", FileDialog.LOAD);
            fd.setFile("*.csv");
            fd.setVisible(true);

            // Check if we have selected a file.
            String filename = fd.getFile();
            if (filename != null) {
                // Pass on the full path.
                openFile(fd.getDirectory() + filename);
            }
        }
    }

    private class GenerateAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            DataExportJSON jsonExporter = new DataExportJSON();

            jsonExporter.convertStudent(
                book.getStudent(
                        table.getSelectedRow()
                )
            );
        }
    }

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
        menuItem.addActionListener(new FileLoadAction());
        menu.add(menuItem);

        menuItem = new JMenuItem("Exit");
        menuItem.setMnemonic(KeyEvent.VK_E);
        menuItem.setToolTipText("Exit the program.");
        //menuItem.addActionListener(new ExitAction());
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
        menuItem.addActionListener(new GenerateAction());
        menu.add(menuItem);

        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    /**
     * Create the table view.
     */
    public void createTable() {
        // Initialise the table.
        table = new ViewTable();

        // Add the table to a scrolling pane.
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Clear the entries in the table.
     */
    public void clearTable() {
        table.deleteRows();
    }

    /**
     * Open a selected file.
     *
     * This method creates a <tt>DataParser</tt> instance
     * and processes the file. Once processed, the returned
     * league's teams are iterated and added to the table.
     *
     * @param file The file to open.
     */
    public void openFile(String file) {
        DataParser parser = new DataParser();

        // Clear the table.
        clearTable();

        try {
            // Process the file.
            book = parser.process(new File(file));

            // Iterate over all students.
            ListIterator<Student> students = book.getStudents().listIterator();
            while (students.hasNext()) {
                table.addRow(students.nextIndex() + 1, students.next());
            }
        } catch (FileNotFoundException e) {
            // Display an error message.
            JOptionPane.showMessageDialog(this, "Something went wrong with your file.");
        }
    }
}
