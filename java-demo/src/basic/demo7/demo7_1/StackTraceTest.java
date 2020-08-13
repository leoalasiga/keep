package basic.demo7.demo7_1;

import java.util.Scanner;

/**
 * @author ljj
 * @description A program that displays a trace feature of a recursive method call
 * @date 2020-08-13
 */
public class StackTraceTest {
    /**
     * Compute the factorial of a number
     * @param n
     * @return
     */
    public static int factorial(int n) {
        System.out.println("factorial(" + n + ")");
        Throwable t = new Throwable();
        StackTraceElement[] stackTrace = t.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement);
        }

        int r;
        if (n <= 1) {
            r = 1;
        }else {
            r = n * factorial(n - 1);
        }

        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = in.nextInt();
        factorial(n);
    }
}

