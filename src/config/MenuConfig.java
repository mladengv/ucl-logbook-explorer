package config;

import graphics.actions.*;

import graphics.menus.Menu;
import graphics.menus.MenuItem;

import java.awt.event.KeyEvent;

/**
 * Created by mladen on 12/07/16.
 */
public class MenuConfig {

    /**
     * View menus
     */
    public static Menu[] viewMenus = new Menu[]{
        new Menu("File", KeyEvent.VK_F, new MenuItem[] {
                new MenuItem("Open file", KeyEvent.VK_O, "Load a CSV file to process", new FileLoadAction()),
                new MenuItem("Exit", KeyEvent.VK_E, "Exit", new ExitAction()),
        }), new Menu("Generate", KeyEvent.VK_G, new MenuItem[] {
                new MenuItem("Create JSON file", KeyEvent.VK_J, "Generate JSON file for student", new ExportAction()),
                new MenuItem("Create CSV file", KeyEvent.VK_C, "Generate CSV file for student", new ExportAction()),
        }), new Menu("Batch", KeyEvent.VK_B, new MenuItem[] {
            new MenuItem("All students, all files", KeyEvent.VK_A, "Generate files for all students", new BatchAction()),
        }),
    };
}
