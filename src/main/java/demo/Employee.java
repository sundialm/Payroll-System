package demo;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    private double fixedSalary;
    private int hoursWorked;
    private float comRate;
    private double hourRate;

    @Enumerated(EnumType.STRING)

    private EType employeeType;

    public String getEmployeeName() {
        return employeeName;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public float getComRate() {
        return comRate;
    }

    public void setComRate(float comRate) {
        this.comRate = comRate;
    }

    public EType getEmployeeType() {
        return employeeType;
    }

    public Long getEmployeeId() {
        return employeeId;
    }
}
