import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private EmployeeCondition condition;
    private int birthYear;
    private double salary;

    public Employee(String firstName, String lastName, EmployeeCondition condition, int birthYear, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.condition = condition;
        this.birthYear = birthYear;
        this.salary = salary;
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeCondition getCondition() {
        return condition;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getSalary() {
        return salary;
    }

    public void setCondition(EmployeeCondition condition) {
        this.condition = condition;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // printing
    public void printing() {
        System.out.println(firstName + " " + lastName + " " + condition + " " + birthYear + " " + salary);
    }

    // compare to - sortowanie po nazwisku
    @Override
    public int compareTo(Employee other) {
        return this.lastName.compareTo(other.lastName);
    }

    // usuwanie duplikatów
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Employee))
            return false;

        Employee e = (Employee) obj;
        return this.firstName.equals(e.firstName) && this.lastName.equals(e.lastName);
    }

    // hashowanie w celu usuwania duplikatów - domyślna implemnetacja equals
    // wskauzje na referencje, a nie na wartości
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

}
