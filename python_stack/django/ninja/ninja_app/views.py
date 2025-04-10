from django.shortcuts import render

# Create your views here.
def index(request):
    if 'gold' not in request.session['gold']