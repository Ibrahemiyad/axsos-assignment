from django.urls import path
from . import views
urlpatterns = [   
    path('', views.index),
    path('Gold', views.process_gold),
    path('delete',views.delete)

]