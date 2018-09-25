import java.util.*;

public class PriorityQueue<E> extends AbstractQueue<E> {

    private List<E> maxHeap;
    private Comparator<E> comparator;

    private class PriorityQueueIterator implements Iterator<E> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < maxHeap.size();
        }

        @Override
        public E next() {
            if (hasNext()) {
                return maxHeap.get(current++);
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public PriorityQueue(Comparator<E> comparator) {
        this.maxHeap = new ArrayList<>();
        this.comparator = comparator;
    }

    public void setComparator(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Iterator<E> iterator() {
        return new PriorityQueueIterator();
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }

        maxHeap.add(e);

        siftUp();

        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }

        if (size() == 1) {
            return maxHeap.remove(0);
        }

        // save the current root to be returned and set the current leaf node as the new root
        // then sift down the new root node if necessary
        E removed = maxHeap.get(0);
        E leafNode = maxHeap.remove(size() - 1);
        maxHeap.set(0, leafNode);
        siftDown();

        return removed;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return maxHeap.get(0);
    }

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public E remove() {
        return poll();
    }

    @Override
    public Object[] toArray() {
        List<Object> list = new ArrayList<>();
        forEach(list::add);

        return list.toArray();
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        forEach(e -> {
            stringBuilder.append(e.toString());
            stringBuilder.append("\n");
        });

        return stringBuilder.toString();
    }

    private void siftUp() {
        int currentIndex = this.size() - 1;

        while (currentIndex > 0) {
            // in the flat array structure, the parent index of an item at index k is (k-1)/2
            int parentIndex = (currentIndex - 1) / 2;
            E currentNode = maxHeap.get(currentIndex);
            E parentNode = maxHeap.get(parentIndex);

            if (comparator.compare(currentNode, parentNode) > 0) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void siftDown() {
        int currentIndex = 0;
        int leftIndex = 2 * currentIndex + 1;

        while (leftIndex < size()) {
            int maxIndex = leftIndex;
            int rightIndex = leftIndex + 1;
            E currentNode = maxHeap.get(currentIndex);
            E leftChild = maxHeap.get(leftIndex);
            E currentMaxNode = maxHeap.get(maxIndex);

            // if there is a right child, compare it with the left child to find the max
            if (rightIndex < size()) {
                E rightChild = maxHeap.get(rightIndex);
                if (comparator.compare(rightChild, leftChild) > 0) {
                    maxIndex = rightIndex;
                }
            }

            if (comparator.compare(currentNode, currentMaxNode) < 0) {
                swap(currentIndex, maxIndex);
                currentIndex = maxIndex;
                leftIndex = 2 * currentIndex + 1;
            } else {
                break;
            }
        }
    }

    private void swap(int index1, int index2) {
        E item1 = maxHeap.get(index1);
        E item2 = maxHeap.get(index2);

        maxHeap.set(index1, item2);
        maxHeap.set(index2, item1);
    }
}
