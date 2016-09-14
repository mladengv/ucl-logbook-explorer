package data.export;

import data.ParserMap;
import entity.Patient;
import entity.Visit;
import entity.type.*;
import helper.StringHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by mladen on 19/07/16.
 */
public class ExporterMap {

    /**
     * Default constructor
     */
    public ExporterMap() {

    }

    private String combine(ArrayList<String> fields) {
        return StringHelper.combine(fields, "##");
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
            case NOTES_DIAGNOSIS:
                return StringHelper.enQuote(get(visit.getDiagnosis(), field));
            // Treatment fields
            case DATA_TREATMENT:
            case NOTES_TREATMENT:
                return StringHelper.enQuote(get(visit.getTreatment(), field));
            // History fields
            case DATA_MEDICAL_HISTORY:
            case DATA_MEDICAL_HISTORY_CONDITIONS:
            case DATA_BEHAVIOUR_MANAGEMENT:
            case NOTES_MEDICAL_HISTORY:
                return StringHelper.enQuote(get(visit.getHistory(), field));
            // Outcome fields
            case DATA_OUTCOME:
            case DATA_REFLECTION:
            case DATA_CUSTOM_1:
            case DATA_CUSTOM_2:
            case DATA_CUSTOM_3:
                return StringHelper.enQuote(get(visit.getOutcome(), field));
            // Trauma fields
            case DATA_TRAUMA_TYPE:
            case DATA_TRAUMA:
            case NOTES_TRAUMA:
                return StringHelper.enQuote(get(visit.getTrauma(), field));

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
            case NOTES_DIAGNOSIS:
                return diagnosis.getNotes();
            default:
                return null;
        }
    }

    public String get(Treatment treatment, ParserMap.Field field) {
        switch (field) {
            case DATA_TREATMENT:
                return combine(treatment.getTreatments());
            case NOTES_TREATMENT:
                return treatment.getNotes();
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
            case DATA_REFLECTION:
                return outcome.getReflection();
            case DATA_CUSTOM_1:
                return outcome.getCustom().get(0);
            case DATA_CUSTOM_2:
                return outcome.getCustom().get(1);
            case DATA_CUSTOM_3:
                return outcome.getCustom().get(2);
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
