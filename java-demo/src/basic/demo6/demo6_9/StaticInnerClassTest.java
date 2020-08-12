package basic.demo6.demo6_9;

/**
 * @author ljj
 * @description This program demonstrates the use of static inner classes
 * @date 2020-08-12
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }

        ArrayAlg.Pair pair = ArrayAlg.minMax(d);
        System.out.println("min:" + pair.getFirst());
        System.out.println("max:" + pair.getSecond());


    }
}
