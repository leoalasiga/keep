package thread;

/**
 * 通过继承Thread实现线程
 */
public class ThreadByExtend extends Thread {

    @Override
    public void run() {
        System.out.println("I'm a thread that extends Thread");
    }
}
