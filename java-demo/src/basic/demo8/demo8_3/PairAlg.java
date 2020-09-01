package basic.demo8.demo8_3;

import basic.demo8.demo8_1.Pair;

/**
 * @author ljj
 * @description
 * @date 2020-08-25
 */
public class PairAlg {
    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }


    public static  void swap(Pair<?> p){
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p){
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
