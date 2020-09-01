package basic.demo14.demo14_8;

import java.util.Arrays;

/**
 * @author ljj
 * @description A bank with a number of bank accounts that use synchronization primitives
 * @date 2020-08-27
 */
public class Bank {
    private final double[] accounts;


    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
            while (accounts[from] < amount) {
             wait();
            }


            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d%n", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance:%10.2f%n", getTotalBalance());
          notifyAll();
    }

    /**
     * Gets the sum of all account balance
     *
     * @return
     */
    private synchronized double getTotalBalance() {
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
    }

    /**
     * get the number of account in the bank
     *
     * @return
     */
    public int size() {

        return accounts.length;
    }
}
