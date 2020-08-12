package basic.demo6.demo6_6;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @author ljj
 * @description This program demonstrates the use of lambda expressions
 * @date 2020-08-12
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury"
                , "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println("Sorted by length:");
        Arrays.sort(planets, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(planets));

        Timer timer = new Timer(1000, event -> System.out.println("The time is" + new Date()));

        timer.start();
        //keep program running until enter ok
        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);

    }
}
