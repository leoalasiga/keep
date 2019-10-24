package thread;

/**
 * 守护线程代码示例
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-23 21:34
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread deamon = new Thread(new DemonRunner(), "DaemonRunner");
        //设置为守护线程
        deamon.setDaemon(true);

        deamon.start();
    }

    static class DemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("这里的代码会执行");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("这里的代码在java虚拟机推出时并不执行");
                //因此在构建Deamon线程时，不能依靠finally中的内容来确保执行关闭或者清理资源
            }
        }
    }

}
