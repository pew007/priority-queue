import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class UnitAndGpaComparatorTest {

    @Test
    void compare() {
        Student student1 = new Student();
        student1.setUnits(100);
        student1.setGpa(4.0);

        Student student2 = new Student();
        student2.setUnits(80);
        student2.setGpa(3.0);

        Comparator<Student> comparator = new UnitAndGpaComparator();

        Assertions.assertTrue(comparator.compare(student1, student2) > 0);
    }

    @Test
    void equals() {
        Student student1 = new Student();
        student1.setUnits(100);
        student1.setGpa(4.0);

        Student student2 = new Student();
        student2.setUnits(100);
        student2.setGpa(4.0);

        Comparator<Student> comparator = new UnitAndGpaComparator();

        Assertions.assertEquals(0, comparator.compare(student1, student2));
    }
}