package data;

import entity.Patient;
import entity.Student;
import entity.Visit;
import entity.type.*;
import helper.StringHelper;

import java.io.IOException;

/**
 * Created by mladen on 08/07/16.
 */
public class ParserSchema {

    // Local copy of the map.
    private ParserMap map;

    /**
     * Default constructor.
     */
    public ParserSchema() {

    }

    /**
     *
     * @param map
     */
    public void setMap(ParserMap map) {
        this.map = map;
    }

    public String obtainPlain(ParserMap map, ParserMap.Field field, String[] fields) {
        try {
            return fields[map.get(field)];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param map
     * @param field
     * @param fields
     * @return
     */
    public String obtain(ParserMap map, ParserMap.Field field, String[] fields) {
        return StringHelper.deQuote(obtainPlain(map, field, fields));
    }



    /**
     *
     * @param field
     * @param fields
     * @return
     */
    public String[] obtainArray(ParserMap map, ParserMap.Field field, String[] fields) {
        return obtain(map, field, fields).split("##");
    }

    /**
     *
     * @param fields
     * @return
     */
    public Student createStudent(String[] fields) {
        return new Student(
                obtain(map, ParserMap.Field.GENERAL_USERNAME, fields),
                obtain(map, ParserMap.Field.GENERAL_NAME, fields),
                obtain(map, ParserMap.Field.GENERAL_EMAIL, fields)
        );
    }

    /**
     *
     * @param fields
     * @return
     */
    public Patient createPatient(String[] fields) {
        return new Patient(
                obtain(map, ParserMap.Field.PATIENT_IDENTIFIER, fields),
                obtain(map, ParserMap.Field.PATIENT_BIRTHDAY, fields),
                obtain(map, ParserMap.Field.PATIENT_GENDER, fields)
        );
    }

    /**
     *
     * @param fields
     * @return
     */
    public Diagnosis createDiagnosis(String[] fields) {
        return new Diagnosis(
                obtainArray(map, ParserMap.Field.DATA_DIAGNOSIS, fields)
        );
    }

    public Trauma createTrauma(String[] fields) {
        return new Trauma(
                obtain(map, ParserMap.Field.DATA_TRAUMA_TYPE, fields),
                obtainArray(map, ParserMap.Field.DATA_TRAUMA, fields)
        );
    }
    /**
     *
     * @param fields
     * @return
     */
    public History createHistory(String[] fields) {
        return new History(
                obtain(map, ParserMap.Field.DATA_MEDICAL_HISTORY, fields),
                obtainArray(map, ParserMap.Field.DATA_MEDICAL_HISTORY_CONDITIONS, fields),
                obtainArray(map, ParserMap.Field.DATA_BEHAVIOUR_MANAGEMENT, fields),
                obtainPlain(map, ParserMap.Field.NOTES_MEDICAL_HISTORY, fields)
        );
    }

    /**
     *
     * @param fields
     * @return
     */
    public Treatment createTreatment(String[] fields) {
        return new Treatment(
                obtainArray(map, ParserMap.Field.DATA_TREATMENT, fields)
        );
    }

    /**
     *
     * @param fields
     * @return
     */
    public Outcome createOutcome(String[] fields) {
        return new Outcome(
                obtainArray(map, ParserMap.Field.DATA_OUTCOME, fields)
        );
    }

    /**
     *
     * @param fields
     * @return
     */
    public Visit createVisit(String[] fields) {
        return new Visit(
                obtain(map, ParserMap.Field.APPOINTMENT_TYPE, fields),
                obtain(map, ParserMap.Field.APPOINTMENT_DATE, fields),
                createHistory(fields),
                createDiagnosis(fields),
                createTrauma(fields),
                createTreatment(fields),
                createOutcome(fields)
        );
    }
}
