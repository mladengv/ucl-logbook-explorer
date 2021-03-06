package entity.type;

import java.util.ArrayList;

/**
 * Created by mladen on 08/07/16.
 */
public class Diagnosis {

    // List of given diagnoses.
    private ArrayList<String> diagnoses;

    // Notes recorded for the diagnosis.
    private String notes;

    /**
     * Default constructor
     */
    public Diagnosis() {
        diagnoses = new ArrayList<>();
    }

    /**
     *
     * @param values
     */
    public Diagnosis(String[] values) {
        this();
        // Add the diagnoses
        for (String value : values) {
            addValue(value);
        }
    }

    public Diagnosis(String[] values, String notes) {
        this(values);
        this.setNotes(notes);
    }

    /**
     *
     * @param value
     */
    public void addValue(String value) {
        this.diagnoses.add(value);
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getDiagnoses() {
        return diagnoses;
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
