from django.shortcuts import render, redirect
from django.contrib import messages
from .models import User
from . import models
import bcrypt

def index(request):
    return render(request, 'index.html')

def register(request):
    if request.method == "POST":
        user = models.create(request.POST)
        request.session['user_id'] = user.id
        request.session['first_name'] = user.first_name
        return redirect('/success')

    return redirect('/')



def login(request):
    if request.method == "POST":
        user = User.objects.filter(email=request.POST['email']).first()

        if user and bcrypt.checkpw(request.POST['password'].encode(), user.password.encode()):
            request.session['user_id'] = user.id
            request.session['first_name'] = user.first_name
            return redirect('/success')

        messages.error(request, "Invalid email or password")

    return redirect('/')

def success(request):
    if 'user_id' not in request.session:
        return redirect('/')
    return render(request, 'success.html')

def logout(request):
    request.session.clear()
    return redirect('/')
