package refelectdemo;

import java.lang.reflect.Array;

/**
 * this program demonstrates the use of reflection for manipulation arrays
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2020-06-06 20:05
 */
public class CopyOfTest {
    public static void main(String[] args) {

    }


    /**
     * this method attempt to grow an array by allocation a new array and copy all elements
     * @param a
     * @param newLength
     * @return
     */
    public  static Object[] badCopy (Object[] a,int newLength) {
        Object[] newArr = new Object[newLength];
        System.arraycopy(a, 0, newArr, 0, Math.min(a.length, newLength));
        return newArr;
    }

    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();

        if (!cl.isArray()) {
            return null;
        }

        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArr = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArr, 0, Math.min(length, newLength));
        return newArr;
    }

}
