import java.util.Iterator;

public class PriorityQueueIterator<E> implements Iterator<E> {

    private PriorityQueue<E> priorityQueue;

    public PriorityQueueIterator(PriorityQueue<E> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    @Override
    public boolean hasNext() {
        return priorityQueue.peek() != null;
    }

    @Override
    public E next() {
        return priorityQueue.poll();
    }
}
