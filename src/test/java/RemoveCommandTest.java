import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveCommandTest {

    @Test
    void execute() {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new GpaComparator());
        List<Student> students = TestDataGenerator.generateStudents();

        AddCommand addCommand = new AddCommand(priorityQueue, students.get(0));
        addCommand.execute();

        RemoveCommand removeCommand = new RemoveCommand(priorityQueue);
        removeCommand.execute();

        Assertions.assertTrue(priorityQueue.isEmpty());
    }

    @Test
    void undo() {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new GpaComparator());
        List<Student> students = TestDataGenerator.generateStudents();

        AddCommand addCommand = new AddCommand(priorityQueue, students.get(0));
        addCommand.execute();

        RemoveCommand removeCommand = new RemoveCommand(priorityQueue);
        removeCommand.execute();

        Assertions.assertTrue(priorityQueue.isEmpty());

        removeCommand.undo();
        Assertions.assertEquals(1, priorityQueue.size());
    }
}