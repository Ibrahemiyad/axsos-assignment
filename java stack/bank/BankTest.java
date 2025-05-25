package bank;

public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();

        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        
        account1.deposit("checking", 1000);
        account1.deposit("savings", 500);
        account2.deposit("checking", 2000);
        account2.deposit("savings", 1000);
        account3.deposit("checking", 3000);
        account3.deposit("savings", 1500);
        
        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney

        account1.withdraw("checking", 200);
        account1.withdraw("savings", 100);
        account2.withdraw("checking", 500);
        account2.withdraw("savings", 200);
        account3.withdraw("checking", 1000);
        account3.withdraw("savings", 300);
        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println("Total number of bank accounts: " + BankAccount.getAccounts());
        System.out.println("Total money in all accounts: $" + BankAccount.getTotalMoney());

    }
}