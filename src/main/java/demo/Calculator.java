package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Calculator implements ISalaryCalculator, ApplicationEventPublisherAware {
    @Autowired
    private ERepository employeeRepository;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getByType(EType employeeType) {
        return employeeRepository.byType(employeeType);
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.byID(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void changeSalary(int idOfEmployee, int salary) {
        Employee employee = findById(idOfEmployee);
        employee.setFixedSalary(salary);
        save(employee);
        this.eventPublisher.publishEvent(new Change(this, employee));
    }

    @Override
    public void changeHourRate(int idOfEmployee, double rate) {
        Employee employee = findById(idOfEmployee);
        employee.setHourRate(rate);
        save(employee);
        this.eventPublisher.publishEvent(new Change(this, employee));
    }

    @Override
    public void changeCommRate(int idOfEmployee, int rate) {
        Employee employee = findById(idOfEmployee);
        employee.setComRate(rate);
        save(employee);
        this.eventPublisher.publishEvent(new Change(this, employee));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
