import self as self
import urllib.request
from rest_framework import generics
from django.http import HttpResponse
from .serializers import *
from .models import *


class SensorListView(generics.ListAPIView):
    serializer_class = SensorList
    queryset = Sensor.objects.all()


class SensorObject(generics.RetrieveAPIView):
    serializer_class = SensorDetailList
    queryset = SensorDetail.objects.all()
