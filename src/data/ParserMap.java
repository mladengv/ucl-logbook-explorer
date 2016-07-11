package data;

import config.ParserConfig;

import java.util.HashMap;

/**
 * Created by mladen on 08/07/16.
 */
public class ParserMap  {

    public enum Field {
        GENERAL_USERNAME,
        GENERAL_NAME,
        GENERAL_EMAIL,

        PATIENT_IDENTIFIER,
        PATIENT_BIRTHDAY,
        PATIENT_GENDER,

        APPOINTMENT_DATE,
        APPOINTMENT_TYPE,

        DATA_MEDICAL_HISTORY,
        DATA_MEDICAL_HISTORY_CONDITIONS,

        DATA_BEHAVIOUR_MANAGEMENT,

        DATA_DIAGNOSIS,
        DATA_TREATMENT,
        DATA_TRAUMA,
        DATA_TRAUMA_TYPE,
        DATA_REFLECTION,
        DATA_OUTCOME,
        DATA_CUSTOM_1,
        DATA_CUSTOM_2,
        DATA_CUSTOM_3,

        NOTES_MEDICAL_HISTORY,
        NOTES_DIAGNOSIS,
        NOTES_TREATMENT,
        NOTES_TRAUMA,
    }

    private HashMap<String, Integer> map;

    public ParserMap() {
        map = new HashMap<>();
    }

    public void populate(String[] map) {
        int count = 0;
        for (String entry : map) {
            this.map.put(entry, count++);
        }
    }

    public int get(Field field) {
        return this.map.get(ParserConfig.fieldsMap.get(field));
    }

    public int size() {
        return map.size();
    }
}
