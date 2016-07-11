package entity;

import config.StatsConfig;

import java.lang.reflect.Array;
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
        if (!students.contains(student)) {
            // Add the student to the list.
            students.add(student);
            // Initialise the student's maps.
            initialiseStudentToVisit(student);

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
     * Records
     */

    /**
     *
     * @param student
     * @param visit
     */
    public void addRecord(Student student, Visit visit) {
        addStudent(student);
        addVisit(visit);

        Student localStudent = findStudentByUsername(student.getUsername());

        // Create relationships
        addStudentToVisit(localStudent, visit);

        // Update local statistics
        localStudent.statistics.increaseDescriptive(StatsConfig.Student.NUM_VISITS);
    }

    /**
     ** Relationships
     */

    /**
     *
     * @param student
     */
    protected void initialiseStudentToVisit(Student student) {
        mapStudentToVisit.put(student, new ArrayList<Visit>());
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

    }
}
