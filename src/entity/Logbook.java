package entity;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    /**
     * Default constructor.
     */
    public Logbook() {
        // Initialise local objects.

        students = new ArrayList<>();
        patients = new ArrayList<>();
        visits = new ArrayList<>();
    }

    /** Students
     */
    /**
     * Add a student to the list.
     *
     * @param student
     * @return
     */
    public Boolean addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
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

    public void addVisit(Visit visit) {
        visits.add(visit);
    }
}
