import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PriorityQueueTest {

    private ArrayList<Student> students = new ArrayList<>();

    @BeforeEach
    void setUp() {
        students.add(new Student("John", "Doe", 12345, "jdoe@sdsu.edu", 4.0, 40));
        students.add(new Student("Jane", "Dawn", 23456, "jdowe@sdsu.edu", 3.2, 50));
        students.add(new Student("Adam", "Smith", 34567, "asmith@sdsu.edu", 2.2, 100));
        students.add(new Student("Ben", "Stevens", 45678, "bstevens@sdsu.edu", 3.5, 60));
        students.add(new Student("Steve", "Madden", 56789, "smadden@sdsu.edu", 2.0, 105));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void size() {
    }

    @Test
    void add() {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new GpaComparator());
        for (Student student: students) {
            priorityQueue.add(student);
        }

        Assertions.assertEquals(5, priorityQueue.size());
    }

    @Test
    void remove() {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new GpaComparator());
        for (Student student: students) {
            priorityQueue.add(student);
        }

        Assertions.assertEquals(4.0, priorityQueue.remove().getGpa());
        Assertions.assertEquals(3.5, priorityQueue.remove().getGpa());
        Assertions.assertEquals(3.2, priorityQueue.remove().getGpa());
        Assertions.assertEquals(2.2, priorityQueue.remove().getGpa());
        Assertions.assertEquals(2.0, priorityQueue.remove().getGpa());
    }
}