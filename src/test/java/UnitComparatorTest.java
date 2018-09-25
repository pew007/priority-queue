import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class UnitComparatorTest {

    @Test
    void compare() {
        Student student1 = new Student();
        student1.setUnits(100);

        Student student2 = new Student();
        student2.setUnits(80);

        Comparator<Student> unitsComparator = new UnitComparator();

        Assertions.assertTrue(unitsComparator.compare(student1, student2) > 0);
    }

    @Test
    void equals() {
        Student student1 = new Student();
        student1.setUnits(80);

        Student student2 = new Student();
        student2.setUnits(80);

        Comparator<Student> unitsComparator = new UnitComparator();

        Assertions.assertEquals(0, unitsComparator.compare(student1, student2));
    }
}