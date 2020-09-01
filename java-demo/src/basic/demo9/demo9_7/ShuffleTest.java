package basic.demo9.demo9_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ljj
 * @description This program demonstrates the random shuffle  and sort algorithms
 * @date 2020-08-26
 */
public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <=49; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
