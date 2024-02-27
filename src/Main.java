import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        InstructorService instructorService=new InstructorService();
        CourseService courseService=new CourseService(instructorService);
        StudentService studentService=new StudentService(courseService);


        while (true) {
            System.out.println();
            System.out.println("--İŞLEM SEÇİNİZ--");
            System.out.println("1.  Ögrenci Ekle : ");
            System.out.println("2.  Eğitmen Ekle : ");
            System.out.println("3.  Kurs Ekle : ");
            System.out.println("4.  Ögrenciyi Kursa Ekle : ");
            System.out.println("5.  Ogrenci Listele : ");
            System.out.println("6.  Eğitmen Listele : ");
            System.out.println("7.  Öğrecinin kayıtlı kurslarını gir : ");
            System.out.println("8.  Kurs Listele : ");
            System.out.println("9.  Kurslarda kayıtlı öğrenciler : ");
            System.out.println("10. Eğitmen Güncelle : ");
            System.out.println("11. Kurs Güncelle : ");
            System.out.println("12. Eğitmenin verdiği kurslar : ");
            System.out.println("13. Öğrenci En Fazla Olan Kurs : ");
            System.out.println("14. Öğrenci Puanı Ata : ");
            System.out.println("15. Kurs Puanı Ortalama : ");
            System.out.println("16. Öğrenci Kurs Puanları  : ");
            System.out.println("17. Öğrenci Harf Notu Hesaplama : ");
            System.out.println("0.  Çıkış...");
            try {
                int chocee = scanner.nextInt();
                switch (chocee) {
                    case 1:
                        System.out.println("ID giriniz : ");
                        int studentId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("TC giriniz : ");
                        String studentTc = scanner.nextLine();
                        System.out.println("İsim :");
                        String studentName = scanner.nextLine();
                        System.out.println("Email : ");
                        String studentEmail = scanner.nextLine();
                        System.out.println("Şifre giriniz : ");
                        String studentPassword = scanner.nextLine();
                        studentService.createStudent(new Student(studentId, studentTc, studentName, studentEmail, studentPassword));
                        break;
                    case 2:
                        System.out.println("ID giriniz : ");
                        int instructorId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("İsim giriniz : ");
                        String instructorName = scanner.nextLine();
                        System.out.println("Email giriniz : ");
                        String instructorEmail = scanner.nextLine();
                        System.out.println("Şifre giriniz : ");
                        String instructorPassword = scanner.nextLine();
                        System.out.println("Yaş giriniz : ");
                        int instructorAge = scanner.nextInt();
                        scanner.nextLine();
                        instructorService.addInstructor(new Instructor(instructorId, instructorName, instructorEmail, instructorPassword, instructorAge));
                        break;
                    case 3:
                        System.out.println("ID giriniz : ");
                        int courseId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Kurs ismi giriniz : ");
                        String courseName = scanner.nextLine();
                        System.out.println("Konu giriniz : ");
                        String courseDesc = scanner.nextLine();
                        System.out.println("Kiredi mik. giriniz : ");
                        int courseCredi = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Eğitmen id : ");
                        int instructoId = scanner.nextInt();
                        scanner.nextLine();
                        Instructor ins = instructorService.getInstructorById(instructoId);
                        if (ins == null) {
                            System.out.println("Eğitmen bulunamadı...");
                            break;
                        } else {
                            courseService.addCourse(new Course(courseId, courseName, courseDesc, courseCredi, ins),instructoId);
                        }
                        break;
                    case 4:
                        System.out.println("Öğrenci ID giriniz : ");
                        int studentIdTO = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Kurs ID giriniz : ");
                        int courseIdTO = scanner.nextInt();
                        scanner.nextLine();
                        studentService.addStudentToCourse(studentIdTO, courseIdTO);
                        break;
                    case 5:
                        studentService.listAllStudents();
                        break;
                    case 6:
                        instructorService.allListInstructor();
                        break;
                    case 7:
                        System.out.println("Öğrenci ID giriniz : ");
                        int id4 = scanner.nextInt();
                        scanner.nextLine();
                        //studentService.reportStudentEnrolledCourses(id4);
                        studentService.getStudentEnrolledCourses(id4);
                        break;
                    case 8:
                        courseService.listAllCourses();
                        break;
                    case 9:
                        System.out.println("Kurs ID giriniz : ");
                        int getCourseId = scanner.nextInt();
                        courseService.getCourseEnrolledStudents(getCourseId);
                        break;
                    case 10:
                        System.out.println("Eğitmen ID : ");
                        int insId=scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Eğitmen isim : ");
                        String insname=scanner.nextLine();
                        System.out.println("Email : ");
                        String email=scanner.nextLine();
                        System.out.println("kurslar : ");
                        instructorService.updateInstructorDetails(insId,insname,email);
                        break;
                    case 11:
                        System.out.println("Kurs ID : ");
                        int updateCourseId=scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Kurs isim : ");
                        String updateCourseName=scanner.nextLine();
                        System.out.println("Konu : ");
                        String updateDesc=scanner.nextLine();
                        System.out.println("Kiredi : ");
                        int updateCredi=scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Kurs ID");
                        int updateInsID=scanner.nextInt();
                        scanner.nextLine();
                        Instructor instructo=instructorService.getInstructorById(updateInsID);
                        if (instructo == null){
                            System.out.println("Eğitmen bulunamadı...");
                        }
                        else {
                        courseService.updateCourse(updateCourseId,updateCourseName,updateDesc,updateCredi,instructo);
                        }
                        break;
                    case 12:
                        System.out.println("Eğitmen ID : ");
                        int viewInsId=scanner.nextInt();
                        instructorService.viewInstructorTaughtCourses(viewInsId);
                        break;
                    case 13:
                        courseService.findCourseWithMostParticipants();
                        break;
                    case 14:
                        System.out.println("Öğrenci ID : ");
                        int assignStudentId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Eğitmen ID : ");
                        int assignInstructorId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Öğrenci puanı : ");
                        double assignGrade = scanner.nextDouble();
                        studentService.assignGradeToStudent(assignStudentId,assignInstructorId,assignGrade);
                        break;
                    case 15:
                        System.out.println("Kurs ID : ");
                        int calculateCourseId = scanner.nextInt();
                        scanner.nextLine();
                        courseService.calculateAverageGradeForCourse(calculateCourseId);
                        break;
                    case 16:
                        System.out.println("Öğrenci ID : ");
                        int printStudentId = scanner.nextInt();
                        scanner.nextLine();
                        studentService.printStudentGrade(printStudentId);
                        break;
                    case 17:
                        System.out.println("Öğrenci ID : ");
                        int letterStudentId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Eğitmen ID : ");
                        int letterInstructorId = scanner.nextInt();
                        scanner.nextLine();
                        studentService.calculateLetterGradeForStudent(letterStudentId,letterInstructorId);
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Geçersiz işlem...");
                        break;
                }
            }
            catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Geçersiz işlem...");
            }
        }
    }
}
