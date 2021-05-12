from rest_framework import generics
from .serializers import *
from .models import *


class SensorListView(generics.ListAPIView):
    serializer_class = SensorList
    queryset = Sensor.objects.all()


class SensorObject(generics.RetrieveAPIView):
    serializer_class = SensorDetailList
    queryset = SensorDetail.objects.all()
    mass_queryset = [queryset]
