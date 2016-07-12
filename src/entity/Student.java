package entity;

import config.StatsConfig;
import helper.Statistics;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mladen on 08/07/16.
 */
public class Student
        implements Comparable<Student> {

    // Username of the student.
    private String username;
    // Their name.
    private String name;
    // Their email.
    private String email;

    // Local list of patients.
    private ArrayList<Patient> patients;
    // Local list of visits.
    private ArrayList<Visit> visits;
    // Local statistics.
    public Statistics statistics;


    public HashMap<String, Statistics> occurrenceStats;

    /**
     * Default constructor.
     */
    public Student() {

        patients = new ArrayList<>();
        visits = new ArrayList<>();

        statistics = new Statistics();

        initialise();
    }

    /**
     *
     * @param username
     * @param name
     * @param email
     */
    public Student(String username, String name, String email) {
        this();

        setUsername(username);
        setName(name);
        setEmail(email);
    }

    public void initialise() {
        occurrenceStats = new HashMap<>();
        occurrenceStats.put(StatsConfig.Count.COUNT_GENDER, new Statistics());
        occurrenceStats.put(StatsConfig.Count.COUNT_HISTORY_CONDITIONS, new Statistics());
        occurrenceStats.put(StatsConfig.Count.COUNT_BEHAVIOUR_MANAGEMENT, new Statistics());
        occurrenceStats.put(StatsConfig.Count.COUNT_DIAGNOSES, new Statistics());
        occurrenceStats.put(StatsConfig.Count.COUNT_TREATMENTS, new Statistics());
        occurrenceStats.put(StatsConfig.Count.COUNT_OUTCOMES, new Statistics());
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param patient
     */
    public void addPatient(Patient patient) {
        patients.add(patient);

        // Update statistics.
        updateStats(patient);
    }

    /**
     *
     * @return
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     ** Visits
     */
    /**
     *
     * @param visit
     */
    public void addVisit(Visit visit) {
        // Add the visit to the list.
        visits.add(visit);
        // Update statistics.
        updateStats(visit);
    }

    /**
     *
     * @return
     */
    public ArrayList<Visit> getVisits() {
        return visits;
    }


    private void updateStats(Visit visit) {
        occurrenceStats.get(
                StatsConfig.Count.COUNT_HISTORY_CONDITIONS
        ).increaseCount(visit.getHistory().getConditions());
        occurrenceStats.get(
                StatsConfig.Count.COUNT_BEHAVIOUR_MANAGEMENT
        ).increaseCount(visit.getHistory().getBehaviour());
        occurrenceStats.get(
                StatsConfig.Count.COUNT_DIAGNOSES
        ).increaseCount(visit.getDiagnosis().getDiagnoses());
        occurrenceStats.get(
                StatsConfig.Count.COUNT_TREATMENTS
        ).increaseCount(visit.getTreatment().getTreatments());
        occurrenceStats.get(
                StatsConfig.Count.COUNT_OUTCOMES
        ).increaseCount(visit.getOutcome().getOUtcomes());
    }

    private void updateStats(Patient patient) {
        occurrenceStats.get(
                StatsConfig.Count.COUNT_GENDER
        ).increaseCount(patient.getGender());
    }

    /**
     * Comparison for students.
     *
     * @param object
     * @return <tt>True</tt>, if the students have the same username.
     *         <tt>False</tt> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // Check if we are able to compare.
        if (object != null && object instanceof Student) {
            return username.equals(((Student)object).getUsername());
        }
        return false;
    }

    public int compareTo(Student student) {
        return 0;
    }
}
