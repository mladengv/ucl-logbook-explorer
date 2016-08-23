package graphics.actions;

import data.export.DataExportCSV;
import data.export.DataExportJSON;
import entity.Student;
import graphics.View;
import graphics.menus.MenuAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Created by mladen on 20/07/16.
 */
public class BatchAction
        extends AbstractAction
        implements MenuAction {

    private View context;
    private Task task;

    public BatchAction() {

    }

    public void setContext(View context) {
        this.context = context;
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Setup and display the file dialog
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setAcceptAllFileFilterUsed(true);

        // Check if the user has selected a directory
        if (fc.showOpenDialog(context) == JFileChooser.APPROVE_OPTION) {
            // Run the task
            task = new Task(fc.getSelectedFile());
            task.execute();
        } else {
            JOptionPane.showMessageDialog(context, "You have cancelled the batch!");
        }
    }


    class Task extends SwingWorker<Void, Void> {

        private File folder;

        public Task(File folder) {
            this.folder = folder;
        }

        @Override
        public Void doInBackground() {

            DataExportCSV csvExporter = new DataExportCSV();
            DataExportJSON jsonExporter = new DataExportJSON();

            context.showProgress();

            int count = 0, total = context.book.getStudents().size();

            // Iterate over all students
            for (Student student : context.book.getStudents()) {
                File currentFolder = new File(folder + "/" + student.getUsername());

                if (!currentFolder.exists()) {
                    if (!currentFolder.mkdir()) {
                        JOptionPane.showMessageDialog(context, "Could not create folder!");
                        return null;
                    }
                }

                jsonExporter.setFile(new File(currentFolder + "/" + student.getUsername() + ".json"));
                jsonExporter.convertStudent(student);

                csvExporter.setFile(new File(currentFolder + "/" + student.getUsername() + ".csv"));
                csvExporter.convertStudent(student);

                context.getProgressPanel().updateProgress(Math.round(100 * count++/total));
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
