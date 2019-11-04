package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool：适用于为了满足资源管理需求，而需要限制当前线程的数量的应用场景，它适用于负载比较重的服务器
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-04 20:44
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }

        executorService.shutdown();
    }
}
