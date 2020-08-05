package basic.demo3.demo3_6;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ljj
 * @description This program uses a big numbers to compute the odds of winning the grand prize in a lottery
 * @date 2020-08-05
 */
public class BigIntegerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How much numbers do you want to draw?");

        int k = in.nextInt();

        System.out.println("What's the highest number you can draw?");
        int n = in.nextInt();

        /**
         * compute binomial coefficent n*(n-1)*(n-2)...*(n-k+1)/(1*2*3...*k)
         */

        BigInteger lotteryOdds = BigInteger.ONE;
        for (int i = 1; i <=k; i++) {
            lotteryOdds = lotteryOdds.multiply (BigInteger.valueOf(n - i + 1)) .divide(BigInteger.valueOf(i));
        }

        System.out.println("You odds are 1 in " + lotteryOdds + " .Good luck!");

    }
}
