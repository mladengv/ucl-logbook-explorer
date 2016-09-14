package entity.type;

import java.util.ArrayList;

/**
 * Created by mladen on 08/07/16.
 */
public class Treatment {

    // List of recommended treatments.
    private ArrayList<String> treatments;

    private String notes;

    /**
     *
     */
    public Treatment() {
        treatments = new ArrayList<>();
    }

    /**
     *
     * @param treatments
     */
    public Treatment(String[] treatments) {
        this();

        for (String treatment : treatments) {
            addTreatment(treatment);
        }
    }

    public Treatment(String[] treatments, String notes) {
        this(treatments);
        this.setNotes(notes);
    }

    /**
     *
     * @param treatment
     */
    public void addTreatment(String treatment) {
        treatments.add(treatment);
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getTreatments() {
        return treatments;
    }

    /**
     *
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     *
     * @return
     */
    public String getNotes() {
        return notes;
    }
}
