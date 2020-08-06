package basic.demo3.demo3_7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ljj
 * @description this program demonstrate array manipulation
 * @date 2020-08-06
 */
public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How much numbers do you want to draw?");
        int k = in.nextInt();

        System.out.println("What's the highest number you can draw?");
        int n = in.nextInt();

        //fill an array with numbers 1,2,3,4...n
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        //draw k number and put them into second array
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            //make a random index between 0~n-1
            int r = (int) (Math.random() * n);
            //pick the element at the random location
            result[i] = numbers[r];

            //move the last element into the random location
            numbers[r] = numbers[n - 1];
            n--;
        }

        //print the sorted array
        Arrays.sort(result);

        System.out.println("Bet the following combination, It'll make you rich!");
        System.out.println(Arrays.toString(result));
    }
}
