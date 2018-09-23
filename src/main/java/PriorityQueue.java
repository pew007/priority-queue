import java.util.*;

public class PriorityQueue<E> extends AbstractQueue<E> {

    private List<Association<Double, E>> maxHeap;
    private PriorityComparator<E> comparator;

    public PriorityQueue(PriorityComparator<E> comparator) {
        this.maxHeap = new ArrayList<>();
        this.comparator = comparator;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean add(E e) {
        double priority = comparator.getPriority(e);
        Association<Double, E> association = new Association<>(priority, e);
        maxHeap.add(association);

        siftUp();

        return true;
    }

    @Override
    public E remove() {
        return super.remove();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return super.toArray(a);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private void siftUp() {
        int currentIndex = this.size() - 1;

        while (currentIndex > 0) {
            // in the flat array structure, the parent index of an item at index k is (k-1)/2
            int parentIndex = (currentIndex - 1) / 2;
            Association currentNode = maxHeap.get(currentIndex);
            Association parentNode = maxHeap.get(parentIndex);

            if ((double) currentNode.getKey() > (double) parentNode.getKey()) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int index1, int index2) {
        Association item1 = maxHeap.get(index1);
        Association item2 = maxHeap.get(index2);

        maxHeap.set(index1, item2);
        maxHeap.set(index2, item1);
    }
}
