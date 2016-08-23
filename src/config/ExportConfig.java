package config;

import data.ParserMap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mladen on 19/07/16.
 */
public class ExportConfig {

    /**
     * Map for fields.
     */
    public static HashMap<ParserMap.Field, String> exportMap
            = new HashMap<ParserMap.Field, String>() {
        {
            put(ParserMap.Field.GENERAL_USERNAME, "Username");
            put(ParserMap.Field.GENERAL_NAME, "User");
            put(ParserMap.Field.GENERAL_EMAIL, "Email address");

            put(ParserMap.Field.PATIENT_IDENTIFIER, "Patient_Identifier");
            put(ParserMap.Field.PATIENT_BIRTHDAY, "Patient_BirthDate");
            put(ParserMap.Field.PATIENT_GENDER, "Patient_Gender");

            put(ParserMap.Field.APPOINTMENT_DATE, "Appointment_Date");
            put(ParserMap.Field.APPOINTMENT_TYPE, "Appointment_Type");

            put(ParserMap.Field.DATA_MEDICAL_HISTORY, "Data_Medical_History");
            put(ParserMap.Field.DATA_MEDICAL_HISTORY_CONDITIONS, "Data_Medical_Conditions");

            put(ParserMap.Field.DATA_BEHAVIOUR_MANAGEMENT, "Data_Behaviour_Management");

            put(ParserMap.Field.DATA_DIAGNOSIS, "Data_Diagnosis");
            put(ParserMap.Field.DATA_TREATMENT, "Data_Treatment");

            put(ParserMap.Field.DATA_TRAUMA, "Data_Trauma");
            put(ParserMap.Field.DATA_TRAUMA_TYPE, "Data_Trauma_Type");

            put(ParserMap.Field.DATA_REFLECTION, "Data_Reflection");
            put(ParserMap.Field.DATA_OUTCOME, "Data_Outcome");
            put(ParserMap.Field.DATA_CUSTOM_1, "Data_Custom_1");
            put(ParserMap.Field.DATA_CUSTOM_2, "Data_Custom_2");
            put(ParserMap.Field.DATA_CUSTOM_3, "Data_Custom_3");

            put(ParserMap.Field.NOTES_MEDICAL_HISTORY, "Notes_Medical_History");
            put(ParserMap.Field.NOTES_DIAGNOSIS, "Notes_Diagnosis");
            put(ParserMap.Field.NOTES_TREATMENT, "Notes_Treatment");
            put(ParserMap.Field.NOTES_TRAUMA, "Notes_Trauma");
        }
    };

    /**
     * Map for exporting a visit.
     */
    public static ArrayList<ParserMap.Field> visitMap
            = new ArrayList<ParserMap.Field>() {
        {
            add(ParserMap.Field.PATIENT_IDENTIFIER);
            add(ParserMap.Field.PATIENT_BIRTHDAY);
            add(ParserMap.Field.PATIENT_GENDER);
            add(ParserMap.Field.APPOINTMENT_TYPE);
            add(ParserMap.Field.APPOINTMENT_DATE);

            add(ParserMap.Field.DATA_MEDICAL_HISTORY);
            add(ParserMap.Field.DATA_MEDICAL_HISTORY_CONDITIONS);
            add(ParserMap.Field.DATA_BEHAVIOUR_MANAGEMENT);

            add(ParserMap.Field.DATA_DIAGNOSIS);
            add(ParserMap.Field.DATA_TREATMENT);
            add(ParserMap.Field.DATA_TRAUMA_TYPE);
            add(ParserMap.Field.DATA_TRAUMA);
            add(ParserMap.Field.DATA_OUTCOME);
        }
    };
}
