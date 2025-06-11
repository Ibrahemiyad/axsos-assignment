package bank;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;

    private static int accounts;
    private static double totalMoney;

    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        accounts++;
    }

    //getters
    public double getCheckingBalance() {
        return checkingBalance;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }
    public static int getAccounts() {
        return accounts;
    }
    public static double getTotalMoney() {
        return totalMoney;
    }

    //methods
    public void deposit(String accountType, double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }
        if (accountType.equalsIgnoreCase("checking")) {
            checkingBalance += amount;
        } else if (accountType.equalsIgnoreCase("savings")) {
            savingsBalance += amount;
        } else {
            System.out.println("Invalid account type. Please choose 'checking' or 'savings'.");
            return;
        }
        totalMoney += amount;
        System.out.println("Successfully deposited $" + amount + " into your " + accountType + " account.");
    }
    public void withdraw(String accountType, double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }
        if (accountType.equalsIgnoreCase("checking")) {
            if (amount <= checkingBalance) {
                checkingBalance -= amount;
                totalMoney -= amount;
                System.out.println("Successfully withdrew $" + amount + " from your checking account.");
            } else {
                System.out.println("Insufficient funds in checking account.");
            }
        } else if (accountType.equalsIgnoreCase("savings")) {
            if (amount <= savingsBalance) {
                savingsBalance -= amount;
                totalMoney -= amount;
                System.out.println("Successfully withdrew $" + amount + " from your savings account.");
            } else {
                System.out.println("Insufficient funds in savings account.");
            }
        } else {
            System.out.println("Invalid account type. Please choose 'checking' or 'savings'.");
        }
    }
    public void getBalance() {
        double totalBalance = checkingBalance + savingsBalance;
        System.out.println("Total Balance (Checking + Savings): $" + totalBalance);
    
}
}