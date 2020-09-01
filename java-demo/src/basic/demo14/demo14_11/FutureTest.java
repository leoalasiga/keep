package basic.demo14.demo14_11;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author ljj
 * @description
 * @date 2020-08-31
 */
public class FutureTest {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory(e.g. /opt/jdk1.8.0/src):");
            String directory = in.nextLine();
            System.out.println("Enter keyword(e.g. volatile):");
            String keyword = in.nextLine();
            ExecutorService pool = Executors.newCachedThreadPool();
            MatchCounter counter = new MatchCounter(new File(directory), keyword,pool);

            Future<Integer> result = pool.submit(counter);

            try {
                System.out.println(result.get()+" matching files.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            pool.shutdown();
            int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("largestPoolSize:"+largestPoolSize);
        }

    }
}
