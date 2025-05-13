from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name="index"),
    path('register/', views.register, name="register"),
    path('login/', views.login_view, name="login"),
    path('logout/', views.logout_view, name="logout"),
    path('add_book/', views.add_book, name="add_book"),
    path('books/<int:book_id>/', views.view_book, name="view_book"),
    path('favorite/<int:book_id>/', views.favorite_book, name="favorite_book"),
    path('unfavorite/<int:book_id>/', views.unfavorite_book, name="unfavorite_book"),
    path('edit/<int:book_id>/', views.edit_book, name="edit_book"),
    path('delete/<int:book_id>/', views.delete_book, name="delete_book"),
]
