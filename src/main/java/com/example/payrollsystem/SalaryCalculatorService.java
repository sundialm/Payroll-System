package com.example.payrollsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryCalculatorService implements SalaryCalculatorServiceInterface, ApplicationEventPublisherAware {
    @Autowired
    private EmployeeRepository employeeRepository;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getByType(EmployeeType employeeType) {
        return employeeRepository.findEmployeesByEmplType(employeeType);
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findEmployeesById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void changeSalary(long id, double salary) {
        Employee employee = findById(id);
        employee.setFixedSalary(salary);
        save(employee);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee));
    }
    @Override
    public void changeHourRate(long id, double rate) {
        Employee employee = findById(id);
        employee.setHourRate(rate);
        save(employee);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee));
    }
    @Override
    public void changeCommRate(long id, float rate) {
        Employee employee = findById(id);
        employee.setCommRate(rate);
        save(employee);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
