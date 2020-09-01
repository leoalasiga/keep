package basic.demo9.demo9_6;

import basic.demo6.demo6_5.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ljj
 * @description This program demonstrates the use of map with key type string and value type employee
 * @date 2020-08-26
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee("Any Lee", 10000));
        staff.put("567-24-2546", new Employee("Harry Hacker", 12000));
        staff.put("157-62-7935", new Employee("Gary Cooper", 15000));
        staff.put("456-62-5527", new Employee("Francesca Cruz", 20000));

        //print all elements
        System.out.println(staff);
//remove an entry
        staff.remove("567-24-2546");
//replace an entry
        staff.put("456-62-5527", new Employee("Francesca Miller", 20000));

        //look up a value
        System.out.println(staff.get("157-62-7935"));

        //iterate through all entries
        staff.forEach((k,v)->{
            System.out.println("key="+k+",value="+v);
        });
    }
}
