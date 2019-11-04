package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过对象锁实现线程的通知|等待机制
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-31 20:55
 */
public class RoastDuckByLock {

    private String name;
    private int count = 0;
    private boolean flag = false;

    /**创建锁对象*/
    private Lock lock = new ReentrantLock();
    /**
     * 创建条件对象
     */
    private Condition condition = lock.newCondition();

    /**
     * 生产烤鸭
     */
    public void product(String name) {
        lock.lock();

        try {
            if (flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            count++;
            this.name = name + count;
            System.out.println(Thread.currentThread().getName() + "...product..." + this.name);
            flag = true;
            //通知线程可以消费了
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }


    public void consume() {
        lock.lock();

        try {
            if (!flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println(Thread.currentThread().getName() + "...consume..." + this.name);
            flag = false;
            //通知线程可以消费了
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
