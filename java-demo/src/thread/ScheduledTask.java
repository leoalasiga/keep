package thread;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 周期性函数测试类
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-04 21:41
 */
public class ScheduledTask {

    public ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(5);

    public static void main(String[] args) {
        new ScheduledTask();
    }


    public void fixedPeriodSchedule() {
        // 设定可以循环执行的runnable,初始延迟为0，这里设置的任务的间隔为5秒
        for (int i = 0; i < 5; i++) {
            scheduledExecutorService.scheduleAtFixedRate(new FixedSchedule(), 0, 5, TimeUnit.SECONDS);
        }

    }

    public ScheduledTask() {
        fixedPeriodSchedule();
    }

    class FixedSchedule implements Runnable {
        @Override
        public void run() {
            System.out.println("current Thread "+Thread.currentThread().getName()+" ,now time is "+ WorkThread.getNowDate() );
        }
    }
}
