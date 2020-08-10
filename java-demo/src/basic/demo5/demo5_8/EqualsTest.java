package basic.demo5.demo5_8;


import basic.demo5.demo5_10.Manager;
import basic.demo5.demo5_9.Employee;

/**
 * @author ljj
 * @description This program demonstrates the equals method
 * @date 2020-08-10
 */
public class EqualsTest {
    public static void main(String[] args) {
        Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee bob = new Employee("Bob Brandson", 5000, 1989, 10, 1);


        System.out.println("alice1==alice2:" + (alice1 == alice2));
        System.out.println("alice1==alice3:" + (alice1 == alice3));
        System.out.println("alice1.equals(alice2):" + (alice1.equals(alice2)));
        System.out.println("alice1.equals(alice3):" + (alice1.equals(alice3)));
        System.out.println("alice1.equals(bob):" + (alice1.equals(bob)));

        System.out.println("bob.toString():" + bob.toString());

        Manager carl = new Manager("Carl Clark",80000,1994,8,22);
        Manager boss = new Manager("Carl Clark", 80000, 1994, 8, 22);
        boss.setBonus(5000);

        System.out.println("boss.toString():" + boss.toString());
        System.out.println("carl.equals(boss):" + (carl.equals(boss)));
        System.out.println("alice1.hashCode()" + alice1.hashCode());
        System.out.println("alice3.hashCode()" + alice3.hashCode());
        System.out.println("bob.hashCode()" + bob.hashCode());
        System.out.println("carl.hashCode()" + carl.hashCode());

    }
}
