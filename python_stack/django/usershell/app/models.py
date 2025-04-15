from django.db import models

class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    emmail = models.CharField(max_length=255)
    age = models.IntegerField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

# User.objects.create(first_name="ibrahem", last_name="Deek", email="i.deek@gmail.com", age=25)
# User.objects.create(first_name="ahmad", last_name="Deek", email="ahmad.deek@gmail.com", age=25)
# User.objects.create(first_name="ismael", last_name="Deek", email="ismael.deek@gmail.com", age=33)

# User.objects.all()

# User.objects.last()

# User.objects.first()

# c = User.objects.get(id=3)
# c.last_name = 'pancakes'
# c.save()

# c = User.objects.get(id=2)
# c.delete()

# User.objects.all().order_by('first_name')


# User.objects.all().order_by('-first_name')


def create(post):
    return User.objects.create(first_name=post['first_name'],last_name=post['last_name'], emmail=post['email'],age=post['age'])



def get_user(id):
    return User.objects.get(id = id)


def get_all_users():
    return User.objects.all()