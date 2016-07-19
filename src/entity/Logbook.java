package entity;

import config.StatsConfig;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class contains all necessary functionality to handle the
 * processing of student records, patient data and individual visits.
 *
 * Created by mladen on 08/07/16.
 */
public class Logbook {

    // List of all students.
    private ArrayList<Student> students;

    // List of all patients.
    private ArrayList<Patient> patients;

    // List of all visits.
    private ArrayList<Visit> visits;

    // Map relationships of students to patients.
    private HashMap<Student, ArrayList<Patient>> mapStudentToPatient;

    // Map relationships of student to visits.
    private HashMap<Student, ArrayList<Visit>> mapStudentToVisit;

    // Map relationships of patients to visits.
    private HashMap<Patient, ArrayList<Visit>> mapPatientToVisit;
    // Reciprocal of above map.
    private HashMap<Visit, Patient> mapVisitToPatient;

    /**
     * Default constructor.
     */
    public Logbook() {
        // Initialise local objects.
        students = new ArrayList<>();
        patients = new ArrayList<>();
        visits = new ArrayList<>();

        // Initialise the relationship maps.
        mapStudentToVisit = new HashMap<>();
        mapStudentToPatient = new HashMap<>();
    }

    /**
     ** Students
     */
    /**
     * Add a student to the list.
     *
     * @param student
     * @return
     */
    public Boolean addStudent(Student student) {
        // Check if the student is already registered.
        if (!students.contains(student)) {
            // Add the student to the list.
            students.add(student);

            // Initialise the maps for the given student.
            initialiseStudentToVisit(student);
            initialiseStudentToPatient(student);

            return true;
        }
        return false;
    }

    /**
     * Get a student at a given index of the list.
     *
     * @param index
     * @return
     */
    public Student getStudent(int index) {
        return students.get(index);
    }

    /**
     *
     * @return
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Lookup a student by username.
     *
     * @param username
     * @return
     */
    public Student findStudentByUsername(String username) {
        for (Student student : students) {
            if (student.getUsername().equals(username)) {
                return student;
            }
        }
        return null;
    }


    /**
     *
     * @param patient
     * @return
     */
    protected Boolean addPatient(Patient patient) {
        // Check if the patient is already registered.
        if (!patients.contains(patient)) {
            // Add the patient to the list.
            patients.add(patient);
            return true;
        }
        return false;
    }

    /**
     *
     * @param patient
     * @param student
     */
    protected void addPatient(Patient patient, Student student) {
        if (addPatient(patient)) {
            student.addPatient(patient);
            addStudentToPatient(student, patient);
        }
    }

    /**
     * Visits
     */

    /**
     *
     * @param visit
     */
    protected void addVisit(Visit visit) {
        visits.add(visit);
    }

    /**
     *
     * @param visit
     * @param student
     */
    protected void addVisit(Visit visit, Student student) {
        addVisit(visit);
        addStudentToVisit(student, visit);

        student.addVisit(visit);
    }

    /**
     * Records
     */

    /**
     *
     * @param student
     * @param visit
     */
    public void addRecord(Student student, Patient patient, Visit visit) {
        addStudent(student);

        // TODO: reference to local object.
        visit.setPatient(patient);

        Student localStudent = findStudentByUsername(student.getUsername());

        addPatient(patient, localStudent);
        addVisit(visit, localStudent);
    }

    /**
     ** Relationships
     */

    /**
     *
     * @param student
     */
    private void initialiseStudentToVisit(Student student) {
        mapStudentToVisit.put(student, new ArrayList<Visit>());
    }

    /**
     *
     * @param student
     */
    private void initialiseStudentToPatient(Student student) {
        mapStudentToPatient.put(student, new ArrayList<Patient>());
    }

    /**
     *
     * @param student
     * @param visit
     */
    protected void addStudentToVisit(Student student, Visit visit) {
        ArrayList<Visit> visits = mapStudentToVisit.get(student);
        visits.add(visit);

        mapStudentToVisit.put(student, visits);

        // Update local statistics
        student.statistics.increaseDescriptive(StatsConfig.Student.NUM_VISITS);
    }

    /**
     *
     * @param student
     * @param patient
     */
    protected void addStudentToPatient(Student student, Patient patient) {
        ArrayList<Patient> patients = mapStudentToPatient.get(student);
        patients.add(patient);

        mapStudentToPatient.put(student, patients);

        // Update local count of patients for Student.
        student.statistics.increaseDescriptive(StatsConfig.Student.NUM_PATIENTS);
    }
}
