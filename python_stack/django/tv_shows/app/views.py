from django.shortcuts import render, redirect
from .models import Show

def redirect_to_shows(request):
    return redirect('/shows')

def all_shows(request):
    context = {'shows': Show.objects.all()}
    return render(request, 'shows.html', context)

def new_show(request):
    return render(request, 'new_show.html')

from django.shortcuts import render, redirect
from .models import Show

def create_show(request):
    if request.method == 'POST':
        errors = {}
        title = request.POST.get('title', '')
        network = request.POST.get('network', '')
        release_date = request.POST.get('release_date', '')
        description = request.POST.get('description', '')

        if not title:
            errors['title'] = "Title is required."
        if not network:
            errors['network'] = "Network is required."
        if not release_date:
            errors['release_date'] = "Release Date is required."
        
        if errors:
            return render(request, 'new_show.html', {'errors': errors})

        show = Show.objects.create(
            title=title,
            network=network,
            release_date=release_date,
            description=description
        )
        return redirect(f"/shows/{show.id}")

    return redirect('/shows/new')

def show_detail(request, id):
    context = {'show': Show.objects.get(id=id)}
    return render(request, 'show_detail.html', context)

def edit_show(request, id):
    context = {'show': Show.objects.get(id=id)}
    return render(request, 'edit_show.html', context)

def update_show(request, id):
    if request.method == 'POST':
        errors = {}

        show = Show.objects.filter(id=id).first()  

        if not show:
            return redirect('/shows')

        title = request.POST.get('title', show.title)
        network = request.POST.get('network', show.network)
        release_date = request.POST.get('release_date', None)
        description = request.POST.get('description', show.description)

        if not title:
            errors['title'] = "Title is required."
        if not network:
            errors['network'] = "Network is required."
        if not release_date:
            errors['release_date'] = "Release Date is required."
        
        if errors:
            return render(request, 'edit_show.html', {'errors': errors, 'show': show})

        show.title = title
        show.network = network
        show.release_date = release_date
        show.description = description
        show.save()

        return redirect(f"/shows/{id}")

    return redirect(f"/shows/{id}/edit")

def destroy_show(request, id):
    Show.objects.get(id=id).delete()
    return redirect('/shows')
