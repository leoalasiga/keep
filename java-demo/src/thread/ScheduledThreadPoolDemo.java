package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 执行类
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-04 21:34
 */
public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        try {
            System.out.println("Current time:" + WorkThread.getNowDate());

            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000);
                WorkThread workThread = new WorkThread();
                scheduledExecutorService.schedule(workThread, 10, TimeUnit.SECONDS);
            }

            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduledExecutorService.shutdown();

        while (!scheduledExecutorService.isTerminated()) {

        }

        System.out.println("Finish all Threads");

    }
}
