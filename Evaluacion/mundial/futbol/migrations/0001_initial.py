# Generated by Django 5.1.1 on 2024-09-08 15:18

import django.db.models.deletion
from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Equipo',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nombre', models.CharField(max_length=100)),
                ('bandera', models.ImageField(upload_to='banderas/')),
                ('escudo', models.ImageField(upload_to='escudos/')),
            ],
        ),
        migrations.CreateModel(
            name='Posicion',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nombre', models.CharField(max_length=100)),
                ('descripcion', models.TextField()),
            ],
        ),
        migrations.CreateModel(
            name='Tecnico',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nombre', models.CharField(max_length=100)),
                ('apellido', models.CharField(max_length=100)),
                ('fecha_nacimiento', models.DateField()),
                ('nacionalidad', models.CharField(max_length=100)),
                ('rol', models.CharField(max_length=100)),
            ],
        ),
        migrations.CreateModel(
            name='Jugador',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nombre', models.CharField(max_length=100)),
                ('apellido', models.CharField(max_length=100)),
                ('foto', models.ImageField(upload_to='jugadores/')),
                ('fecha_nacimiento', models.DateField()),
                ('numero_camiseta', models.PositiveIntegerField()),
                ('titular', models.BooleanField(default=False)),
                ('equipo', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='futbol.equipo')),
                ('posicion', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='futbol.posicion')),
            ],
        ),
    ]
