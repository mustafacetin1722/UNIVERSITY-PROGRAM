import java.util.ArrayList;
import java.util.List;

public class InstructorService {
    private List<Instructor> instructorList;

    public InstructorService() {
        this.instructorList = new ArrayList<>();
    }

    public void addInstructor(Instructor instructor){
        if (instructor!=null && instructor.getFullName()!= null && instructor.getId()>0) {
            instructorList.add(instructor);
            System.out.println("Eğitmen başarılı bir şekilde listeye eklenmiştir");
        }
        else {
            System.out.println("Boş alanları doldurunuz");
        }
    }
    public void viewInstructorTaughtCourses(int instructorNumber) {
        boolean instructorFound = false;
        for (Instructor instructor : instructorList){
            if (instructor.getId()==instructorNumber){
                for (Course course : instructor.getTaughtCourses()) {
                    System.out.println("Kurs : " + course.getCourseName());
                }
                instructorFound = true;
                break;
            }
        }
        if (!instructorFound){
            System.out.println("Girilen " + instructorNumber + " Numaralı ID'de Eğitmen Bulunmamaktadır.");
        }
    }
    public List<Instructor> allListInstructor(){
        System.out.printf("%-15s %-20s %-15s %-25s %-15s\n", "Eğitmen ID", "Eğitmen Adı", "Eğitmen Email", "Eğitmen Şifresi", "Eğitmen Yaş");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (Instructor instructor:instructorList){
            System.out.printf("%-15s %-20s %-15s %-25s %-15s\n",
                    instructor.getId(), instructor.getFullName(), instructor.getEmail(),
                    instructor.getPassword(), instructor.getAge());
        }
        return instructorList;
    }
    public void updateInstructorDetails(int instructorNumber, String newFullName, String newEmail) {
        boolean instructorFound = false;
        for (Instructor instructor:instructorList){
            if (instructor.getId()==instructorNumber){
                instructorFound = true;
                instructor.setFullName(newFullName);
                instructor.setEmail(newEmail);
                System.out.println("Eğitmen başarıyla güncellendi: " + newFullName);
                break;
            }
        }
        if (!instructorFound){
            System.out.println("Girilen " + instructorNumber + " Numaralı ID'de Eğitmen Bulunmamaktadır.");
        }

    }
    public Instructor getInstructorById(int id){
        for (Instructor instructor:instructorList){
            if (instructor.getId()==id){
                return instructor;
            }
        }
        return null;
    }

}
