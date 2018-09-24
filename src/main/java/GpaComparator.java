public class GpaComparator implements PriorityComparator<Student> {
    @Override
    public double getPriority(Student student) {
        return student.getGpa();
    }
}
