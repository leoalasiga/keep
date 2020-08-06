package basic.demo3.demo3_8;

/**
 * @author ljj
 * @description this program shows hot to store tabular data in 2D array
 * @date 2020-08-06
 */
public class CompoundInterest {
    public static void main(String[] args) {
        final double STRATERATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        //set interest rate to 10...15%
        double[] interestRate = new double[NRATES];
        for (int i = 0; i < interestRate.length; i++) {
            interestRate[i] = (STRATERATE + i) / 100.0D;
        }

        double[][] balances = new double[NYEARS][NRATES];

        //set initial balance to 10000
        for (int i = 0; i < balances[0].length; i++) {
            balances[0][i] = 10000;
        }


        //compute interest for future years;
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
               //get last year's balances from previous row
                double oldBalances = balances[i-1][j] ;
                //compute interest
                double interest = oldBalances * interestRate[j];
                //compute this year's balances
                balances[i][j] = oldBalances + interest;
            }
        }


        //print one row of interest rates
        for (int i = 0; i < interestRate.length; i++) {
            System.out.printf("%9.0f%%", 100 * interestRate[i]);

        }

        System.out.println();

        //print balance table
        for (double[] balance : balances) {
            for (double v : balance) {
                System.out.printf("%10.2f", v);
            }
            System.out.println();
        }
    }
}
