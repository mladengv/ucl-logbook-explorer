package graphics.menus;

import javax.swing.*;

/**
 * Created by mladen on 19/07/16.
 */
public class Menu
        extends JMenu {

    private MenuItem[] items;

    public Menu(String name, int mnemonic) {
        super(name);
        setMnemonic(mnemonic);
    }

    public Menu(String name, int mnemonic, MenuItem[] items) {
        this(name, mnemonic);

        setItems(items);
        addItems();
    }

    public void setItems(MenuItem[] items) {
        this.items = items;
    }

    public void addItems() {
        for (MenuItem item: items) {
            add(item);
        }
    }

    public MenuItem[] getItems() {
        return items;
    }
}
