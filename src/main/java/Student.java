public class Student {

    public static final double UNITS_WEIGHT = 0.7;
    public static final double GPA_WEIGHT = 0.3;
    public static final double MaxGPA = 4.0;
    public static final int MaxUnits = 150;

    private String firstName;
    private String lastName;
    private int redId;
    private String email;
    private double gpa;
    private int units;

    public Student() {
    }

    public Student(String firstName, String lastName, int redId, String email, double gpa, int units) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setRedId(redId);
        this.setEmail(email);
        this.setGpa(gpa);
        this.setUnits(units);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public int getRedId() {
        return redId;
    }

    public void setRedId(int redId) {
        this.redId = redId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0 && gpa <= MaxGPA) {
            this.gpa = gpa;
        } else {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        if (units >= 0 && units <= MaxUnits) {
            this.units = units;
        } else {
            throw new IllegalArgumentException("Units taken must be between 0 and 150");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Red Id: %d, Name: %s, GPA: %f, Units: %d",
                this.getRedId(),
                this.getFullName(),
                this.getGpa(),
                this.getUnits()
        );
    }
}
