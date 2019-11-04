package thread;

/**
 * TODO
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-04 20:39
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int task = 0;
    private final int id = task++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + ") ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
