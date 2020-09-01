package basic.demo14.demo14_9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * @author ljj
 * @description
 * @date 2020-08-31
 */
public class BlockingQueueTest {
    public static final int FILE_QUEUE_SIZE = 10;
    public static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory(e.g. /opt/jdk1.8.0/src):");
            String directory = in.nextLine();
            System.out.println("Enter keyword(e.g. volatile):");
            String keyword = in.nextLine();

            Runnable enumerator = () -> {
                try {
                    enumerate(new File(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            new Thread(enumerator).start();

            for (int i = 1; i <= SEARCH_THREADS; i++) {
                Runnable search = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            File file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else {
                                search(file, keyword);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
                new Thread(search).start();
            }
        }
    }

    /**
     * Search a file for a given keyword and prints all matching lines
     *
     * @param file
     * @param keyword
     */
    private static void search(File file, String keyword) throws FileNotFoundException {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        }
    }

    /**
     * Recursively enumerates all files in a given directory and its subdirectory
     *
     * @param directory
     */
    private static void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumerate(file);
            } else {
                queue.put(file);
            }
        }
    }

}
