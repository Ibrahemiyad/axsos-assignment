from django.shortcuts import render

def index(request):
    return render(request, 'index.html')

def result(request):
    context = {
        'name': request.POST['name'],
        'dojo_location': request.POST['dojo_location'],
        'favorite_language': request.POST['favorite_language'],
        'comment': request.POST['comment']
    }
    return render(request, 'result.html', context)
