package demo;

import org.springframework.context.ApplicationEvent;

public class Change extends ApplicationEvent {
    Employee employee;
    public Change(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }
}
