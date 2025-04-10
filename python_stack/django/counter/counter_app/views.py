from django.shortcuts import render, redirect

def index(request):
    # Check if the session key exists; if not, initialize it
    if 'counter' not in request.session:
        request.session['counter'] = 0
    request.session['counter'] += 1
    return render(request, 'index.html', {'counter': request.session['counter']})


def destroy_session(request):
    # Clear the session and redirect to the root route
    request.session.flush()
    return redirect('/')