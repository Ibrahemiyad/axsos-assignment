class user:
    def __init__(self,name, email,phonenumber,account_balance=0):
        self.name=name
        self.email=email
        self.phonenumber=phonenumber
        self.account_balance=account_balance  
 
 
    def make_withdraw(self,amount):
        self.account_balance -= amount
   
 
 
    def display(self):
        print(self.name," ",self.account_balance)      
 
 
    def transfer_money(self,other_user,amount):
        self.account_balance-=amount
        other_user.account_balance +=amount
 
 
user1=user("bahaa", "b@gmail.com", "059988776655",1000 )
user2=user("ibrahim", "i.d@gmail.com", "0592997163",2000)
user1.make_withdraw(100)
user1.display()
user1.transfer_money(user2,200)
user1.display()
user2.display()
 