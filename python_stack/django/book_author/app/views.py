from django.shortcuts import render, redirect
from . import models

def index(request):
        context = {
            'books':models.get_book(),
            'authors':models.get_author()
        }
        return render(request, 'books.html', context)

def add_books(request):
        if request.method == 'POST':
            models.add_book(request.POST)
            return redirect('/')
        else:
            return redirect('/')


# def book_details(request, book_id):
#     if request.method == "POST":
#         book = Book.objects.get(id=book_id)
#         author = Author.objects.get(id=request.POST['author_id'])
#         book.authors.add(author)
#         return redirect(f'/books/{book_id}')
#     context = {
#         'book': Book.objects.get(id=book_id),
#         'all_authors': Author.objects.all()
#     }
#     return render(request, 'book_details.html', context)

def add_author(request):
    if request.method == 'POST':
        models.add_author(request.POST)
        return redirect('/authors')   
    else:
        return redirect('/')
    

def authors_page(request):
    context={
        'authors':models.get_author()
    }
    return render(request,'authors.html',context)   


def books_detail(request ,id):
     context={
          
        'book' :models.get_book_by_id(id),
        'authors':models.get_author()


     }
     return render(request,'books_details.html',context)

def author_detail(request ,id):
     context={
          
        'author' :models.get_author_by_id(id),
        'books':models.get_book()


     }
     return render(request,'author_detail.html',context)

