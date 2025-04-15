from django.shortcuts import render, redirect
from . import models

def index(request):
    context = {
        'users': models.get_all_users()
    }
    return render(request, 'users.html', context)

def add_user(request):
    if request.method == 'POST':
        models.create(request.POST)
    return redirect('/')
    
