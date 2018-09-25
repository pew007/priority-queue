import java.util.Comparator;

public class UnitComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getUnits() == o2.getUnits()) {
            return 0;
        }

        return o1.getUnits() > o2.getUnits() ? 1 : -1;
    }
}
