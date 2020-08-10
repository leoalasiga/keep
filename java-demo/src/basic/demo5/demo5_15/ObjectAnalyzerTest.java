package basic.demo5.demo5_15;

import java.util.ArrayList;

/**
 * @author ljj
 * @description This program use reflection to spy on objects
 * @date 2020-08-10
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }

        System.out.println(new ObjectAnalyzer().toString(squares));

    }
}
