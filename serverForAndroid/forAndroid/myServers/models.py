from django.db import models


class Sensor(models.Model):
    """Класс датчиков
    """
    id = models.IntegerField("Номер датчика", primary_key=True)
    name = models.CharField("Название датчика", max_length=10, unique=True)
    coordinates = models.IntegerField("Кординаты", unique=True)
    time_zone = models.IntegerField("Часовой пояс датчика")
    status = models.IntegerField("Статус датчика")
    desc = models.TextField("Описание датчика", max_length=400)


class SensorDetail(models.Model):
    """Класс деталей сенсора
    """
    id_sensor = models.ForeignKey(Sensor, on_delete=models.CASCADE)
    time_last_update = models.DateTimeField("Дата последнего обновления")
    per_storage = models.IntegerField("Процент свободной памяти")
    time_service = models.DateTimeField("Время последнего обслуживания")
