import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> studentList;
    private CourseService courseService;

    public StudentService() {
        this.studentList = new ArrayList<>();
    }

    public StudentService(CourseService courseService) {
        this.studentList = new ArrayList<>();
        this.courseService = courseService;
    }

    public void createStudent(Student student) {
        if (student!=null && !student.getFullName().isEmpty() && !student.getEmail().isEmpty()
                && !student.getIdentityNumber().isEmpty() && !student.getPassword().isEmpty()){
            studentList.add(student);
        }else {
            System.out.println("Eksik bilgi girdiniz lütfen bütün boşlukları doldurunuz.");
        }
    }
    public void addStudentToCourse(int studentId, int courseId) {
        Student student = getStudentById(studentId);
        CourseService courseService = new CourseService();
        Course course = courseService.getCourseById(courseId);
        if (student != null && course != null) {
            course.getStudentName().add(student);
            student.getEnrolledCourses().add(course);
            System.out.println("Öğrenci " + student.getFullName() + " kursa eklendi " + course.getCourseName());
        } else {
            System.out.println("Öğrenci veya Kurs Bulunamadı.");
        }
    }
  /*  public void addStudentToCourse(int studentId, int courseId) {
        Student student = getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);
        if (student != null && course != null) {
            if (course.getStudentName() == null) {
                course.setStudentName(new ArrayList<>());
            }
            if (student.getEnrolledCourses() == null) {
                student.setEnrolledCourses(new ArrayList<>());
            }
            course.getStudentName().add(student);
            student.getEnrolledCourses().add(course);
            System.out.println("Öğrenci " + student.getFullName() + " kursa eklendi " + course.getCourseName());
        } else {
            System.out.println("Öğrenci veya Kurs Bulunamadı.");
        }
    }*/

    public void updateStudentDetails1(int id,String newIdentityNumber,String newFullName,
                                     String newEmail,String newPssword,List<Course> newEnrolledCourses){
        boolean studentFound = false;
        for (Student student:studentList){
            if (student.getId()==id){
                student.setFullName(newFullName);
                student.setIdentityNumber(newIdentityNumber);
                student.setEmail(newEmail);
                student.setPassword(newPssword);
                student.setEnrolledCourses(newEnrolledCourses);
            }
        }
        if (!studentFound){
            System.out.println("Girilen " + id + " Numaralı ID'de Öğrenci Bulunmamaktadır.");
        }
    }
    public void updateStudentDetails(int id, Student student) {
        for (Student updateStudent:studentList){
            if (updateStudent.getId()==id){
                updateStudent.setFullName(student.getFullName());
            }
        }
    }
    public void studentCourse(int id){
        boolean studentFound=false;
        for (Student student:studentList){
            if (student.getId()==id){
                for (Course course:student.getEnrolledCourses()){
                    System.out.println(course.getCourseName()+"var");
                }
                studentFound=true;
                break;
            }
        }
        if (!studentFound){
            System.out.println("Öğrenci bulunamadı.");
        }
    }
    public List<Student> listAllStudents(){
        System.out.printf("%-15s %-20s %-15s %-25s %-15s\n", "Öğrenci ID", "Öğrenci Adı", "Öğrenci TCNo", "Öğrenci Email", "Öğrenci Şifresi");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (Student student:studentList){
            System.out.printf("%-15s %-20s %-15s %-25s %-15s\n",
                    student.getId(), student.getFullName(), student.getIdentityNumber(),
                    student.getEmail(), student.getPassword());
        }
        return studentList;
    }




    public Student getStudentById(int studentId) {
        for (Student student : studentList) {
            if (student.getId()==studentId) {
                return student;
            }
        }
        return null;
    }
}
