package basic.demo14.demo14_12;

import java.util.concurrent.ForkJoinPool;

/**
 * @author ljj
 * @description This program demonstrates the fork-join framework
 * @date 2020-08-31
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        final int SIZE =1000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i <SIZE; i++) {
            numbers[i] = Math.random();
        }

        Counter counter = new Counter(numbers, 0, SIZE, x -> x > 0.5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());

    }
}
