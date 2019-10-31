package thread;

/**
 * TODO
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-29 20:37
 */
public class RoastDuckResource {
    private String name;
    /**
     * 烤鸭初始数量
     */
    private int count = 0;
    /**
     * 判断是否有需要线程等待的标志
     */
    private boolean flag = false;

    public synchronized void product(String name) {
        if (flag) {
            //此时有烤鸭，等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        count++;
        //设置烤鸭名称
        this.name = name + count;

        System.out.println(Thread.currentThread().getName() + "...product..." + this.name);
        //有烤鸭设置为true
        flag = true;
        //通知线程可以消费了
        notifyAll();

    }

    public synchronized void consume() {
        if (!flag) {
            //如果没有烤鸭就等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "...consume..." + this.name);
        flag = false;
        notifyAll();

    }

}
