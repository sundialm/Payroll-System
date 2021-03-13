package com.example.payrollsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Controller
public class EmployeeMenu {
    Scanner scan = new Scanner(System.in).useLocale(Locale.US);
    @Autowired
    SalaryCalculatorServiceInterface salaryCalculatorServiceInterface;
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    @PostConstruct
    public void showMenu() {
        int choice = 0;
        while (choice != 6) {
            int i = 0;
            System.out.println("1. Рассчитать все зарплаты");
            System.out.println("2. Изменить часовую ставку");
            System.out.println("3. Изменить ставку комиссии");
            System.out.println("4. Изменить зарплату сотрудника");
            System.out.println("5. Список всех сотрудников");
            System.out.println("6. Exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("\n----------------------------------------------------------------\n");
                    System.out.println("SALARIED СОТРУДНИК: ");
                    List<Employee> employees = salaryCalculatorServiceInterface.getByType(EmployeeType.SALARIED);
                    System.out.println(" --" +employees.size() + " сотрудник найден.");
                    i = 1;
                    for (Employee employee: employees) {
                        System.out.println(i + ") " + employee.getName() + ": " + employee.getFixedSalary() + " тг");
                        i++;
                    }
                    System.out.println("\n----------------------------------------------------------------\n");
                    System.out.println("HOURLY СОТРУДНИК: ");
                    employees = salaryCalculatorServiceInterface.getByType(EmployeeType.HOURLY);
                    System.out.println(" --" +employees.size() + " сотрудник найден.");
                    i = 1;
                    for (Employee employee: employees) {
                        double salary = employee.getFixedSalary();
                        int hours = employee.getHoursWorked();
                        if (hours > 40) {
                            System.out.println(i + ") " + employee.getName() + ": " + (salary * 40 + (hours - 40) * salary * employee.getHourRate()) + " (работал " + hours + " часы)");
                        }
                        else {
                            System.out.println(i + ") " + employee.getName() + ": " + salary * hours);
                        }
                        i++;
                    }
                    System.out.println("\n----------------------------------------------------------------\n");
                    System.out.println("COMMISSION СОТРУДНИК: ");
                    employees = salaryCalculatorServiceInterface.getByType(EmployeeType.COMMISSION);
                    System.out.println(" --" +employees.size() + " сотрудник найден.");
                    i = 1;
                    for (Employee employee: employees) {
                        double salary = (employee.getFixedSalary() * employee.getCommRate());
                        System.out.println(i + ") " + employee.getName() + ": " + df2.format(salary) + " тг");
                        i++;
                    }
                    System.out.println("\n----------------------------------------------------------------\n");
                    System.out.println("SALARIED COMMISSION СОТРУДНИК: ");
                    employees = salaryCalculatorServiceInterface.getByType(EmployeeType.SALARIED_COMMISSION);
                    System.out.println(" --" +employees.size() + " сотрудник найден.");
                    i = 1;
                    for (Employee employee: employees) {
                        double salary = ((employee.getFixedSalary() + employee.getCommRate() * employee.getFixedSalary()));
                        System.out.println(i + ") " + employee.getName() + ": " + df2.format(salary) + " тг");
                        i++;
                    }
                    System.out.println();
                }
                break;
                case 2: {
                    System.out.println("\n----------------------------------------------------------------\n\n");
                    System.out.println("Введите идентификатор сотрудника: ");
                    int id = scan.nextInt();
                    System.out.println("Введите новую почасовую ставку: ");
                    double rate = scan.nextDouble();
                    salaryCalculatorServiceInterface.changeHourRate(id,rate);
                }
                break;
                case 3: {
                    System.out.println("\n----------------------------------------------------------------\n");
                    System.out.println("Введите идентификатор сотрудника: ");
                    int id = scan.nextInt();
                    System.out.println("Введите новую ставку комиссии: ");
                    float rate = scan.nextFloat();
                    salaryCalculatorServiceInterface.changeCommRate(id,rate);

                }
                break;
                case 4: {

                    System.out.println("\n----------------------------------------------------------------\n");
                    System.out.println("Введите идентификатор сотрудника: ");
                    int id = scan.nextInt();
                    System.out.println("Введите новую зарплату: ");
                    double salary = scan.nextDouble();
                    salaryCalculatorServiceInterface.changeSalary(id,salary);
                }
                break;
                case 5: {
                    System.out.println("\n----------------------------------------------------------------\n");
                    i = 0;
                    List<Employee> employees = salaryCalculatorServiceInterface.findAll();
                    System.out.println("Общее количество сотрудников: " + employees.size());
                    for (Employee employee : employees) {
                        String name = employee.getName();
                        long id = employee.getId();
                        System.out.println("Идентификатор: " + id+ " - " + name + " - Тип : " + employee.getEmplType());
                    }
                }
                break;
                default: {

                }
            }
        }
    }
}
