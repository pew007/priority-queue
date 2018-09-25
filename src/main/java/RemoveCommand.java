public class RemoveCommand extends Command {

    private PriorityQueue priorityQueue;
    private Object lastRemoved;

    public RemoveCommand(PriorityQueue priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    @Override
    public void execute(Object... args) throws IllegalArgumentException {
        if (args.length > 0) {
            throw new IllegalArgumentException();
        }

        lastRemoved = priorityQueue.remove();
    }

    @Override
    public void undo(Object... args) throws IllegalArgumentException {
        if (lastRemoved != null) {
            priorityQueue.add(lastRemoved);
        }
    }
}
