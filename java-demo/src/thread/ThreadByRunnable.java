package thread;

/**
 * 实现Runnable来实现线程
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-23 20:03
 */
public class ThreadByRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("I'm the Thread that implements Runnable");
    }
}
