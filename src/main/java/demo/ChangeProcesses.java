package demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

public class ChangeProcesses implements ApplicationListener<Change> {
    @Override
    @EventListener
    public void onApplicationEvent(Change salaryChangeEvent) {
        System.out.println(salaryChangeEvent.employee.getEmployeeName() + "'информация о зарплате изменилась.");
    }
}
