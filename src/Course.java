import java.util.*;

public class Course {

    private int id;
    private String courseName;
    private String courseDescription;
    private int credits;
    private double averageGrade;
    private Date startingTime;
    private List<Student> enrolledStudents;
    private Instructor instructor;
    private Map<Integer , Double> studentGrades;


    public Course(int id, String courseName, String courseDescription, int credits, Instructor instructor) {
        this.id = id;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.credits = credits;
        this.startingTime = new Date();
        this.enrolledStudents = new ArrayList<>();
        this.instructor = instructor;
        this.averageGrade = averageGrade;
        this.studentGrades = new HashMap<>();
    }

    public Map<Integer, Double> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(Map<Integer, Double> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
