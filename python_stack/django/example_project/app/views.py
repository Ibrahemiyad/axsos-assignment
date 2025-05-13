from django.shortcuts import render, redirect, get_object_or_404
from django.contrib import messages
from .models import User, Book

def index(request):
    if "user_id" not in request.session:
        return redirect('login')
    context = {
        'user': User.objects.get(id=request.session['user_id']),
        'books': Book.objects.all()
    }
    return render(request, "books/index.html", context)

def register(request):
    # Validate form
    # Create User
    # Set session
    return redirect('index')

def login_view(request):
    # Validate login
    # Set session
    return redirect('index')

def logout_view(request):
    request.session.flush()
    return redirect('login')

def add_book(request):
    if request.method == "POST":
        # Validate book
        user = User.objects.get(id=request.session['user_id'])
        book = Book.objects.create(
            title=request.POST['title'],
            description=request.POST['description'],
            uploaded_by=user
        )
        book.users_who_like.add(user)  # Auto-favorite
        return redirect('index')

def view_book(request, book_id):
    book = get_object_or_404(Book, id=book_id)
    context = {
        'book': book,
        'user': User.objects.get(id=request.session['user_id'])
    }
    return render(request, "books/book_detail.html", context)

def favorite_book(request, book_id):
    user = User.objects.get(id=request.session['user_id'])
    book = Book.objects.get(id=book_id)
    book.users_who_like.add(user)
    return redirect('view_book', book_id=book_id)

def unfavorite_book(request, book_id):
    user = User.objects.get(id=request.session['user_id'])
    book = Book.objects.get(id=book_id)
    book.users_who_like.remove(user)
    return redirect('view_book', book_id=book_id)

def edit_book(request, book_id):
    # Only uploader can edit
    pass

def delete_book(request, book_id):
    # Only uploader can delete
    pass
