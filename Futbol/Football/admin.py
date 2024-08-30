from django.contrib import admin
from .models import Equipo
from .models import Posicion
from .models import Jugadores
from .models import Tecnico


admin.site.register(Equipo)
admin.site.register(Posicion)
admin.site.register(Jugadores)
admin.site.register(Tecnico)


