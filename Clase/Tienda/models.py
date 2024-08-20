
from django.db import models

from django.db import models
from datetime import datetime

class User(models.Model):
    first_name = models.CharField(max_length=40, verbose_name='Primer nombre')
    second_name = models.CharField(max_length=40, verbose_name='Segundo nombre')
    last_name = models.CharField(max_length=150, verbose_name='Apellidos')
    id_doc = models.CharField(max_length=20, unique=True, verbose_name='Número de documento')
    date_joined = models.DateTimeField(default=datetime.now, verbose_name='Fecha de registro')
    date_creation = models.DateTimeField(auto_now=True)
    date_updated = models.DateTimeField(auto_now_add=True)
    #age = models.IntegerField(default=0)
    age = models.PositiveIntegerField(default=0)
    salary = models.DecimalField(default=0.00, max_digits=9, decimal_places=2)
    state = models.BooleanField(default=True)
    photo = models.ImageField(upload_to='photo/%Y/%m/%d', null=True, blank=True)
    file = models.FileField(upload_to='file/%Y/%m/%d', null=True, blank=True)
'''
    ROLE_CHOICES = [
        ('Técnico', 'Técnico'),
        ('Asistente', 'Asistente'),
        ('Médico', 'Médico'),
        ('Preparador', 'Preparador'),
    ]
    role = models.CharField(max_length=10, choices=ROLE_CHOICES, help_text='Seleccione el rol')
'''

    # Método to string
def __str__(self):
    return self.first_name

class Meta:
        verbose_name = 'Usuario' # Cuando se registre la BD en Django
        verbose_name_plural = 'Usuarios'
        db_table = 'usuario' # Nombre de la tabla
        ordering = ['id'] # Orden ascendente
				#ordering = ['-id'] # Orden descendente

class Category(models.Model):
    name = models.CharField(verbose_name='Nombre', max_length=100)
    description = models.TextField(verbose_name='Descripción')

    def __str__(self):
        return self.name

    class Meta:
        verbose_name = 'Categoría'
        verbose_name_plural = 'Categorías'
        db_table = 'category'
        ordering = ['id']


class Product(models.Model):
    name = models.CharField('Producto', max_length=100)
    price = models.DecimalField('Precio', max_digits=10, decimal_places=2)
    stock = models.PositiveIntegerField('Stock')
    description = models.TextField(verbose_name='Descripción')
    #image = models.ImageField(verbose_name='Imagen', upload_to='products/images')
    created = models.DateTimeField(auto_now_add=True, verbose_name='Fecha de creación')
    state = models.BooleanField(verbose_name='Disponible', default=True)
    # Relationship OnetoMany
    #category = models.ForeignKey(Category, verbose_name='Categoría', on_delete=models.CASCADE)
    category = models.ManyToManyField(Category, verbose_name='Categoría')

    def __str__(self):
        return self.name

    class Meta:
        verbose_name = 'Producto'
        verbose_name_plural = 'Productos'
        db_table = 'product'
        ordering = ['id']