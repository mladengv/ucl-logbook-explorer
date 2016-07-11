package graphics.panels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by mladen on 11/07/16.
 */
public class ProgressPanel
        extends JPanel
        implements ActionListener, PropertyChangeListener {

    private JProgressBar progressBar;

    /**
     *
     */
    public ProgressPanel() {
        initialise();

        progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        add(progressBar);
    }

    public void initialise() {
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    public void actionPerformed(ActionEvent evt) {

    }

    public void propertyChange(PropertyChangeEvent evt) {
    }
}
