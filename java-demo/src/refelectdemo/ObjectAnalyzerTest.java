package refelectdemo;

import java.util.ArrayList;

/**
 * this project use reflect to spy on objects
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2020-06-06 14:25
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            squares.add(i * i);
        }

        System.out.println(new ObjectAnalyzer().toString(squares));

    }
}
