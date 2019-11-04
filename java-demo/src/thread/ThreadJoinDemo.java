package thread;

/**
 * join案例
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-31 22:12
 */
public class ThreadJoinDemo {
    public static void main(String[] args) {
        Thread previous = new Thread();
        for (int i = 0; i < 10; i++) {
            //每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;

        }
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }

}

class Domino implements Runnable {
    private Thread thread;

    public Domino(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"线程结束");

    }
}
