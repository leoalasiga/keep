package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadExecutor：适用于需要保证执行顺序地执行各个任务；并且在任意时间点，不会有多个线程是活动的场景。
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-04 21:06
 */
public class SingleThreadExecutorDemo {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 2; i++) {
            executorService.execute(new LiftOff());

        }

        executorService.shutdown();
    }
}
