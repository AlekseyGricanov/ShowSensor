from django.urls import path
from .views import *

urlpatterns = [
    path('', SensorListView.as_view()),
    path('sensor/<int:pk>', SensorObject.as_view()),
]
