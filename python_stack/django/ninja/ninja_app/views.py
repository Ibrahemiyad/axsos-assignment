from django.shortcuts import render , redirect
import random
from datetime import datetime

def index(request):
    if 'gold' not in request.session:
        request.session['gold'] = 0
    if 'activities' not in request.session:
        request.session['activities'] =[] 
    
    if 'earned' not in request.session:
        request.session['earned'] = "green"


    context={
        'gold':request.session['gold'],
        'activities':request.session['activities'],
        'earned':request.session['earned']
        }
    return render(request, 'index.html',context)

def process_gold(request):
    if request.method == 'POST':
        location = request.POST.get('location')
        if location not in ['farm', 'cave', 'house', 'quest']:
            return redirect('/')  # Redirect if location is invalid
        
        gold_ranges = {
            'farm': (10, 20),
            'cave': (5, 10),
            'house': (2, 5),
            'quest': (-50, 50)
        }
        gold_earned = random.randint(*gold_ranges.get(location, (0, 0)))
        
        # Initialize session keys if not already done
        if 'gold' not in request.session:
            request.session['gold'] = 0
        if 'activities' not in request.session:
            request.session['activities'] = []
        
        # Update session data
        request.session['gold'] += gold_earned
        activity = {
            'message': f"You {'earned' if gold_earned >= 0 else 'lost'} {abs(gold_earned)} gold from the {location}! ({datetime.now().strftime('%Y-%m-%d %H:%M:%S')})",
            'earned': gold_earned > 0
        }
        request.session['activities'].insert(0, activity)
        request.session.modified = True

    return redirect('/')
def delete(request):
    request.session.clear()
    return redirect('/')