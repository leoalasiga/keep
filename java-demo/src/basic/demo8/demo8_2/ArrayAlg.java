package basic.demo8.demo8_2;

import basic.demo8.demo8_1.Pair;

/**
 * @author ljj
 * @description
 * @date 2020-08-25
 */
public class ArrayAlg {
    /**
     * Gets the minimum and maximum of an arrays of string
     * @param a
     * @return
     */
    public static <T extends Comparable> Pair<T> minMax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }


        T min = a[0];
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }

            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }

        return new Pair<T>(min, max);
    }
}
