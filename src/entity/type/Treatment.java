package entity.type;

import java.util.ArrayList;

/**
 * Created by mladen on 08/07/16.
 */
public class Treatment {

    // List of recommended treatments.
    private ArrayList<String> treatments;

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
}
