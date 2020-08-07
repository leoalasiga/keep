package basic.demo4.demo4_5;

/**
 * @author ljj
 * @description This program demonstrates parameters passing in java
 * @date 2020-08-07
 */
public class ParamTest {
    public static void main(String[] args) {
        /**
         * Test1:Methods can't modify numeric parameter;
         */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent =" + percent);
        tripleValue(percent);
        System.out.println("After: percent =" + percent);

        /**
         * Test2:Methods can change the state of object parameter;
         */
        System.out.println("\nTesting tripleSalary");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before: salary =" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary =" + harry.getSalary());

        /**
         * Test3:Methods can't attach new objects to object parameter;
         */
        System.out.println("\nTesting swap");
        Employee a = new Employee("Alice", 100000);
        Employee b = new Employee("Bob", 500000);
        System.out.println("Before: a =" + a.getName());
        System.out.println("Before: b =" + b.getName());
        swap(a,b);
        System.out.println("After: a =" + a.getName());
        System.out.println("After: b =" + b.getName());}

    private static void swap(Employee a, Employee b) {
        Employee temp =a;
        a=b;
        b = temp;
        System.out.println("End of method:a=" + a.getName());
        System.out.println("End of method:b=" + b.getName());
    }

    private static void tripleSalary(Employee e) {
        e.raiseSalary(200);
        System.out.println("End of method:salary=" + e.getSalary());
    }

    private static void tripleValue(double x) {
        x *= 3;
        System.out.println("End of method:x=" + x);
    }
}
