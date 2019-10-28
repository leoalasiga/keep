package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 卖票程序升级版，解决上个版本的安全性问题
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-24 22:03
 */
public class Ticket2 implements Runnable {
    /**
     * 创建锁对象
     */
    private Lock ticketLock = new ReentrantLock();
    /**
     * 当前所有的票数
     */
    private int num = 100;

    @Override
    public void run() {
        while (true) {
            //获取锁
            ticketLock.lock();
            try {
                if (num > 0) {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "....sale...." + num--);
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                //出现异常中断
                Thread.currentThread().interrupt();
            } finally {
                //释放锁
                ticketLock.unlock();
            }

        }
    }
}

