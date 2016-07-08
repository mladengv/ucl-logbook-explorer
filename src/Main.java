import java.awt.*;

import config.Config;
import graphics.View;

/**
 * Created by mladen on 08/07/16.
 */
public class Main
        extends View {

    /**
     * Default constructor.
     */
    public Main() {
        super();
        initialise();
    }

    /**
     * Set default properties of the frame.
     */
    public void initialise() {
        setTitle(Config.TITLE);
        setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Open the main window.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main window = new Main();
                window.setVisible(true);
            }
        });
    }
}

