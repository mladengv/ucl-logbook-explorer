package graphics.actions;

import data.export.DataExportCSV;
import data.export.DataExportJSON;
import entity.Student;
import graphics.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by mladen on 11/07/16.
 */

public class ExportAction extends AbstractAction {

    private View context;

    public ExportAction(View context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Student student = context.book.getStudent(
                context.getTablePanel().getTable().getSelectedRow()
        );

        FileDialog fd = new FileDialog(context, "Save", FileDialog.SAVE);
        fd.setFilenameFilter(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".json");
            }
        });

        fd.setFile(student.getUsername() + ".json");
        fd.setVisible(true);

        // Save the file.
        DataExportJSON jsonExporter = new DataExportJSON();
        jsonExporter.setFile(new File(fd.getDirectory() + fd.getFile()));
        jsonExporter.convertStudent(student);

        DataExportCSV csvExporter = new DataExportCSV();
        csvExporter.setFile(new File(fd.getDirectory() + student.getUsername() + ".csv"));
        csvExporter.convertStudent(student);

    }
}