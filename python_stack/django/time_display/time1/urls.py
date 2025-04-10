from django.urls import path
from . import views

urlpatterns = [
    path('', views.index ,name ='index'),
    path('time_display',views.index)
]
