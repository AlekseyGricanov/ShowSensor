from rest_framework import serializers
from .models import *


class SensorList(serializers.ModelSerializer):
    class Meta:
        model = Sensor
        fields = ['id', 'name', 'status']


class SensorDetailList(serializers.ModelSerializer):
    class Meta:
        model = SensorDetail
        fields = '__all__'
