package entity.type;

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
    private ArrayList<String> behaviourManagement;

    /**
     *
     */
    public History() {
        conditions = new ArrayList<>();
    }

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
    public String[] getConditions() {
        return (String[]) conditions.toArray();
    }
}
