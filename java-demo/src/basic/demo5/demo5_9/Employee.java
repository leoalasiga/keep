package basic.demo5.demo5_9;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author ljj
 * @description
 * @date 2020-08-10
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary,int year,int month,int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object otherObj) {
        //a quick test to see if the objects are identical
        if (this == otherObj) {
            return true;
        }

            //must return false if the explicit parameters is null
        if (otherObj == null) {
            return false;
        }

        //if the classed don't match ,they can't be equal
        if (getClass() != otherObj.getClass()) {
            return false;
        }

        //now we know otherObj is a non-null Employee
        Employee other = (Employee) otherObj;

        //test whether the fields have identical values
        return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay ,other.hireDay);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    @Override
    public String toString() {
        return getClass().getName()+ "[" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                ']';
    }
}
