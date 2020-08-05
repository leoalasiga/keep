package basic.demo3.demo3_2;

import java.util.Scanner;

/**
 * @author ljj
 * @description this program demonstrates console input
 * @date 2020-08-04
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //get first input
        System.out.println("What is your name?");
        String name = scanner.nextLine();

        //get second input
        System.out.println("How old are you?");
        int age = scanner.nextInt();

        //display on console
        System.out.println("Hello, " + name + " ,next year,you'll be " + (age + 1));
    }
}
