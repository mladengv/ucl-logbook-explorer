package graphics.actions;

import data.DataParser;
import entity.Student;
import graphics.View;
import graphics.menus.MenuAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ListIterator;

/**
 * Created by mladen on 11/07/16.
 */
public class FileLoadAction
        extends AbstractAction
        implements MenuAction {

    private View context;

    private Task task;

    public FileLoadAction() {

    }

    public void setContext(View context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Set cursor to wait
        context.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        // Display the file dialog.
        FileDialog fd = new FileDialog(context, "Choose a file", FileDialog.LOAD);
        fd.setFile("*.csv");
        fd.setVisible(true);

        // Check if we have selected a file.
        String filename = fd.getFile();
        if (filename != null) {
            // Pass on the full path.
            openFile(fd.getDirectory() + filename);
        }
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
        // Hide introduction panel.
        context.showViewer();

        // Clear the table.
        context.getTablePanel().clearTable();

        task = new Task(file);
        task.execute();
    }

    class Task extends SwingWorker<Void, Void> {

        private String file;

        public Task(String file) {
            this.file = file;
        }

        @Override
        public Void doInBackground() {

            DataParser parser = new DataParser();
            try {

                // Open the file
                parser.open(new File(file));

                int count = 0, last_read, lines = parser.countLines();
                while ((last_read = parser.processNext()) > 0) {
                    count += last_read;
                    context.getProgressPanel().updateProgress(Math.round(100 * count/lines));
                }

                // Get the Logbook
                context.book = parser.getBook();

                // Populate table of students
                ListIterator<Student> students = context.book.getStudents().listIterator();
                while (students.hasNext()) {
                    context.getTablePanel().getTable().addRow(students.nextIndex() + 1, students.next());
                }
            } catch (FileNotFoundException e) {
                // Display an error message.
                JOptionPane.showMessageDialog(context, "Something went wrong with your file.");
            }
            return null;
        }

        @Override
        public void done() {
            // Restore cursor
            context.setCursor(null);
            // Remove progress bar
            context.removeProgress();
        }
    }
}
