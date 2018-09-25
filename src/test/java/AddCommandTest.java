import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandTest {

    private PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new GpaComparator());
    private List<Student> students = new ArrayList<>();

    @BeforeEach
    void setUp() {
        students = TestDataGenerator.generateStudents();
    }

    @Test
    void execute() {
        AddCommand addCommand = new AddCommand(priorityQueue);
        addCommand.execute(students.get(0));
        addCommand.execute(students.get(1));
        addCommand.execute(students.get(2));
        addCommand.execute(students.get(3));

        Assertions.assertEquals(4, priorityQueue.size());
    }

    @Test
    void undo() {
        AddCommand addCommand = new AddCommand(priorityQueue);
        addCommand.execute(students.get(0));
        addCommand.execute(students.get(1));
        addCommand.execute(students.get(2));
        addCommand.execute(students.get(3));
        addCommand.undo();
        addCommand.undo();

        Assertions.assertEquals(2, priorityQueue.size());
    }
}