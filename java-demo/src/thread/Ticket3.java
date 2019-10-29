package thread;

/**
 * 卖票程序3，通过synchronized关键字解决线程的同步问题
 *
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-28 21:32
 */
public class Ticket3 implements Runnable{

    private int num = 100;

    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (num > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "...sale..." + num--);
                }
            }
        }

    }
}
