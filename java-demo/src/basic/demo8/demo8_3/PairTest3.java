package basic.demo8.demo8_3;

import basic.demo5.demo5_10.Manager;
import basic.demo5.demo5_9.Employee;
import basic.demo8.demo8_1.Pair;

/**
 * @author ljj
 * @description
 * @date 2020-08-25
 */
public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);

        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);

        Manager[] managers = {ceo, cfo};
        Pair<Employee> result = new Pair<>();
        minMaxBonus(managers, result);
        System.out.println("first:" + result.getFirst().getName() + ",second:" + result.getSecond().getName());
        maxMinBonus(managers, result);
        System.out.println("first:" + result.getFirst().getName() + ",second:" + result.getSecond().getName());


    }


    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName()+" and "+second.getName()+ " are buddies;");
    }


    public static void minMaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a.length != 0) {
            Manager min = a[0];
            Manager max = a[0];
            for (int i = 0; i < a.length; i++) {
                if (min.getSalary() > a[i].getSalary()) {
                    min = a[i];
                }


                if (max.getSalary() < a[i].getSalary()) {
                    max = a[i];
                }

            }


            result.setFirst(min);
            result.setSecond(max);
        }

    }


    public static void maxMinBonus(Manager[] a, Pair<? super Manager> result) {
        minMaxBonus(a, result);
        PairAlg.swapHelper(result);

    }
}
