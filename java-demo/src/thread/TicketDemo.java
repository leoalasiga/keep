package thread;

/**
 * 买票的demo
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-23 22:25
 */
public class TicketDemo {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();

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
