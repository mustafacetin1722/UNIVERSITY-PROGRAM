import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private List<Course> courseList;
    private InstructorService instructorService;

    public CourseService(InstructorService instructorService) {
        this.courseList = new ArrayList<>();
        this.instructorService = instructorService;
    }

    public void addCourse(Course course, int instructorId) {
        if (course != null && !course.getCourseName().isEmpty() && course.getId() > 0 && course.getCredits() > 0
                && !course.getCourseDescription().isEmpty()) {
            courseList.add(course);
            Instructor instructor = instructorService.getInstructorById(instructorId);
            instructor.getTaughtCourses().add(course);
            System.out.println("Kurs başarılı bir şekilde listeye eklenmiştir");
        } else {
            System.out.println("Boş alanları doldurunuz");
        }
    }

    public void findCourseWithMostParticipants() {
        Course courseExists = null;
        int maxCoursePartici = 0;
        for (Course course : courseList) {
            int coursePartici = course.getEnrolledStudents().size();
            if (coursePartici > maxCoursePartici) {
                maxCoursePartici = coursePartici;
                courseExists = course;
            }
        }
        if (courseExists != null) {
            System.out.println("En çok katılımcısı olan kurs: " + courseExists.getCourseName());
            System.out.println("Katılımcı sayısı: " + maxCoursePartici);
        } else {
            System.out.println("Sistemde hiç kurs kayıtlı değil.");
        }
    }


    public void updateCourse(int courseId, String newCourseName, String newCourseDescription, int newCredits, Instructor instructor) {
        Boolean courseFound = false;
        if (newCourseName.isEmpty() || newCourseDescription.isEmpty() || newCredits <= 0 || instructor == null) {
            System.out.println("Bütün Boşlukları Doldurunuz.");
            courseFound = true;
        } else {
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
        }
        if (!courseFound) {
            System.out.println("Girilen " + courseId + " Numaralı ID'de Kurs Bulunmamaktadır.");
        }
    }

    public void getCourseEnrolledStudents(int courseId) {
        boolean courseFound = false;
        for (Course course : courseList) {
            if (course.getId() == courseId) {
                courseFound = true;
                List<Student> enrolledStudents = course.getEnrolledStudents();
                if (!enrolledStudents.isEmpty()) {
                    for (Student student : enrolledStudents) {
                        System.out.println("Kursa Kayıtlı Öğrenci İsmi : " + student.getFullName());
                        System.out.println("Email : " + student.getEmail());
                    }
                } else {
                    System.out.println("Kursa Kayıtlı Öğrenci Bulunmamaktadır.");
                }
            }
        }
        if (!courseFound) {
            System.out.println("Girilen " + courseId + " Numaralı ID'de Kurs Bulunmamaktadır.");
        }
    }

    public Course getCourseById(int courseId) {
        for (Course course : courseList) {
            if (course.getId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public List<Course> listAllCourses() {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Kurs ID", "Kurs Adı", "Kurs Açıklaması", "Kredi", "Eğitmen İsmi", "Başlangıç Saati");
        System.out.println("-------------------------------------------------------------------------------------------------");

        for (Course course : courseList) {
            String instructorName = course.getInstructor().getFullName();
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n",
                    course.getId(), course.getCourseName(), course.getCourseDescription(),
                    course.getCredits(), instructorName, course.getStartingTime());
        }
        return courseList;
    }

    public double calculateAverageGradeForCourse(int courseId) {
        double totalGrade = 0.0;
        int totalStudents = 0;

        Course targetCourse = getCourseById(courseId);

        if (targetCourse != null) {
            List<Course> courses =new ArrayList<>();
            for (Student student : targetCourse.getEnrolledStudents()) {
                courses= student.getEnrolledCourses();
            }if (courses!=null){
                for (Course course : courses ){
                    totalGrade+=course.getGrade();
                    totalStudents++;
            }
                double averageGrade = totalGrade / totalStudents;
                System.out.println("Kurs Adı: " + targetCourse.getCourseName());
                System.out.println("puanı : "+averageGrade);
                return averageGrade;
            } else {
                System.out.println("Kursa kayıtlı öğrenci bulunmamaktadır.");
                return 0.0;
            }
        } else {
            System.out.println("Belirtilen kurs bulunamadı.");
            return 0.0;
        }
    }
}
