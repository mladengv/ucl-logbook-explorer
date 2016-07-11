package entity;

import data.ParserSchema;
import entity.type.Diagnosis;
import entity.type.History;
import entity.type.Outcome;
import entity.type.Treatment;

import java.util.Date;

/**
 * Created by mladen on 08/07/16.
 */
public class Visit {

    // Time of appointment.
    private Date appointmentDate;

    // Type of appointment.
    private String appointmentType;

    /**
     * Contents of the Visit.
     */
    private History history;
    private Diagnosis diagnosis;
    private Treatment treatment;
    private Outcome outcome;

    /**
     * Default constructor.
     */
    public Visit() {

    }

    /**
     *
     * @param diagnosis
     */
    public Visit(History history, Diagnosis diagnosis, Treatment treatment, Outcome outcome) {
        setDiagnosis(diagnosis);
        setHistory(history);
        setTreatment(treatment);
        setOutcome(outcome);
    }

    /**
     *
     * @param history
     */
    public void setHistory(History history) {
        this.history = history;
    }

    /**
     *
     * @return
     */
    public History getHistory() {
        return history;
    }

    /**
     *
     * @param diagnosis
     */
    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     *
     * @return
     */
    public Diagnosis getDiagnosis() {
        return this.diagnosis;
    }

    /**
     *
     * @param treatment
     */
    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    /**
     *
     * @return
     */
    public Treatment getTreatment() {
        return treatment;
    }

    /**
     *
     * @param outcome
     */
    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    /**
     *
     * @return
     */
    public Outcome getOutcome() {
        return outcome;
    }
}
