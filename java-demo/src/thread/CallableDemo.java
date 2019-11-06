package thread;

import java.util.concurrent.Callable;

/**
 * TODO
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-04 22:20
 */
public class CallableDemo implements Callable<Integer> {
    private int sum;

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable's thread start calculating");
        Thread.sleep(200);
        for (int i = 0; i < 5000; i++) {
            sum = sum + i;
        }

        System.out.println("Callable's thread end");

        return sum;
    }
}
