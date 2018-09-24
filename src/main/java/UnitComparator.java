public class UnitComparator implements PriorityComparator<Student> {
    @Override
    public double getPriority(Student student) {
        return student.getUnits();
    }
}
