package thread;

/**
 * 模拟买票线程
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-23 22:21
 */
public class Ticket implements Runnable{

    /**
     * 当前拥有的票数
     */
    private int num = 100;

    @Override
    public void run() {
        while (true) {
            if (num > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " ....sale.... " + num--);
            }
        }

    }
}
