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
        }
        else {
            System.out.println("Boş alanları doldurunuz");
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
    public void updateInstructorDetails(int instructorNumber, String newFullName, String newEmail, List<Course> newTaughtCourses) {
        boolean instructorFound = false;
        for (Instructor instructor:instructorList){
            if (instructor.getId()==instructorNumber){
                instructorFound = true;
                instructor.setFullName(newFullName);
                instructor.setEmail(newEmail);
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
