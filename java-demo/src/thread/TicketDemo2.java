package thread;

/**
 * 卖票程序升级版测试,由于卖票程序的加锁，是的不会出现多卖票的情况
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-24 22:25
 */
public class TicketDemo2 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();

        //4个线程同时卖票
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);
        Thread thread4 = new Thread(ticket);

        //start Thread

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
