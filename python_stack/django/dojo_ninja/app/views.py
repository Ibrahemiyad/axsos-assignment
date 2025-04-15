from django.shortcuts import render, redirect
from . import models

def index(request):
    context = {
        'dojos':models.get_dojo()
    }
    return render(request, 'index.html', context)

def create_ninja(request):
    if request.method == 'POST':
        models.add_dojo(request.POST)
    return redirect('/')