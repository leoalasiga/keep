package basic.demo5.demo5_17;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ljj
 * @description This program shows how to invoke method through reflection
 * @date 2020-08-11
 */
public class MethodTableTest {
    public static void main(String[] args) throws Exception {

        //get method pointers to the square and sqrt methods
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);


        //print tables of x- and y-values
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    /**
     * Return the square of a number
     * @param x
     * @return
     */
    public static double square(double x) {
        return x * x;
    }

    /**
     * Print a table with x- and y-values for a method
     */
    public static void printTable(double from, double to, int n, Method method) {
        //print out the method name as table header
        System.out.println(method);

        double dx = (to - from) / (n - 1);
        for (double x = from; x <= to; x += dx) {
            try {
                Double y =  (Double)method.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

}
