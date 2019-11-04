package thread;

/**
 * 单生产者单消费者模式
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-29 21:05
 */
public class SingleProducerConsumer2 {

    public static void main(String[] args) {
        RoastDuckByLock duckByLock = new RoastDuckByLock();
        Producer2 producer = new Producer2(duckByLock);
        Consumer2 consumer = new Consumer2(duckByLock);

        //生产者线程
        Thread produceThread = new Thread(producer);

        //消费者线程
        Thread consumeThread = new Thread(consumer);

        //启动线程
        consumeThread.start();
        produceThread.start();
    }
}

/**
 * 消费者线程
 */
class Producer2 implements Runnable {
    private RoastDuckByLock resource;

    public Producer2(RoastDuckByLock resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        while (true) {
            resource.product("北京烤鸭");
        }

    }
}

class Consumer2 implements Runnable {

    private RoastDuckByLock resource;

    public Consumer2(RoastDuckByLock resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            resource.consume();

        }
    }
}