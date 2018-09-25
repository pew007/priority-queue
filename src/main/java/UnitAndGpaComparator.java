import java.util.Comparator;

public class UnitAndGpaComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        double p1 = calculatePriority(o1);
        double p2 = calculatePriority(o2);

        if (p1 == p2) {
            return 0;
        }

        return p1 > p2 ? 1 : -1;
    }

    private double calculatePriority(Student student) {
        double weightedUnits = (double) student.getUnits() / (double) Student.MaxUnits * Student.UNITS_WEIGHT;
        double weightedGpa = student.getGpa() / Student.MaxGPA * Student.GPA_WEIGHT;

        return weightedUnits + weightedGpa;
    }
}
