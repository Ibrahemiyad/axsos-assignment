from django.shortcuts import render, redirect
from . import models

def index(request):
    context = {
        'dojos':models.get_dojo(),
        'ninjas': models.get_ninja()
    }
    return render(request, 'index.html', context)

def add_ninja(request):
    if request.method == 'POST':
        models.add_ninja(request.POST)
        return redirect('/')
    else:
        return redirect('/')

def add_dojo(request):
    if request.method == 'POST':
        models.add_dojo(request.POST)
        return redirect('/')
    else:
        return redirect('/')
