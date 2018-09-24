public class UnitAndGpaComparator implements PriorityComparator<Student> {
    @Override
    public double getPriority(Student student) {
        double weightedUnits = (double) student.getUnits() / (double) Student.MaxUnits * Student.UNITS_WEIGHT;
        double weightedGpa = student.getGpa() / Student.MaxGPA * Student.GPA_WEIGHT;

        return weightedUnits + weightedGpa;
    }
}
