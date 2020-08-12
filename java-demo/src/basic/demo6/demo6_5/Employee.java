package basic.demo6.demo6_5;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author ljj
 * @description
 * @date 2020-08-12
 */
public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }


    public Employee clone() throws CloneNotSupportedException {
        //call object clone
        Employee clone = (Employee) super.clone();
        //clone mutable field
        clone.hireDay = (Date) hireDay.clone();
        return clone;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime(newHireDay.getTime());

    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
