import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandTest {

    @Test
    void execute() {
        List<Student> students = TestDataGenerator.generateStudents();
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new GpaComparator());

        AddCommand addCommand = new AddCommand(priorityQueue, students.get(0));
        addCommand.execute();

        Assertions.assertEquals(1, priorityQueue.size());

        addCommand.undo();
        Assertions.assertTrue(priorityQueue.isEmpty());

    }
}