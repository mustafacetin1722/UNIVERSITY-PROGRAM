import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> studentList;
    private CourseService courseService;



    public StudentService(CourseService courseService) {
        this.studentList = new ArrayList<>();
        this.courseService = courseService;
    }

    public void createStudent(Student student) {
        if (student!=null && !student.getFullName().isEmpty() && !student.getEmail().isEmpty()
                && !student.getIdentityNumber().isEmpty() && !student.getPassword().isEmpty()){
            studentList.add(student);
            System.out.println("Öğrenci başarılı bir şekilde listeye eklenmiştir");
        }else {
            System.out.println("Eksik bilgi girdiniz lütfen bütün boşlukları doldurunuz.");
        }
    }
    public void addStudentToCourse(int studentId, int courseId) {
        Student student = getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);
        if (student != null && course != null) {
            course.getEnrolledStudents().add(student);
            student.getEnrolledCourses().add(course);
            System.out.println("Öğrenci " + student.getFullName() + " kursa eklendi " + course.getCourseName());
        } else {
            System.out.println("Öğrenci veya Kurs Bulunamadı.");
        }
    }


    public void updateStudentDetails(int id,String newIdentityNumber,String newFullName, String newEmail,String newPasword){
        boolean studentFound = false;
        for (Student student:studentList){
            if (student.getId()==id){
                student.setFullName(newFullName);
                student.setIdentityNumber(newIdentityNumber);
                student.setEmail(newEmail);
                student.setPassword(newPasword);
            }
        }
        if (!studentFound){
            System.out.println("Girilen " + id + " Numaralı ID'de Öğrenci Bulunmamaktadır.");
        }
    }

    public void reportStudentEnrolledCourses(int stundentNumber){
        List<Course> courses = new ArrayList<>();
        for (Student student:studentList){
            if (student.getId() == stundentNumber){
                courses= student.getEnrolledCourses();
                break;
                }
            }
        if (!courses.isEmpty()){
            for (Course course : courses){
                System.out.println("Kurs: "+course.getCourseName());
            }
        }
        else {
            System.out.println("Girilen " + stundentNumber + " Numaralı ID'de Öğrenci Bulunmamaktadır.");
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
    public String calculateLetterGradeForStudent(int studentId , int courseId){
       for (Student student: studentList){
           if (student.getId()==studentId){
               for (Course course : student.getEnrolledCourses()){
                   if (course.getId()==courseId){
                       System.out.println("Alığı Ders : "+course.getCourseName());
                       System.out.println("Ortalama Puan : " + course.getGrade());
                       System.out.println("Harf Notu : "+calculateLetterGrade(course.getGrade()));
                   }
               }
           }
       }
       return "Öğrenci veya Kurs Bulunamadı.";
    }
    private String calculateLetterGrade(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
