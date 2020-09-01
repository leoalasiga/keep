package basic.demo14.demo14_6;

import java.util.Arrays;

/**
 * @author ljj
 * @description A bank with a number of bank accounts
 * @date 2020-08-27
 */
public class Bank {
    private final double[] accounts;


    /**
     * constructs the bank
     * @param n
     * @param initialBalance
     */
    public Bank(int n,double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Transfers money from one account to another
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }

        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d%n", amount, from, to);
        accounts[to] += amount;
        System.out.printf("Total Balance:%10.2f%n", getTotalBalance());

    }

    /**
     * Gets the sum of all account balance
     * @return
     */
    private double getTotalBalance() {
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }

    /**
     * get the number of account in the bank
     * @return
     */
    public int size() {

        return accounts.length;
    }
}
