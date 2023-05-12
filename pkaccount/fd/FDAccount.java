package pkaccount.fd;

import pkaccount.Account;
import pkbanking.pkinterface.InterestRate;

public class FDAccount extends Account implements InterestRate {
    int period;

    public FDAccount(int accNumber, double balance, int period) {
        super(accNumber, balance);
        this.period = period;
    }
    public double calc_interest()
    {

        return balance = balance*fdrate*period;
    }
    public void close()
    {
         balance+=calc_interest();
        System.out.println("Your maturity amount"+balance);
        System.out.println("Your fdAccount is closed successfully");

    }
}
