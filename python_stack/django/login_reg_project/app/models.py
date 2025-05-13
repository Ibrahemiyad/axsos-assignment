from django.db import models
import re
import bcrypt

class UserManager(models.Manager):
    def validator(self, post_data):
        errors = {}

        if len(post_data['first_name']) < 2 or not post_data['first_name']:
            errors['first_name'] = "First name must be at least 2 characters and contain only letters."

        if len(post_data['last_name']) < 2 or not post_data['last_name']:
            errors['last_name'] = "Last name must be at least 2 characters and contain only letters."

        EMAIL_REGEX = re.compile(r'^[\w\.-]+@[\w\.-]+\.\w+$')
        if not EMAIL_REGEX.match(post_data['email']):
            errors['email'] = "Invalid email format."

        if len(post_data['password']) < 8:
            errors['password'] = "Password must be at least 8 characters."
        if post_data['password'] != post_data['confirm_password']:
            errors['confirm_password'] = "Passwords must match."

        return errors

class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255, unique=True)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()



def create(post):
    salt = bcrypt.gensalt()
    hashed_password = bcrypt.hashpw(post['password'].encode(), salt)

    user =User.objects.create(
    first_name=post['first_name'],
    last_name=post['last_name'],
    email=post['email'],
    password=hashed_password.decode()  
    )
    return user

def get(post):
    user = User.objects.get(email=post['email'])
    if bcrypt.checkpw(post['password'].encode(), user.password.encode()):
        return user