package basic.demo4.demo4_6;


/**
 * @author ljj
 * @description This program demonstrates object construction
 * @date 2020-08-07
 */
public class ConstructorTest {
    public static void main(String[] args) {
        //fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 40000);
        staff[1] = new Employee(60000 );
        staff[2] = new Employee();

        //print information about all Employee object
        for (Employee employee : staff) {
            System.out.println("name:"+employee.getName()+",id:"+employee.getId()+",salary:"+employee.getSalary());
        }
    }
}
