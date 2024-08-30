from django.db import models


class Equipo(models.Model):
    name = models.CharField(max_length=100)
    flag_image = models.ImageField(upload_to='flags/')
    badge_image = models.ImageField(upload_to='badges/')
   
    def __str__(self):
        return self.name
   
    class Meta:
        verbose_name = "Equipo"
        verbose_name_plural = "Equipos"
        db_table = "Equipos"
        ordering = ['id']


class Posicion(models.Model):
    name = models.CharField(max_length=50)
    description = models.TextField()
   
    def __str__(self):
        return self.name
   
    class Meta:
        verbose_name = "Posicion"
        verbose_name_plural = "Posiciones"
        db_table = "Posiciones"
        ordering = ['id']


class Jugadores(models.Model):
    first_name = models.CharField(max_length=50)
    last_name = models.CharField(max_length=50)
    photo = models.ImageField(upload_to='Jugador/')
    birth_date = models.DateField()
    position = models.ForeignKey(Posicion, on_delete=models.CASCADE)
    jersey_number = models.IntegerField()
    is_starter = models.BooleanField(default=False)
    team = models.ForeignKey(Equipo, on_delete=models.CASCADE)
   
    def __str__(self):
        return self.name


class Meta:
        verbose_name = "Jugador"
        verbose_name_plural = "Jugadores"
        db_table = "Jugadores"
        ordering = ['id']
       
class Tecnico(models.Model):
    first_name = models.CharField(max_length=50)
    last_name = models.CharField(max_length=50)
    birth_date = models.DateField()
    nationality = models.CharField(max_length=50)
    role = models.CharField(max_length=50, choices=[('Coach', 'Coach'), ('Assistant', 'Assistant'), ('Doctor', 'Doctor'), ('Physio', 'Physio')])
   
    def __str__(self):
        return self.name
   
    class Meta:
        verbose_name = "Tecnico"
        verbose_name_plural = "Tecnicos"
        db_table = "Tecnicos"
        ordering = ['id']


