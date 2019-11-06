package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable + Future
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-04 22:22
 */
public class CallableDemoTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CallableDemo callableDemo = new CallableDemo();
        Future<Integer> future = executorService.submit(callableDemo);
        executorService.shutdown();

        try {
            Thread.sleep(2000);
            System.out.println("main thread is doing other job");
            if (future.get() != null) {
                System.out.println("future.get()->" + future.get());
            } else {
                System.out.println("future.get can not get result");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("main thread finish");
    }
}
