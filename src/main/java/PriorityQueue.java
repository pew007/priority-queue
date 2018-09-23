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
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }

        if (size() == 1) {
            return maxHeap.remove(0).getValue();
        }

        // save the current root to be returned and set the current leaf node as the new root
        // then sift down the new root node if necessary
        Association<Double, E> removed = maxHeap.get(0);
        Association<Double, E> leafNode = maxHeap.remove(size() - 1);
        maxHeap.set(0, leafNode);
        siftDown();

        return removed.getValue();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return super.toArray(a);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Association association : maxHeap) {
            stringBuilder.append(association.getValue().toString());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
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

    private void siftDown() {
        int currentIndex = 0;
        int leftIndex = 2 * currentIndex + 1;

        while (leftIndex < size()) {
            int maxIndex = leftIndex;
            int rightIndex = leftIndex + 1;
            Association currentNode = maxHeap.get(currentIndex);
            Association leftChild = maxHeap.get(leftIndex);
            Association currentMaxNode = maxHeap.get(maxIndex);

            // if there is a right child, compare it with the left child to find the max
            if (rightIndex < size()) {
                Association rightChild = maxHeap.get(rightIndex);
                if ((double) rightChild.getKey() > (double) leftChild.getKey()) {
                    maxIndex = rightIndex;
                }
            }

            if ((double) currentNode.getKey() < (double) currentMaxNode.getKey()) {
                swap(currentIndex, maxIndex);
                currentIndex = maxIndex;
                leftIndex = 2 * currentIndex + 1;
            } else {
                break;
            }
        }
    }

    private void swap(int index1, int index2) {
        Association<Double, E> item1 = maxHeap.get(index1);
        Association<Double, E> item2 = maxHeap.get(index2);

        maxHeap.set(index1, item2);
        maxHeap.set(index2, item1);
    }
}
