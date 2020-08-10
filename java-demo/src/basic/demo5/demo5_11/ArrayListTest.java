package basic.demo5.demo5_11;

import basic.demo5.demo5_9.Employee;

import java.util.ArrayList;

/**
 * @author ljj
 * @description This program demonstrates ArrayList class
 * @date 2020-08-10
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //fill the staff array list with three Employee objects
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Carl Cracker",75000,1987,12,15));
        staff.add(new Employee("Harry Hacker",50000,1989,10,1));
        staff.add(new Employee("Tony Tester",40000,1990,3,15));

        //raise everyone's salary y 5%
        for (Employee employee : staff) {
            employee.raiseSalary(5);
        }

        //print out information about all Employee objects
        for (Employee employee : staff) {
            System.out.println(employee.toString());
        }
    }
}
