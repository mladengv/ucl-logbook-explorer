package entity;

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

    /**
     * Default constructor.
     */
    public Student() {

    }

    /**
     *
     * @param username
     * @param name
     * @param email
     */
    public Student(String username, String name, String email) {
        setUsername(username);
        setName(name);
        setEmail(email);
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
