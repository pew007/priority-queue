public class RemoveCommand implements Command {

    private PriorityQueue priorityQueue;
    private Object lastRemoved;

    public RemoveCommand(PriorityQueue priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    @Override
    public void execute() {
        lastRemoved = priorityQueue.remove();
    }

    @Override
    public void undo() {
        priorityQueue.add(lastRemoved);
    }
}
