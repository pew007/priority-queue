import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CommandProcessorTest {

    private PriorityQueue<Student> priorityQueue;
    private List<Student> students;

    @BeforeEach
    void setUp() {
        priorityQueue = new PriorityQueue<>(new UnitComparator());
        students = TestDataGenerator.generateStudents();
    }

    @Test
    void executeAdd() {
        CommandProcessor commandProcessor = new CommandProcessor();

        Command addCommand = new AddCommand(priorityQueue, students.get(0));
        commandProcessor.execute(addCommand);

        addCommand = new AddCommand(priorityQueue, students.get(3));
        commandProcessor.execute(addCommand);

        addCommand = new AddCommand(priorityQueue, students.get(4));
        commandProcessor.execute(addCommand);

        Assertions.assertEquals(3, priorityQueue.size());

        commandProcessor.undo();
        commandProcessor.undo();
        commandProcessor.undo();

        Assertions.assertEquals(0, priorityQueue.size());
    }

    @Test
    void executeRemove() {
        CommandProcessor commandProcessor = new CommandProcessor();

        Command addCommand = new AddCommand(priorityQueue, students.get(0));
        commandProcessor.execute(addCommand);

        addCommand = new AddCommand(priorityQueue, students.get(3));
        commandProcessor.execute(addCommand);

        addCommand = new AddCommand(priorityQueue, students.get(4));
        commandProcessor.execute(addCommand);

        Command removeCommand = new RemoveCommand(priorityQueue);
        commandProcessor.execute(removeCommand);

        removeCommand = new RemoveCommand(priorityQueue);
        commandProcessor.execute(removeCommand);

        Assertions.assertEquals(1, priorityQueue.size());

        commandProcessor.undo();
        commandProcessor.undo();
        Assertions.assertEquals(3, priorityQueue.size());
    }
}
