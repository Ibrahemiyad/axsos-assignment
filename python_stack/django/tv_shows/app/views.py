from django.shortcuts import render, redirect
from .models import Show

def redirect_to_shows(request):
    return redirect('/shows')

def all_shows(request):
    context = {'shows': Show.objects.all()}
    return render(request, 'shows.html', context)

def new_show(request):
    return render(request, 'new_show.html')

def create_show(request):
    if request.method == 'POST':
        Show.objects.create(
            title=request.POST['title'],
            network=request.POST['network'],
            release_date=request.POST['release_date'],
            description=request.POST.get('description', '')
        )
        return redirect(f"/shows/{Show.objects.last().id}")

def show_detail(request, id):
    context = {'show': Show.objects.get(id=id)}
    return render(request, 'show_detail.html', context)

def edit_show(request, id):
    context = {'show': Show.objects.get(id=id)}
    return render(request, 'edit_show.html', context)

def update_show(request, id):
    if request.method == 'POST':
        show = Show.objects.get(id=id)
        show.title = request.POST['title'].strip()
        show.network = request.POST['network'].strip()
        show.release_date = request.POST.get('release_date', '')
        show.description = request.POST['description']
        show.save()
    return redirect(f"/shows/{id}")

def destroy_show(request, id):
    Show.objects.get(id=id).delete()
    return redirect('/shows')
