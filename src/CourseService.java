import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private List<Course> courseList;

    public CourseService() {
        this.courseList = new ArrayList<>();
    }

    public void addCourse(Course course){
        if (course!=null && course.getCourseName()!= null && course.getId()>0 && course.getCredits()>0
                && course.getCourseDescription()!="") {
            courseList.add(course);
        }
        else {
            System.out.println("Boş alanları doldurunuz");
        }
    }


    public void updateCourse(int courseId, String newCourseName, String newCourseDescription, int newCredits, Instructor instructor) {
        Boolean courseFound = false;
        for (Course course1 : courseList) {
            if (course1.getId() == courseId) {
                course1.setInstructor(instructor);
                course1.setCourseName(newCourseName);
                course1.setCourseDescription(newCourseDescription);
                course1.setCredits(newCredits);
                courseFound = true;
                break;
            }
        }
        if (!courseFound) {
            System.out.println("Girilen " + courseId + " Numaralı ID'de Kurs Bulunmamaktadır.");
        }
    }

    public void getCourseEnrolledStudents(int courseId) {
        Boolean courseFound = false;
        for (Course course : courseList) {
            if (course.getId() == courseId) {
                courseFound = true;
                List<Student> enrolledStudents = course.getStudentName();
                if (!enrolledStudents.isEmpty()) {
                    for (Student student : enrolledStudents) {
                        System.out.println("Kursa Kayıtlı Öğrenci İsmi : " + student.getFullName());
                        System.out.println("Email : " + student.getEmail());
                    }
                }else {
                    System.out.println("Kursa Kayıtlı Öğrenci Bulunmamaktadır.");
                }
            }
        break;}
        if (!courseFound){
            System.out.println("Girilen " + courseId + " Numaralı ID'de Kurs Bulunmamaktadır.");
        }
    }
    public Course getCourseById(int courseId) {
        for (Course course : courseList) {
            if (course.getId()==courseId) {
                return course;
            }
        }
        return null;
    }
    public List<Course> listAllCourses() {
        System.out.printf("%-15s %-20s %-15s %-25s %-15s\n", "Kurs ID", "Kurs Adı", "Kurs Açıklaması", "Kredi", "Başlangıç Saati");
        System.out.println("-------------------------------------------------------------------------------------------------");

        for (Course course : courseList) {
            System.out.printf("%-15s %-20s %-15s %-25s %-15s\n",
                    course.getId(), course.getCourseName(), course.getCourseDescription(),
                    course.getCredits(), course.getStartingTime());
        }
        return courseList;
    }

}
