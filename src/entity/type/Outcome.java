package entity.type;

import java.util.ArrayList;

/**
 * Created by mladen on 08/07/16.
 */
public class Outcome {

    // List of outcomes for the visit.
    private ArrayList<String> outcomes;

    private String reflection;
    private ArrayList<String> custom;

    /**
     *
     */
    public Outcome() {
        outcomes = new ArrayList<>();
        custom = new ArrayList<>();
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
     * @param outcomes
     * @param reflection
     */
    public Outcome(String[] outcomes, String reflection) {
        this(outcomes);
        this.setReflection(reflection);
    }

    /**
     *
     * @param outcomes
     * @param reflection
     * @param args
     */
    public Outcome(String[] outcomes, String reflection, String ...args) {
        this(outcomes, reflection);
        for (String arg: args) {
            addCustom(arg);
        }
    }

    /**
     *
     * @param outcome
     */
    public void addOutcome(String outcome) {
        outcomes.add(outcome);
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getOutcomes() {
        return outcomes;
    }

    /**
     *
     * @param custom
     */
    public void addCustom(String custom) {
        this.custom.add(custom);
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getCustom() {
        return custom;
    }



    /**
     *
     * @param reflection
     */
    public void setReflection(String reflection) {
        this.reflection = reflection;
    }

    /**
     *
     * @return
     */
    public String getReflection() {
        return reflection;
    }
}
