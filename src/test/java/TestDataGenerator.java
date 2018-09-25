import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {

    public static List<Student> generateStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("John", "Doe", 12345, "jdoe@sdsu.edu", 4.0, 40));
        students.add(new Student("Jane", "Dawn", 23456, "jdowe@sdsu.edu", 3.2, 50));
        students.add(new Student("Adam", "Smith", 34567, "asmith@sdsu.edu", 2.2, 100));
        students.add(new Student("Ben", "Stevens", 45678, "bstevens@sdsu.edu", 3.5, 60));
        students.add(new Student("Steve", "Madden", 56789, "smadden@sdsu.edu", 2.0, 105));

        return students;
    }
}
