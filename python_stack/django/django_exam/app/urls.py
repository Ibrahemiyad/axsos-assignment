from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name='index'),  # Home page with login & register form
    path('register', views.register, name='register'),  # User registration
    path('login', views.login, name='login'),  # User login
    path('logout/', views.logout, name='logout'),
    path('dashboard', views.dashboard, name='dashboard'),  # User dashboard
    path('create_project', views.create_project, name='create_project'),  # Create a new project
    path('project/<int:project_id>', views.view_project, name='view_project'),  # View project details
    path('project/<int:project_id>/edit', views.edit_project, name='edit_project'),  # Edit a project
    path('project/<int:project_id>/delete', views.delete_project, name='delete_project'),  # Delete a project
    path('project/<int:project_id>/join/', views.join_project, name='join_project'),
]
