public class AddCommand implements Command {

    private PriorityQueue priorityQueue;
    private Object toAdd;

    public AddCommand(PriorityQueue priorityQueue, Object toAdd) {
        this.priorityQueue = priorityQueue;
        this.toAdd = toAdd;
    }

    @Override
    public void execute() {
        priorityQueue.add(toAdd);
    }

    @Override
    public void undo() {
        priorityQueue.remove(toAdd);
    }
}
