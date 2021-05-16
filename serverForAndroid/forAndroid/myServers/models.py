from django.db import models


class Sensor(models.Model):
    """Класс датчиков
    """
    objects = None
    id = models.IntegerField("Номер датчика", primary_key=True)
    name = models.CharField("Название датчика", max_length=10, unique=True)
    status = models.IntegerField("Статус датчика")


class SensorDetail(models.Model):
    """Класс деталей сенсора
    """
    objects = None
    # id_sensor = models.ForeignKey(Sensor, on_delete=models.CASCADE)
    id = models.IntegerField("Номер датчика", primary_key=True)
    name = models.CharField("Название датчика", max_length=10, unique=True)
    status = models.IntegerField("Статус датчика")
    channel_sensor = models.IntegerField("Канал")
    height_sensor = models.IntegerField("Высота")
    type_sensor = models.CharField("Тип", max_length=100)
    recorder_sensor = models.CharField("Регистратор", max_length=100)
    discrete_frequency_sensor = models.IntegerField("Частота дискр.")
    operator_sensor = models.CharField("Оператор", max_length=100)
    perc_memr_free_storage = models.IntegerField("Процент свободной памяти")
    perc_battery_storage = models.IntegerField("Процент аккамулятора")
