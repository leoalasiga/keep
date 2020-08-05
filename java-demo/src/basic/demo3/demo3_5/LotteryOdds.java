package basic.demo3.demo3_5;

import java.util.Scanner;

/**
 * @author ljj
 * @description This program demonstrates a <code>for</code> loop
 * @date 2020-08-05
 */
public class LotteryOdds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How much numbers do you want to draw?");

        int k = in.nextInt();

        System.out.println("What's the highest number you can draw?");
        int n = in.nextInt();


        /**
         * compute binomial coefficent n*(n-1)*(n-2)...*(n-k+1)/(1*2*3...*k)
         */

        int lotteryOdds = 1;
        for (int i = 1; i <=k; i++) {
            lotteryOdds = lotteryOdds * (n - i + 1) / i;
            
        }


        System.out.println("You odds are 1 in " + lotteryOdds + " .Good luck!");
    }
}
