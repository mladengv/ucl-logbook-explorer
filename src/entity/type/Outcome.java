package entity.type;

import java.util.ArrayList;

/**
 * Created by mladen on 08/07/16.
 */
public class Outcome {

    // List of outcomes for the visit.
    private ArrayList<String> outcomes;

    /**
     *
     */
    public Outcome() {
        outcomes = new ArrayList<>();
    }

    /**
     *
     * @param outcomes
     */
    public Outcome(String[] outcomes) {
        this();

        for (String outcome : outcomes) {
            addOutcome(outcome);
        }
    }

    /**
     *
     * @param outcome
     */
    public void addOutcome(String outcome) {
        outcomes.add(outcome);
    }
}
