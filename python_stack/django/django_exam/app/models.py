from django.db import models
import bcrypt
import re
# Create your models here.
class UserManager(models.Manager):
    def validate_login(self, postData):
        errors = {}
        if len(postData['email']) < 5:
            errors['email'] = "Email must be at least 5 characters"
        return errors
    def validate_register(self, postData):
        errors = {}
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if len(postData['first_name']) < 2:
            errors['first_name'] = "First name must be at least 2 characters"
        if len(postData['last_name']) < 2:
            errors['last_name'] = "Last name must be at least 2 characters"
        if User.objects.filter(email=postData['email']).exists():
            errors['email'] = "Email already in use"
        if not EMAIL_REGEX.match(postData['email']):
            errors['email'] = "Invalid email address"
        if len(postData['password']) < 8:
            errors['password'] = "Password must be at least 8 characters"
        if postData['password'] != postData['confirm_password']:
            errors['password'] = "Passwords do not match"
        return errors
    
class ProjectManager(models.Manager):
    def validate_book(self, postData):
        errors = {}
        if len(postData['name']) < 1:
            errors['name'] = "Title must be at least 2 characters"
        if len(postData['description']) < 5:
            errors['description'] = "Description must be at least 10 characters"
        return errors

class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.EmailField()
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()

    def get_user_by_id(user_id):
        return User.objects.get(id=user_id)

class Project(models.Model):
    name = models.CharField(max_length=255)
    description = models.TextField()
    start_date = models.DateField()
    end_date = models.DateField()
    creator = models.ForeignKey(User, related_name="projects_created", on_delete=models.CASCADE)
    team_members = models.ManyToManyField(User, related_name="projects_joined")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = ProjectManager()




def register_user(first_name, last_name, email, password):
    hashed = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
    user = User.objects.create(first_name=first_name, last_name=last_name, email=email, password=hashed)
    return user
