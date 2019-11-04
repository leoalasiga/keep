package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CachedThreadPool：大小无界的线程池，适用于执行很多的短期异步任务的小程序，或者负载较轻的服务器
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-04 21:03
 */
public class CacheThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
