package thread;

/**
 * 单生产者单消费者模式
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-10-29 21:05
 */
public class SingleProducerConsumer {

    public static void main(String[] args) {
        RoastDuckResource duckResource = new RoastDuckResource();
        Producer producer = new Producer(duckResource);
        Consumer consumer = new Consumer(duckResource);

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
class Producer implements Runnable {
    private RoastDuckResource resource;

    public Producer(RoastDuckResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

        while (true) {
            resource.product("北京烤鸭");
        }

    }
}

class Consumer implements Runnable {

    private RoastDuckResource resource;

    public Consumer(RoastDuckResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            resource.consume();

        }
    }
}