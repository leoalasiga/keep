package basic.demo6.demo6_9;

/**
 * @author ljj
 * @description
 * @date 2020-08-12
 */
public class ArrayAlg {

    public static class Pair {
        private double first;
        private double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }


    public static Pair minMax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double  max= Double.NEGATIVE_INFINITY;

        for (double value : values) {
            if (min > value) {
                min=value;
            }
            if (max < value) {
                max = value;
            }
        }

        return new Pair(min, max);
    }
}
