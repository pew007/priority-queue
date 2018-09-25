import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessorTest {

    private PriorityQueue<Student> priorityQueue;
    private List<Student> students;
    private CommandProcessor commandProcessor;
    private AddCommand addCommand;

    @BeforeEach
    void setUp() {
        priorityQueue = new PriorityQueue<>(new UnitComparator());
        students = TestDataGenerator.generateStudents();

        commandProcessor = new CommandProcessor();
        addCommand = new AddCommand(priorityQueue);
        commandProcessor.setCommand(CommandProcessor.ADD, addCommand);
    }

    @Test
    void execute() {
        commandProcessor.execute(CommandProcessor.ADD, students.get(0));
        Assertions.assertEquals(1, priorityQueue.size());

        commandProcessor.execute(CommandProcessor.ADD, students.get(1));
        commandProcessor.execute(CommandProcessor.ADD, students.get(2));
        commandProcessor.execute(CommandProcessor.ADD, students.get(3));
        commandProcessor.execute(CommandProcessor.REMOVE);
        Assertions.assertEquals(3, priorityQueue.size());
    }

    @Test
    void undo() {
        commandProcessor.execute(CommandProcessor.ADD, students.get(0));
        commandProcessor.execute(CommandProcessor.ADD, students.get(1));
        commandProcessor.undo();

        Assertions.assertEquals(1, priorityQueue.size());
    }
}