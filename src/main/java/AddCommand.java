public class AddCommand implements Command {

    private PriorityQueue priorityQueue;

    public AddCommand(PriorityQueue priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
