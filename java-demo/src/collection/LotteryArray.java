package collection;

import java.util.function.DoubleToIntFunction;

/**
 * TODO
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2020-04-02 21:28
 */
public class LotteryArray {
    public static void main(String[] args) {
        final  int NMAX = 10;
        int[][] odds = new int[NMAX+1][];
        for (int i = 0; i <= NMAX; i++) {
            odds[i] = new int[i + 1];
        }


        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                int lotteryOdds =1;
                for (int k = 1; k <=j; k++) {
                    lotteryOdds = lotteryOdds * (i - k + 1) / k;
                }
                odds[i][j] = lotteryOdds;
            }
        }


        for (int[] odd : odds) {
            for (int i : odd) {
                System.out.printf("%4d", i);
            }
            System.out.println();

        }
    }
}
