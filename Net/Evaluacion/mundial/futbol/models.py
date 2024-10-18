from django.db import models
from django.contrib.auth.models import User

class Posicion(models.Model):
    nombre = models.CharField(max_length=100)
    descripcion = models.TextField()

    def __str__(self):
        return self.nombre

class Equipo(models.Model):
    nombre = models.CharField(max_length=100)
    bandera = models.ImageField(upload_to='banderas/')
    escudo = models.ImageField(upload_to='escudos/')

    def __str__(self):
        return self.nombre

class Jugador(models.Model):
    nombre = models.CharField(max_length=100)
    apellido = models.CharField(max_length=100)
    foto = models.ImageField(upload_to='jugadores/')
    fecha_nacimiento = models.DateField()
    posicion = models.ForeignKey(Posicion, on_delete=models.CASCADE)
    numero_camiseta = models.PositiveIntegerField()
    titular = models.BooleanField(default=False)
    equipo = models.ForeignKey(Equipo, on_delete=models.CASCADE)

    def __str__(self):
        return f'{self.nombre} {self.apellido}'

class Tecnico(models.Model):
    nombre = models.CharField(max_length=100)
    apellido = models.CharField(max_length=100)
    fecha_nacimiento = models.DateField()
    nacionalidad = models.CharField(max_length=100)
    rol = models.CharField(max_length=100)

    def __str__(self):
        return f'{self.nombre} {self.apellido}'
