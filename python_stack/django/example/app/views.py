from django.shortcuts import render,redirect
from .models import User, register_user, login_user
from . import models
from django.contrib import messages
# Create your views here.

def index(request):
    if not 'user' in request.session:
        return render(request, 'index.html')
    else:
        user = request.session['user']
        return render(request, 'success.html', {'user': user})

def register(request):
    if request.method == 'POST':
        errors = User.objects.validate_register(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/')
        else:
            user = register_user(request.POST['first_name'], request.POST['last_name'], request.POST['email'], request.POST['password'])
            request.session['user'] = {
                'id': user.id,
                'first_name': user.first_name,
                'last_name': user.last_name,
                'email': user.email
            }
                
            return redirect('/books')
    else:
        return redirect('/')

def login(request):
    if request.method == 'POST':
        errors = User.objects.validate_login(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/')
        else:
            user = login_user(request.POST['email'], request.POST['password'])
            if user:
                request.session['user'] = {
                    'id': user.id,
                    'first_name': user.first_name,
                    'last_name': user.last_name,
                    'email': user.email
                }
                return redirect('/books')
            else:
                messages.error(request, "Invalid email or password")
                return redirect('/')
    else:
        return redirect('/')

def logout(request):
    if 'user' in request.session:
        del request.session['user']
    return redirect('/')

def success(request):
    if 'user' in request.session:
        context = {
            'books': models.Book.get_all_books(),
            'user': models.User.get_user_by_id(request.session['user']['id']),
        }
        return render(request, 'success.html' , context)
    else:
        return redirect('/')

def add_book(request):
    if request.method == 'POST':
        errors = models.Book.objects.validate_book(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/books')
        else:
            models.Book.add_book(request.POST, request.session['user']['id'])
            return redirect('/books')
    else:
        return redirect('/')

def add_favorite(request, book_id):
    if 'user' in request.session:
        models.Book.add_favorite(book_id, request.session['user']['id'])
        return redirect('/books')
    else:
        return redirect('/')

def book_info(request,book_id):
    if 'user' in request.session:
        context = {
            'user': models.User.get_user_by_id(request.session['user']['id']),
            'book': models.Book.get_book_by_id(book_id)
        }
        return render(request,"book_info.html",context)

def unfavorite_book(request,book_id):
    if 'user' in request.session:
        models.Book.unfavorite(book_id,request.session['user']['id'])
        return redirect(f'/book_info/{book_id}')
    

def update_book(request, book_id):
    if 'user' in request.session and request.method == 'POST':
        errors = models.Book.objects.validate_book(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect(f'/book_info/{book_id}')
        else:
            book = models.Book.get_book_by_id(book_id)
            if book.uploaded_by.id == request.session['user']['id']:  # Only uploader can update
                book.title = request.POST['title']
                book.description = request.POST['description']
                book.save()
            return redirect(f'/book_info/{book_id}')
    else:
        return redirect('/')


def delete_book(request, book_id):
    if 'user' in request.session:
        book = models.Book.get_book_by_id(book_id)
        if book.uploaded_by.id == request.session['user']['id']:  # Only uploader can delete
            book.delete()
        return redirect('/books')
    else:
        return redirect('/')
