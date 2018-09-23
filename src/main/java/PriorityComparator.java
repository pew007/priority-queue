public interface PriorityComparator<E> {
    public double getPriority(E e);

    public int compare(E e1, E e2);
}
