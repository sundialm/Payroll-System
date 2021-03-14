package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

@Controller
public class Menu {

    Scanner sc = new Scanner(System.in);

    @Autowired
    ISalaryCalculator iSalaryCalculator;

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public int initId(){
        int id = sc.nextInt();
        return id;
    }

    public double initRate(){
        double rate = sc.nextDouble();
        return rate;
    }

    @PostConstruct
    public void printInfo() {
        int c = 0;

        System.out.println("1. All salary \n " +
                "2. Change Hour rate \n " +
                "3. Change Comm rate \n" +
                "4. Change salary of employee\n" +
                "5. List of all employees\n" +
                "6. Exit");

        int num = 0;

        num = sc.nextInt();

            switch (num) {
                case 1: {
                    System.out.println("1. All salary: ");
                    List<Employee> employees = iSalaryCalculator.getByType(EType.HOURLY);
                    c = 1;
                    for (Employee emp: employees) {
                        System.out.println(emp.getEmployeeName() + ": " + emp.getFixedSalary() + " $");
                        c++;}
                }
                break;
                case 2: {
                    System.out.println("2. Change Hour rate\n" +
                            "Enter id of employee then hour rate:");
                    iSalaryCalculator.changeHourRate(initId(),initRate());
                }
                break;
                case 3: {
                    System.out.println("2. Change Hour rate\n" +
                            "Enter id of employee then comm rate:");
                    iSalaryCalculator.changeCommRate(initId(),initId());
                }
                break;
                case 4: {
                    System.out.println("2. Change Hour rate\n" +
                            "Enter id of employee then a new salary of employee:");
                    iSalaryCalculator.changeSalary(initId(),initId());
                }
                break;
                case 5: {
                   // -------------------------------------------------------------------
                }
                break;
                default: {
                }
            }
    }
}
