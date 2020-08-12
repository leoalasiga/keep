package basic.demo6.demo6_4;

import basic.demo6.demo6_5.Employee;

/**
 * @author ljj
 * @description This program demonstrates cloning
 * @date 2020-08-12
 */
public class CloneTest {
    public static void main(String[] args) {

        Employee original = new Employee("John Q. Public", 50000);
        original.setHireDay(2000, 1, 1);
        try {
            Employee clone = original.clone();
            clone.raiseSalary(10);
            clone.setHireDay(2002, 12, 31);
            System.out.println("orignial=" + original.toString());
            System.out.println("clone=" + clone.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
