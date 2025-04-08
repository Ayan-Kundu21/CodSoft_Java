import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
    public double getBalance() {
        return balance;
    }
}
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> handleWithdraw();
                case 2 -> handleDeposit();
                case 3 -> handleCheckBalance();
                case 4 -> System.out.println("Thank you for using the ATM. Goodbye!");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }
    private void showMenu() {
        System.out.println("\n===== ATM Menu =====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed. Check amount or balance.");
        }
    }
    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit failed. Enter a valid amount.");
        }
    }
    private void handleCheckBalance() {
        System.out.printf("Your current balance is: %.2f\n", account.getBalance());
    }
}
public class ATMApp {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
