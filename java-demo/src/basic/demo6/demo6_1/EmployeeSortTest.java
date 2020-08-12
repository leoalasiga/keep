package basic.demo6.demo6_1;


import basic.demo6.demo6_2.Employee;

import java.util.Arrays;

/**
 * @author ljj
 * @description This program demonstrates the use of the Comparable interface
 * @date 2020-08-11
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 30000);
        staff[1] = new Employee("Carl Carcker", 70000);
        staff[2] = new Employee("Tony Tester", 50000);

        Arrays.sort(staff);

        for (Employee employee : staff) {
            System.out.println("name=" + employee.getName() + ",salary=" + employee.getSalary());
        }

    }
}
