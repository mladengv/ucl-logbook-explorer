package data.export;

import com.sun.deploy.util.StringUtils;
import data.ParserMap;
import entity.Patient;
import entity.Visit;
import entity.type.Diagnosis;
import entity.type.History;
import entity.type.Outcome;
import entity.type.Trauma;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mladen on 19/07/16.
 */
public class ExporterMap {

    /**
     * Default constructor
     */
    public ExporterMap() {

    }

    public String combine(String[] fields) {
        return StringUtils.join(Arrays.asList(fields), "##");
    }
    public String combine(ArrayList<String> fields) {
        return combine(fields.toArray(new String[0]));
    }

    /**
     *
     * @param visit
     * @param field
     * @return
     */
    public String get(Visit visit, ParserMap.Field field) {
        switch (field) {
            case APPOINTMENT_TYPE:
                return visit.getAppointmentType();
            case APPOINTMENT_DATE:
                return visit.getAppointmentDate();
            // Patient fields
            case PATIENT_IDENTIFIER:
            case PATIENT_BIRTHDAY:
            case PATIENT_GENDER:
                return get(visit.getPatient(), field);
            // Diagnosis fields
            case DATA_DIAGNOSIS:
                return get(visit.getDiagnosis(), field);
            // History fields
            case DATA_MEDICAL_HISTORY:
            case DATA_MEDICAL_HISTORY_CONDITIONS:
            case DATA_BEHAVIOUR_MANAGEMENT:
            case NOTES_MEDICAL_HISTORY:
                return get(visit.getHistory(), field);
            // Outcome fields
            case DATA_OUTCOME:
                return get(visit.getOutcome(), field);
            // Trauma fields
            case DATA_TRAUMA_TYPE:
            case DATA_TRAUMA:
            case NOTES_TRAUMA:
                return get(visit.getTrauma(), field);

            default:
                return null;
        }
    }

    /**
     *
     * @param patient
     * @param field
     * @return
     */
    public String get(Patient patient, ParserMap.Field field) {
        switch (field) {
            case PATIENT_IDENTIFIER:
                return patient.getIdentifier();
            case PATIENT_BIRTHDAY:
                return new SimpleDateFormat("yyyy").format(patient.getDateOfBirth());
            case PATIENT_GENDER:
                return patient.getGender();
            default:
                return null;
        }
    }

    /**
     *
     * @param diagnosis
     * @param field
     * @return
     */
    public String get(Diagnosis diagnosis, ParserMap.Field field) {
        switch (field) {
            case DATA_DIAGNOSIS:
                return combine(diagnosis.getDiagnoses());
            default:
                return null;
        }
    }

    /**
     *
     * @param history
     * @param field
     * @return
     */
    public String get(History history, ParserMap.Field field) {
        switch (field) {
            case DATA_MEDICAL_HISTORY:
                return history.getAvailability();
            case DATA_MEDICAL_HISTORY_CONDITIONS:
                return combine(history.getConditions());
            case DATA_BEHAVIOUR_MANAGEMENT:
                return combine(history.getBehaviour());
            case NOTES_MEDICAL_HISTORY:
                return history.getNotes();
            default:
                return null;
        }
    }

    /**
     *
     * @param outcome
     * @param field
     * @return
     */
    public String get(Outcome outcome, ParserMap.Field field) {
        switch (field) {
            case DATA_OUTCOME:
                return combine(outcome.getOutcomes());
            default:
                return null;
        }
    }

    /**
     *
     * @param trauma
     * @param field
     * @return
     */
    public String get(Trauma trauma, ParserMap.Field field) {
        switch (field) {
            case DATA_TRAUMA_TYPE:
                return trauma.getTraumaType();
            case DATA_TRAUMA:
                return combine(trauma.getTrauma());
            case NOTES_TRAUMA:
                return trauma.getNotes();
            default:
                return null;
        }
    }
}
