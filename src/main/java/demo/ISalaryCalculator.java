package demo;

import java.util.List;

public interface ISalaryCalculator {
    List<Employee> findAll();
    List<Employee> getByType(EType employeeType);
    Employee findById(long id);

    void save(Employee employee);

    void changeSalary(int idOfEmployee, int salary);

    void changeHourRate(int idOfEmployee, double rate);

    void changeCommRate(int idOfEmployee, int rate);
}
