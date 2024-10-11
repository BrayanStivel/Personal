package com.example.personas.serviceinterface;

package com.example.personas.serviceinterface;

import com.example.personas.entity.Empleado;
import java.util.List;

public interface EmpleadoServiceInterface {
    Empleado crearEmpleado(Empleado empleado);
    List<Empleado> obtenerEmpleadosPorRol(String nombreRol);
    List<Empleado> obtenerTodosLosEmpleados();
}
