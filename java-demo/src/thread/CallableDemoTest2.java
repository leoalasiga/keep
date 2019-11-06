package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Callable + FutureTask
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-04 22:45
 */
public class CallableDemoTest2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callableDemo);

        executorService.submit(futureTask);

        executorService.shutdown();

        try {
            Thread.sleep(2000);
            System.out.println("主线程在执行其他任务");

            if(futureTask.get()!=null){
                //输出获取到的结果
                System.out.println("futureTask.get()-->"+futureTask.get());
            }else{
                //输出获取到的结果
                System.out.println("futureTask.get()未获取到结果");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程在执行完成");

    }
}
