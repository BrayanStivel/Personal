class Eje6 {
    val totalEstudiantes = 30
    val hombres = 15
    val mujeres = totalEstudiantes - hombres
    val porcentajeHombres = (hombres.toDouble() / totalEstudiantes) * 100
    val porcentajeMujeres = (mujeres.toDouble() / totalEstudiantes) * 100
    println("Porcentaje de hombres: $porcentajeHombres%, Porcentaje de mujeres: $porcentajeMujeres%")

}