package Developer.Model;

import java.math.BigDecimal;

public class Developer {
    private long id;
    private String firstName;
    private String lastName;
    private String specialty;
    private Integer experience;
    private BigDecimal salary;

    public Developer() {
    }

    public Developer(Integer id, String firstName, String lastName, String specialty, Integer experiance, BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.experience = experiance;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id " + id +
                ", firstName " + firstName +
                ", lastName " + lastName +
                ", specialty " + specialty +
                ", experience " + experience +
                ", salary " + salary +
                '}';
    }
}