import pkcustomer.Customer;


import java.util.Scanner;

public class BankDemo {
    public static void main(String ...arg)
    {
    int i=0;
    int cd=0;
    String name;
    String address;
    int ch,ch1,ch2,ch3;
    Customer customer[] = new Customer[5];
        Scanner sc =new Scanner(System.in);
        do {
            System.out.println("create sbAccount -----> 1");
            System.out.println("create fdAccount ------> 2");
            System.out.println("exit---->3");
            System.out.println("Enter a number");
            ch=sc.nextInt();
            switch (ch)
            {
                case 1 :
                    System.out.println("New  sbAccount -----> 1");
                    System.out.println("Existing  sbAccount ------> 2");
                    System.out.println("exit---->3");
                    System.out.println("Enter your option");
                    ch1 = sc.nextInt();
                    switch (ch1) {
                        case 1:
                            System.out.println("Enter  your name and address");
                            name = sc.next();
                            address = sc.next();
                            customer[i] = new Customer( cd++, name, address);
                            customer[i++].createAccount(1);
                            break;
                        case 2:
                            System.out.println("Enter your customer id");
                            cd = sc.nextInt();
                            System.out.println("Deposit -----> 1");
                            System.out.println("Withdraw ------> 2");
                            System.out.println("calculate Interest---->3");
                            System.out.println("exit ----->4");
                            System.out.println("Enter your option");
                            ch2 = sc.nextInt();
                            switch (ch2) {
                                case 1:
                                    customer[cd].transaction(1);
                                    break;
                                case 2:
                                    customer[cd].transaction(2);
                                    break;
                                case 3:
                                    customer[cd].transaction(3);
                                    break;
                                default:
                                    System.err.println("Invalid option");
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("New fdAccount--->1");
                    System.out.println("Existing  fdAccount ------> 2");
                    System.out.println("exit---->3");
                    System.out.println("Enter your option");
                    ch3= sc.nextInt();
                    switch(ch3) {
                        case 1:
                            System.out.println("Enter  customer name and address");
                            name = sc.next();
                            address = sc.next();
                            customer[i] = new Customer(  cd ++,  name,address);
                            customer[i++].createAccount(2);
                            break;
                        case 2:
                            System.out.println("Enter your customer id");
                            customer[cd].transaction(4);
                            break;
                        case 3:
                            break;
                        default:
                            System.err.println("Invalid option");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }while(ch != 3);
        }
}
