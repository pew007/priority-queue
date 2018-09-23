import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void getFullName() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");

        Assertions.assertEquals("John Doe", student.getFullName() );
    }

    @Test
    void setGpa() {
        Student student = new Student();
        student.setGpa(4.0);

        Assertions.assertEquals(4.0, student.getGpa());
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.setGpa(4.5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.setGpa(-2));
    }

    @Test
    void setUnits() {
        Student student = new Student();
        student.setUnits(120);

        Assertions.assertEquals(120, student.getUnits());
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.setUnits(200));
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.setUnits(-10));
    }

    @Test
    void getPriority() {
        Student student = new Student();
        student.setGpa(2.0);
        student.setUnits(100);
        Assertions.assertEquals(0.6166666666666666, student.getPriority());

        student.setGpa(2.0);
        student.setUnits(75);
        Assertions.assertEquals(0.5, student.getPriority());

        student.setGpa(4.0);
        student.setUnits(150);
        Assertions.assertEquals(1.0, student.getPriority());
    }
}