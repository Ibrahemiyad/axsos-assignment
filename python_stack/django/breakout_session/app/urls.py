from django.urls import path
from . import views

urlpatterns = [
    path('',views.index),
    path('register',views.register),
    path('login',views.login),
    path('logout',views.logout),
    path('books',views.success),
    path('book_info/<int:book_id>',views.book_info),
    path('add_book',views.add_book),
    path('add_favorite/<int:book_id>',views.add_favorite),
    path('unfavorite/<int:book_id>',views.unfavorite_book)
]