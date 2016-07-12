package graphics.actions;

import data.export.DataExportJSON;
import graphics.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

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
        DataExportJSON jsonExporter = new DataExportJSON();

        jsonExporter.convertStudent(
                context.book.getStudent(
                        context.getTablePanel().getTable().getSelectedRow()
                )
        );
    }
}