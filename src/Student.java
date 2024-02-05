import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Student {

    private int id;
    private String identityNumber;
    private String fullName;
    private String email;
    private String password;
    private List<Course> enrolledCourses;

    public Student(int id, String identityNumber, String fullName, String email, String password) {
        this.id = id;
        this.identityNumber = identityNumber;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.enrolledCourses = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
