class User:
    def __init__(self, name, balance=0):
        self.name = name
        self.balance = balance
    
    def make_deposit(self, amount):
        self.balance += amount
        return self 
    
    def make_withdrawal(self, amount):
        if amount <= self.balance:
            self.balance -= amount
        else:
            print(f"{self.name}.")
        return self 
    
    def display_user_balance(self):
        print(f"User: {self.name}, Balance: ${self.balance}")
        return self

guido = User("Guido")
guido.make_deposit(100).make_deposit(200).make_deposit(300).make_withdrawal(50).display_user_balance()
