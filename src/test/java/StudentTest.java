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
}