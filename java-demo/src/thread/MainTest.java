package thread;

/**
 * java线程启动测试
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-23 21:20
 */
public class MainTest {
    public static void main(String[] args) {
        //继承Thread的启动方法
        ThreadByExtend threadByExtend = new ThreadByExtend();
        threadByExtend.start();

        //实现Runnable启动线程的方法
        ThreadByRunnable threadByRunnable = new ThreadByRunnable();
        Thread thread = new Thread(threadByRunnable);
        thread.start();


    }
}
