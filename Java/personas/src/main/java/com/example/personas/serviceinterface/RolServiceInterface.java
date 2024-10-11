package com.example.personas.serviceinterface;

package com.tuempresa.tuaplicacion.serviceinterface;

import com.tuempresa.tuaplicacion.entity.Rol;
import java.util.List;

public interface RolServiceInterface {
    Rol crearRol(Rol rol);
    List<Rol> obtenerTodosLosRoles();
}
