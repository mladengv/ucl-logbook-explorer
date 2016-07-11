package graphics.panels;

import config.Config;
import config.GraphicsConfig;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mladen on 11/07/16.
 */
public class IntroPanel
        extends JPanel {

    public IntroPanel() {
        initialise();
        createField();
    }

    /**
     *
     */
    public void initialise() {
        setLayout(new BorderLayout());
    }

    /**
     * Create the text field.
     */
    public void createField() {
        JTextField text = new JTextField();

        text.setText(Config.TITLE);
        text.setOpaque(false);
        text.setEnabled(false);
        text.setDisabledTextColor(Color.BLACK);
        text.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        text.setFont(new Font(GraphicsConfig.FONT_FAMILY, Font.BOLD, GraphicsConfig.HEADLINE_FONT_SIZE));
        text.setHorizontalAlignment(JTextField.CENTER);

        add(text, BorderLayout.CENTER);
    }
}
