package basic.demo4.demo4_3;

/**
 * @author ljj
 * @description
 * @date 2020-08-07
 */
public class StaticTest {
    public static void main(String[] args) {

        //fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 40000);
        staff[1] = new Employee("Harry Hacker", 60000 );
        staff[2] = new Employee("Tony Tester", 65000);

        //print information about all Employee object
        for (Employee employee : staff) {
            employee.setId();
            System.out.println("name:"+employee.getName()+",id:"+employee.getId()+",salary:"+employee.getSalary());
        }

        //calls static method
        int nextId = Employee.getNextId();
        System.out.println("Next available id is " + nextId);
    }
}
