package basic.demo9.demo9_5;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * @author ljj
 * @description This program demonstrates the use of priority queue
 * @date 2020-08-26
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(LocalDate.of(1906, 12, 9));
        priorityQueue.add(LocalDate.of(1815, 12, 10));
        priorityQueue.add(LocalDate.of(1903, 12, 3));
        priorityQueue.add(LocalDate.of(1910, 6, 22));

        System.out.println("Iterating over elements");
        for (LocalDate date : priorityQueue) {
            System.out.println(date);
        }

        System.out.println("removing elements");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}
