package pkbanking.pkinterface;

import pkbanking.pkexception.InsufficientFundsException;

public interface Transaction {
     double min_balance=500;
    void withdraw(double amount) throws InsufficientFundsException;

    void deposit(double amount) throws IllegalArgumentException;
}
