from django.shortcuts import render, redirect
import random

def index(request):
    if 'number' not in request.session:
        request.session['number'] = random.randint(1, 100)
        request.session['attempts'] = 0
    return render(request, 'index.html')

def guess(request):
    if request.method == "POST":
        guess = int(request.POST['guess'])
        number = request.session['number']
        request.session['attempts'] += 1

        if guess < number:
            request.session['message'] = "Too low!"
        elif guess > number:
            request.session['message'] = "Too high!"
        else:
            request.session['message'] = f"Correct! The number was {number}. It took you {request.session['attempts']} tries."
    return redirect('/')

def reset(request):
    request.session.flush() 
    return redirect('/')
