package basic.demo3.demo3_3;

import java.util.Scanner;

/**
 * @author ljj
 * @description This program demonstrates a <code>while</code> loop
 * @date 2020-08-05
 */
public class Retirement {
    public static void main(String[] args) {
        //read input
        Scanner scanner = new Scanner(System.in);

        System.out.println("How much money do you need to retire?");
        double goal = scanner.nextDouble();

        System.out.println("How much money do you contribute every year?");
        double payment = scanner.nextDouble();

        System.out.println("Interest rate %:");
        double interestRate = scanner.nextDouble();

        double balance = 0;
        int year = 0;

        //update account balance while goal isn't reached
        while (balance < goal) {
            //add this year's payment and interest
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            year++;
        }

        System.out.println("You can retire in " + year + " years.");
    }
}
