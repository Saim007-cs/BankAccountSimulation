import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;


    public Account(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance ₹" + initialBalance);
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited ₹" + amount);
            System.out.println("Deposited: ₹" + amount + " | New Balance: ₹" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }


    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawn ₹" + amount);
            System.out.println("Withdrawn: ₹" + amount + " | New Balance: ₹" + balance);
        }
    }


    public double getBalance() {
        return balance;
    }


    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println((i + 1) + ". " + transactionHistory.get(i));
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();

        System.out.print("Enter initial balance: ₹");
        double initialBalance = sc.nextDouble();

        Account account = new Account(name, accNum, initialBalance);


        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmt = sc.nextDouble();
                    account.deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmt = sc.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;
                case 3:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;
                case 4:
                    account.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();


    }
}