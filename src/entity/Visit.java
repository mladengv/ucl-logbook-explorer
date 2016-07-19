package entity;

import data.ParserSchema;
import entity.type.*;

import java.util.Date;

/**
 * Created by mladen on 08/07/16.
 */
public class Visit {

    // Time of appointment.
    private String appointmentDate;

    // Type of appointment.
    private String appointmentType;

    // The patient.
    private Patient patient;

    /**
     * Contents of the Count.
     */
    private History history;
    private Diagnosis diagnosis;
    private Trauma trauma;
    private Treatment treatment;
    private Outcome outcome;

    /**
     * Default constructor.
     */
    public Visit(String type, String date) {
        setAppointmentType(type);
        setAppointmentDate(date);
    }

    /**
     *
     * @param diagnosis
     */
    public Visit(String type,
                 String date,
                 History history,
                 Diagnosis diagnosis,
                 Trauma trauma,
                 Treatment treatment,
                 Outcome outcome) {

        this(type, date);

        setHistory(history);
        setDiagnosis(diagnosis);
        setTrauma(trauma);
        setTreatment(treatment);
        setOutcome(outcome);
    }

    public void setAppointmentDate(String date) {
        this.appointmentDate = date;
    }
    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentType(String type) {
        this.appointmentType = type;
    }
    public String getAppointmentType() {
        return appointmentType;
    }

    /**
     *
     * @param patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     *
     * @return
     */
    public Patient getPatient() {
        return patient;
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

    public void setTrauma(Trauma trauma) {
        this.trauma = trauma;
    }

    public Trauma getTrauma() {
        return trauma;
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
