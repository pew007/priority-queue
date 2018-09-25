import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RemoveCommandTest {

    private PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new GpaComparator());
    private List<Student> students = new ArrayList<>();

    @BeforeEach
    void setUp() {
        students = TestDataGenerator.generateStudents();
    }

    @Test
    void removeFromEmptyQueue() {
        RemoveCommand removeCommand = new RemoveCommand(priorityQueue);
        Assertions.assertThrows(NoSuchElementException.class, removeCommand::execute);
    }

    @Test
    void removeAfterAdd() {
        priorityQueue.add(students.get(0));
        priorityQueue.add(students.get(1));

        RemoveCommand removeCommand = new RemoveCommand(priorityQueue);
        removeCommand.execute();

        Assertions.assertEquals(1, priorityQueue.size());
    }

    @Test
    void undo() {
    }
}