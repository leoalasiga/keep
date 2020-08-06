package basic.demo4.demo4_2;

/**
 * @author ljj
 * @description This program test Employee class
 * @date 2020-08-06
 */
public class EmployeeTest {
    public static void main(String[] args) {
        //fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        //raise everyone's salary by 5%
        for (Employee employee : staff) {
            employee.raiseSalary(5);
        }

        //print information about all objects
        for (Employee employee : staff) {
            System.out.println(employee.toString());
        }
    }
}
