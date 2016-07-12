package config;

import data.ParserMap;

import java.util.HashMap;

/**
 * Created by mladen on 08/07/16.
 */
public class ParserConfig {

    // Format for the dates.
    public static String DATE_FORMAT = "E d MMMM yyyy";

    // Map of fields to strings.
    public static HashMap<ParserMap.Field, String> fieldsMap
            = new HashMap<ParserMap.Field,String>() {
        {
            put(ParserMap.Field.GENERAL_USERNAME, "Username");
            put(ParserMap.Field.GENERAL_NAME, "User");
            put(ParserMap.Field.GENERAL_EMAIL, "Email address");

            put(ParserMap.Field.PATIENT_IDENTIFIER, "General_PatientIdentifier");
            put(ParserMap.Field.PATIENT_BIRTHDAY, "Data_General_BirthDate");
            put(ParserMap.Field.PATIENT_GENDER, "General_Gender");

            put(ParserMap.Field.APPOINTMENT_DATE, "General_AppointmentDate");
            put(ParserMap.Field.APPOINTMENT_TYPE, "General_AppointmentType");

            put(ParserMap.Field.DATA_MEDICAL_HISTORY, "Data_MH");
            put(ParserMap.Field.DATA_MEDICAL_HISTORY_CONDITIONS, "Data_MH_MedicalConditions");

            put(ParserMap.Field.DATA_BEHAVIOUR_MANAGEMENT, "Data_BehaviourManagement");

            put(ParserMap.Field.DATA_DIAGNOSIS, "Data_Diagnosis");
            put(ParserMap.Field.DATA_TREATMENT, "Data_Treatment");
            put(ParserMap.Field.DATA_TRAUMA, "Data_Trauma");
            put(ParserMap.Field.DATA_TRAUMA_TYPE, "Data_Trauma_Type");
            put(ParserMap.Field.DATA_REFLECTION, "Data_Reflection");
            put(ParserMap.Field.DATA_OUTCOME, "Data_Outcome");
            put(ParserMap.Field.DATA_CUSTOM_1, "Data_Custom_1");
            put(ParserMap.Field.DATA_CUSTOM_2, "Data_Custom_2");
            put(ParserMap.Field.DATA_CUSTOM_3, "Data_Custom_3");

            put(ParserMap.Field.NOTES_MEDICAL_HISTORY, "Notes_MedicalHistory");
            put(ParserMap.Field.NOTES_DIAGNOSIS, "Notes_Diagnosis");
            put(ParserMap.Field.NOTES_TREATMENT, "Notes_Treatment");
            put(ParserMap.Field.NOTES_TRAUMA, "Notes_Trauma");
        }
    };
}
