package pkaccount.sb;
import pkaccount.*;
import pkbanking.pkexception.InsufficientFundsException;
import pkbanking.pkinterface.InterestRate;
import pkbanking.pkinterface.Transaction;

public class SBAccount extends Account implements Transaction, InterestRate {
    public SBAccount(int accNumber, double balance) {
        super(accNumber, balance);
    }

    public void calc_interest() {
        balance += balance * sbrate * 1;
    }


    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance - amount > min_balance) {
            System.out.println("your previous balance" + balance);
            balance -= amount;
            System.out.println(" your current balance" + balance);
        } else {
            throw new InsufficientFundsException("invalid amount to withdraw");
        }
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("invalid amount");
        } else {
            balance += amount;
            System.out.println("Your new balance:" + balance);
        }
    }
}

