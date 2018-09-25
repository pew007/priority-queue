import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class GpaComparatorTest {

    @Test
    void compare() {
        Student student1 = new Student();
        student1.setGpa(4.0);

        Student student2 = new Student();
        student2.setGpa(2.0);

        Comparator<Student> gpaComparator = new GpaComparator();

        Assertions.assertTrue(gpaComparator.compare(student1, student2) > 0);
    }

    @Test
    void equals() {
        Student student1 = new Student();
        student1.setGpa(2.0);

        Student student2 = new Student();
        student2.setGpa(2.0);

        Comparator<Student> gpaComparator = new GpaComparator();

        Assertions.assertEquals(0, gpaComparator.compare(student1, student2));
    }
}