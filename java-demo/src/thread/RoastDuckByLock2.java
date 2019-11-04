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
public class RoastDuckByLock2 {

    private String name;
    private int count = 0;
    private boolean flag = false;

    /**创建锁对象*/
    private Lock lock = new ReentrantLock();
    /**
     * 通过已有的锁获取两组监视器，一组监视生产者，一组监视消费
     */
    private Condition produceCondition = lock.newCondition();
    private Condition consumeCondition = lock.newCondition();

    /**
     * 生产烤鸭
     */
    public void product(String name) {
        lock.lock();

        try {
            if (flag) {
                try {
                    produceCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            count++;
            this.name = name + count;
            System.out.println(Thread.currentThread().getName() + "...product..." + this.name);
            flag = true;
            //通知线程可以消费了
            consumeCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }


    public void consume() {
        lock.lock();

        try {
            if (!flag) {
                try {
                    consumeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println(Thread.currentThread().getName() + "...consume..." + this.name);
            flag = false;
            //通知线程可以消费了
            produceCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
