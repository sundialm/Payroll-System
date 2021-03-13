package com.example.payrollsystem;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {
    @Override
    @EventListener
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println(salaryChangeEvent.employee.getName() + "'информация о зарплате изменилась.");
    }
}
