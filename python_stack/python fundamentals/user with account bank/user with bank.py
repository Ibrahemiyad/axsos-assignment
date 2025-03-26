class BankAccount:
    def __init__(self, balance=0, interest_rate=0.01):
        self.balance = balance
        self.interest_rate = interest_rate

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        if amount <= self.balance:
            self.balance -= amount
        return self

    def display_balance(self):
        print(f"Balance: {self.balance}")
        return self

class User:
    def __init__(self, name):
        self.name = name
        self.accounts = {}
    
    def add_account(self, account_name, balance=0, interest_rate=0.01):
        self.accounts[account_name] = BankAccount(balance, interest_rate)
        return self
    
    def make_deposit(self, account_name, amount):
        if account_name in self.accounts:
            self.accounts[account_name].deposit(amount)
        else:
            print(f"Account '{account_name}' not found.")
        return self
    
    def make_withdrawal(self, account_name, amount):
        if account_name in self.accounts:
            self.accounts[account_name].withdraw(amount)
        else:
            print(f"Account '{account_name}' not found.")
        return self
    
    def display_user_balance(self, account_name):
        if account_name in self.accounts:
            print(f"User: {self.name}, Account: {account_name}")
            self.accounts[account_name].display_balance()
        else:
            print(f"Account '{account_name}' not found.")
        return self

# Example usage
guido = User("Guido")
guido.add_account("Checking", 500).add_account("Savings", 1000)
guido.make_deposit("Checking", 200).make_withdrawal("Savings", 150).display_user_balance("Checking").display_user_balance("Savings")
