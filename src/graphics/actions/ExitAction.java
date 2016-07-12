package graphics.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mladen on 11/07/16.
 */
public class ExitAction extends AbstractAction {

    public ExitAction() { }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
