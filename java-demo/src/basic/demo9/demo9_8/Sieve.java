package basic.demo9.demo9_8;

import java.util.BitSet;

/**
 * @author ljj
 * @description This program runs the Sieve of Erathostenes benchmark.It computes all primes up tp 2,000,000
 * @date 2020-08-26
 */
public class Sieve {
    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n + 1);
        int count = 0;
        int i ;
        for (i = 2; i <= n; i++) {
            b.set(i);
        }

        i = 2;
        while (i * i <= n) {
            if (b.get(i)) {
                count++;
                int k = 2 * i;
                while (k <= n) {
                    b.clear(k);
                    k += i;
                }

            }
            i++;

        }

        while (i <= n) {
            if (b.get(i)) {
                count++;
            }

            i++;
        }

        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");
    }
}
