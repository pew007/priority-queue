public class UnitComparator implements PriorityComparator<Student> {
    @Override
    public double getPriority(Student student) {
        return student.getUnits();
    }

    @Override
    public int compare(Student e1, Student e2) {
        return 0;
    }
}
