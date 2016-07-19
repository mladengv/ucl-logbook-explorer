package graphics.menus;

import javax.swing.*;

/**
 * Created by mladen on 19/07/16.
 */
public class MenuItem
        extends JMenuItem {

    MenuAction action;

    public MenuItem(String name, int mnemonic, String tooltip, MenuAction action) {
        super(name);

        setMenuAction(action);

        setMnemonic(mnemonic);
        setToolTipText(tooltip);
        addActionListener((AbstractAction) action);
    }

    /**
     *
     * @param action
     */
    public void setMenuAction(MenuAction action) {
        this.action = action;
    }

    /**
     *
     * @return
     */
    public MenuAction getMenuAction() {
        return action;
    }
}
