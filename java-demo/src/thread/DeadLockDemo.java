package thread;

/**
 * 死锁示例
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-31 21:42
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                synchronized (B) {
                    System.out.println("1");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println(2);
                    }
                }

            }
        });

        t1.start();
        t2.start();
    }


    public static void main(String[] args) {
        DeadLockDemo deadLockDemo = new DeadLockDemo();
        while (true) {

            deadLockDemo.deadLock();
        }
    }
}
