package basic.demo14.demo14_10;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
            MatchCounter counter = new MatchCounter(new File(directory), keyword);

            FutureTask<Integer> task = new FutureTask<>(counter);
            new Thread(task).start();

            try {
                System.out.println(task.get()+" matching files.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
