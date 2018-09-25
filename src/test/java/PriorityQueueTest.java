import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PriorityQueueTest {

    private List<Student> students = new ArrayList<>();

    @BeforeEach
    void setUp() {
        students = TestDataGenerator.generateStudents();
    }

    @Test
    void size() {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new GpaComparator());
        priorityQueue.addAll(students);

        Assertions.assertEquals(5, priorityQueue.size());
    }

    @Test
    void addNull() {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new GpaComparator());
        Assertions.assertThrows(NullPointerException.class, () -> priorityQueue.add(null));
    }

    @Test
    void prioritizedByGpa() {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new GpaComparator());
        priorityQueue.addAll(students);

        Assertions.assertEquals(4.0, priorityQueue.remove().getGpa());
        Assertions.assertEquals(3.5, priorityQueue.remove().getGpa());
        Assertions.assertEquals(3.2, priorityQueue.remove().getGpa());
        Assertions.assertEquals(2.2, priorityQueue.remove().getGpa());
        Assertions.assertEquals(2.0, priorityQueue.remove().getGpa());
    }

    @Test
    void prioritizedByUnits() {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new UnitComparator());
        priorityQueue.addAll(students);

        Assertions.assertEquals(105, priorityQueue.remove().getUnits());
        Assertions.assertEquals(100, priorityQueue.remove().getUnits());
        Assertions.assertEquals(60, priorityQueue.remove().getUnits());
        Assertions.assertEquals(50, priorityQueue.remove().getUnits());
        Assertions.assertEquals(40, priorityQueue.remove().getUnits());
    }

    @Test
    void toArray() {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new UnitComparator());
        priorityQueue.addAll(students);

        Object[] array = priorityQueue.toArray();
        Assertions.assertEquals(5, array.length);
        for (Object obj : array) {
            Assertions.assertTrue(obj instanceof Student);
        }
    }

    @Test
    void removeSpecificObject() {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new UnitComparator());
        Student student1 = students.get(0);
        Student student2 = students.get(1);
        Student student3 = students.get(2);
        Student student4 = students.get(3);

        priorityQueue.add(student1);
        priorityQueue.add(student2);
        priorityQueue.add(student3);
        priorityQueue.add(student4);
        System.out.println(priorityQueue);
        priorityQueue.remove(student2);

        System.out.println(priorityQueue);
    }
}
