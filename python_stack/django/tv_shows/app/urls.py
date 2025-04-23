from django.urls import path
from . import views

urlpatterns = [
    path('', views.redirect_to_shows),
    path('shows', views.all_shows),
    path('shows/new', views.new_show),
    path('shows/create', views.create_show),
    path('shows/<int:id>', views.show_detail),
    path('shows/<int:id>/edit', views.edit_show),
    path('shows/<int:id>/update', views.update_show),
    path('shows/<int:id>/destroy', views.destroy_show),
]
