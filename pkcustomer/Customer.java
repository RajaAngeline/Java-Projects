package pkcustomer;

import pkaccount.fd.FDAccount;
import pkaccount.sb.SBAccount;
import pkbanking.pkexception.InsufficientFundsException;

import java.util.Scanner;

public class Customer {
    int period,cust_id;
    String name;
    String address;
    double balance;
    double amount;
    boolean f;
    int s;
    Scanner sc = new Scanner(System.in);
    static int sbaccnumber = 8900;
    static int fdaccnumber = 9000;
    SBAccount sbAccount;
    FDAccount fdAccount;
    public Customer(int cust_id, String name, String address) {
        this.cust_id = cust_id;
        this.name = name;
        this.address = address;
    }
    public void createAccount(int type) {
        if (type == 1) {
            sbAccount = new SBAccount(sbaccnumber++,balance);
            System.out.println("Your account has successfully created");
            System.out.println("customer id:"+cust_id+"\t"+"Customer name:"+name);
        } else if (type == 2) {
            System.out.println("Enter a initial deposit amount");
            amount= sc.nextDouble();
            System.out.println("Enter a fixed period");
            period= sc.nextInt();
            fdAccount = new FDAccount(fdaccnumber++, balance,  period);
            System.out.println("Your fdAccount has successfully created");
            System.out.println("customer id :"+cust_id+ "\t"+"Customer name : "+name);
        } else
            System.out.println("Invalid input");
    }

    public void transaction(int type) {
        if (type == 1)
        {
            do {
                System.out.println("Enter a amount to deposit");
                amount = sc.nextDouble();
                s = 0;
                try {
                    sbAccount.deposit(amount);
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae);
                    System.out.println("Again u want to enter the amount to deposit ?:(yes-1/No-0");
                    s = sc.nextInt();
                }
            } while (s==1);
    }

        else if (type == 2) {

            do {
                System.out.println("Enter a amount to withdraw");
                amount = sc.nextDouble();
                f=false;
            try {
                sbAccount.withdraw(amount);
            } catch (InsufficientFundsException ise)
            {
                System.out.println(ise);
                System.out.println("Again u want to enter the amount to withdraw ?:(yes-true/No-false");
                f = sc.nextBoolean();
            }
        }while(f);
            }

        else if (type == 3) {
            sbAccount.calc_interest();
            System.out.println("Your calculated interested amount" + balance);
        } else if (type == 4) {

            fdAccount.close();
        } else
            System.out.println("Invalid Input type");


    }
}
