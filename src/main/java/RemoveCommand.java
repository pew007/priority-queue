public class RemoveCommand implements Command {

    private PriorityQueue priorityQueue;

    public RemoveCommand(PriorityQueue priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
