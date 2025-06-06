from django.db import models

# Create your models here.
class Dojo(models.Model):
    name=models.CharField(max_length=255)
    city=models.CharField(max_length=255)
    state=models.CharField(max_length=2)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


class Ninja(models.Model):
    dojo=models.ForeignKey(Dojo, related_name="ninjas", on_delete=models.CASCADE)
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


def add_dojo(post):
    return Dojo.objects.create(name=post['name'],city=post['city'],state=post['state'])


def get_dojo():
    return Dojo.objects.all()

def add_ninja(post):
    dojo = Dojo.objects.get(id=post['dojo_id'])
    return Ninja.objects.create(dojo=dojo,first_name=post['first_name'],last_name=post['last_name'])

def get_ninja():
    return Ninja.objects.all()
