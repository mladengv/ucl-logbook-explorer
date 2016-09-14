package entity.type;

import java.util.ArrayList;

/**
 * Created by mladen on 12/07/16.
 */
public class Trauma {

    private String traumaType;

    private ArrayList<String> trauma;

    private String notes;

    /**
     * Default constructor
     */
    public Trauma() {
        trauma = new ArrayList<>();
    }

    /**
     *
     * @param type
     * @param trauma
     */
    public Trauma(String type, String[] trauma) {
        this();

        setTraumaType(type);
        addTrauma(trauma);
    }

    /**
     *
     * @param type
     * @param trauma
     * @param notes
     */
    public Trauma(String type, String[] trauma, String notes) {
        this(type, trauma);
        this.setNotes(notes);
    }

    /**
     *
     * @param traumaType
     */
    public void setTraumaType(String traumaType) {
        this.traumaType = traumaType;
    }

    /**
     *
     * @return
     */
    public String getTraumaType() {
        return traumaType;
    }

    /**
     *
     * @param type
     */
    public void addTrauma(String type) {
        this.trauma.add(type);
    }

    /**
     *
     * @param types
     */
    public void addTrauma(String[] types) {
        for (String type : types) {
            addTrauma(type);
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getTrauma() {
        return trauma;
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
