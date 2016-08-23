package graphics.panels;

import javax.swing.*;

/**
 * Created by mladen on 11/07/16.
 */
public class ProgressPanel
        extends JPanel {

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

    /**
     *
     */
    public void initialise() {
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    /**
     *
     * @param progress
     */
    public void updateProgress(int progress) {
        progressBar.setValue(progress);
    }

    public void resetProgress() {
        updateProgress(0);
    }

}
