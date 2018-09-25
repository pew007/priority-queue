public class AddCommand extends Command {

    private PriorityQueue priorityQueue;

    public AddCommand(PriorityQueue priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    @Override
    public void execute(Object... args) throws IllegalArgumentException {
        if (args.length <= 0) {
            throw new IllegalArgumentException();
        }

        Object toAdd = args[0];
        priorityQueue.add(toAdd);
    }

    @Override
    public void undo(Object... args) throws IllegalArgumentException {
        if (args.length <= 0) {
            throw new IllegalArgumentException();
        }

        Object lastAdded = args[0];
        priorityQueue.remove(lastAdded);
    }
}
