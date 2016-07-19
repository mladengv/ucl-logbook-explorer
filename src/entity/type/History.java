package entity.type;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mladen on 08/07/16.
 */
public class History {

    // Availability of medical history.
    private String availability;

    // List of known conditions.
    private ArrayList<String> conditions;

    // List of behaviour management.
    private ArrayList<String> behaviour;

    // Notes
    private String notes;

    /**
     *
     */
    public History() {
        conditions = new ArrayList<>();
        behaviour = new ArrayList<>();
    }

    /**
     *
     * @param availability
     */
    public History(String availability) {
        this();
        setAvailability(availability);
    }
    /**
     *
     * @param conditions
     */
    public History(String availability, String[] conditions) {
        this(availability);
        // Add all conditions
        for (String condition : conditions) {
            addCondition(condition);
        }
    }

    /**
     *
     * @param availability
     * @param conditions
     * @param behaviourManagement
     */
    public History(String availability, String[] conditions, String[] behaviourManagement, String notes) {
        this(availability, conditions);
        for (String behaviour : behaviourManagement) {
            addBehaviour(behaviour);
        }
        setNotes(notes);
    }

    /**
     *
     * @param availability
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     *
     * @return
     */
    public String getAvailability() {
        return availability;
    }

    /**
     *
     * @param condition
     */
    public void addCondition(String condition) {
        conditions.add(condition);
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getConditions() {
        return conditions;
    }

    /**
     *
     * @param behaviour
     */
    public void addBehaviour(String behaviour) {
        this.behaviour.add(behaviour);
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getBehaviour() {
        return behaviour;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }
}
