package graphics.actions;

import graphics.View;
import graphics.menus.MenuAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by mladen on 11/07/16.
 */
public class ExitAction
        extends AbstractAction
        implements MenuAction {

    public ExitAction() { }

    public void setContext(View context) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
