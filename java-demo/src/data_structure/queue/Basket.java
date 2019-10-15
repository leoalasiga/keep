package data_structure.queue;

import java.util.concurrent.*;

/**
 * @ClassName Basket
 * @Description 水果篮子
 * @Author 刘嘉杰
 * @Date 2019/10/10 14:52
 * @Version 1.0
 */
public class Basket {
    /**
     * 篮子,容纳3个水果
     */
    BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);


    /**
     * 生产苹果,将果子放入篮子
     *
     * @throws InterruptedException
     */
    public void produce() throws InterruptedException {
        //put 添加一个元素,如果队列满，则阻塞
        basket.put("An apple");
    }

    /**
     * 取出苹果
     *
     * @return
     * @throws InterruptedException
     */
    public String consume() throws InterruptedException {
        //take 移除并返回队列头部的元素,如果队列为空，则阻塞
        return basket.take();
    }

    /**
     * 获取苹果个数
     *
     * @return
     */
    public int getAppleNumber() {
        return basket.size();
    }


    public static void testBasket() {
        //建立一个果篮子
        final Basket basket = new Basket();

        /**
         * 定义苹果生产者
         */
        class Producer implements Runnable {
            @Override
            public void run() {

                try {
                    while (true) {
                        //生产苹果
                        System.out.println("生产者准备生产苹果:" + System.currentTimeMillis());
                        basket.produce();
                        System.out.println("生产者生产苹果完毕:" + System.currentTimeMillis());
                        System.out.println("生产完成后有苹果:" + basket.getAppleNumber() + "个");
                        //休眠300ms
                        Thread.sleep(300);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 定义苹果消费者
         */
        class Consumer implements Runnable {
            @Override
            public void run() {
                try {
                    while (true) {
                        //消费苹果
                        System.out.println("消费者准备消费苹果:" + System.currentTimeMillis());
                        basket.consume();
                        System.out.println("消费者消费苹果完毕:" + System.currentTimeMillis());
                        System.out.println("消费完成后有苹果" + basket.getAppleNumber() + "个");
                        //休眠1000ms
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        ExecutorService executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        executorService.submit(producer);
        executorService.submit(consumer);
//程序运行十秒
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();
    }

    public static void main(String[] args) {
        Basket.testBasket();
    }
}
