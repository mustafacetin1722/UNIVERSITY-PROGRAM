import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StudentService studentService=new StudentService();
        InstructorService instructorService=new InstructorService();
        CourseService courseService=new CourseService();


        while (true){
            System.out.println("1. Ögrenci Ekle : ");
            System.out.println("2. Eğitmen Ekle : ");
            System.out.println("3. Kurs Ekle : ");
            System.out.println("4. Ögrenciyi Kursa Ekle : ");
            System.out.println("5. Ogrenci Listele : ");
            System.out.println("6. Eğitmen Listele : ");
            System.out.println("7. Öğrecinin kayıtlı kurslarını gir : ");
            System.out.println("8. Kurs Listele : ");
            int chocee=scanner.nextInt();
            switch (chocee){
                case 1:
                    System.out.println("ID giriniz : ");
                    int studentId=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("TC giriniz : ");
                    String studentTc=scanner.nextLine();
                    System.out.println("İsim :");
                    String studentName=scanner.nextLine();
                    System.out.println("Email : ");
                    String studentEmail=scanner.nextLine();
                    System.out.println("Şifre giriniz : ");
                    String studentPassword=scanner.nextLine();
                    studentService.createStudent(new Student(studentId,studentTc,studentName,studentEmail,studentPassword));
                    break;
                case 2:
                    System.out.println("ID giriniz : ");
                    int instructorId=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("İsim giriniz : ");
                    String instructorName=scanner.nextLine();
                    System.out.println("Email giriniz : ");
                    String instructorEmail=scanner.nextLine();
                    System.out.println("Şifre giriniz : ");
                    String instructorPassword=scanner.nextLine();
                    System.out.println("Yaş giriniz : ");
                    int instructorAge=scanner.nextInt();
                    scanner.nextLine();
                    instructorService.addInstructor(new Instructor(instructorId,instructorName,instructorEmail,instructorPassword,instructorAge));
                    break;
                case 3:
                    System.out.println("ID giriniz : ");
                    int courseId=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Kurs ismi giriniz : ");
                    String courseName=scanner.nextLine();
                    System.out.println("Konu giriniz : ");
                    String courseDesc=scanner.nextLine();
                    System.out.println("Kiredi mik. giriniz : ");
                    int courseCredi=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Eğitmen id : ");
                    int intructorId= scanner.nextInt();
                    scanner.nextLine();
                    Instructor ins=instructorService.getInstructorById(intructorId);
                    if (ins==null){
                        System.out.println("Eğitmen bulunamadı...");
                        break;
                    }else {
                        courseService.addCourse(new Course(courseId,courseName,courseDesc,courseCredi,ins));
                    }
                    break;
                case 4:
                    System.out.println("Öğrenci ID giriniz");
                    int studentIdTO=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Kurs ID giriniz.");
                    int courseIdTO=scanner.nextInt();
                    scanner.nextLine();
                    studentService.addStudentToCourse(studentIdTO,courseIdTO);
                    break;
                case 5:
                    studentService.listAllStudents();
                    break;
                case 6:
                    instructorService.allListInstructor();
                    break;
                case 7:
                    System.out.println("Öğrenci ID giriniz : ");
                    int id4= scanner.nextInt();
                    scanner.nextLine();
                    studentService.studentCourse(id4);
                    break;
                case 8:
                    courseService.listAllCourses();
                    break;
                default:
                    System.out.println("Geçersiz işlem...");
                    break;
            }
        }
    }
}
