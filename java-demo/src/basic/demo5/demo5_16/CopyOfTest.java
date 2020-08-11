package basic.demo5.demo5_16;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ljj
 * @description This program demonstrates the use of reflection for manipulation arrays
 * @date 2020-08-11
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));


        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception.");
        b = (String[]) badCopyOf(b, 10);
    }

    /**
     * this method attempt to grow an array by allocating a new array and copying all elements
     * @param a
     * @param newLength
     * @return
     */
    public static Object[] badCopyOf(Object[] a, int newLength) {
        //not useful
        Object[] newArr = new Object[newLength];
        System.arraycopy(a, 0, newArr, 0, Math.min(a.length, newLength));
        return newArr;
    }

    /**
     * this method  grows an array by allocating a new array of the same type and copy all elements
     * @param a
     * @param newLength
     * @return
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class<?> cl = a.getClass();
        if (!cl.isArray()) {
            return null;
        }

        Class<?> componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArr = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArr, 0, Math.min(length, newLength));
        return newArr;
    }
}
