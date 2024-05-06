class Eje42 {
    fun tieneAnemia(edad: String, nivelHemoglobina: Double, sexo: String): Boolean {
        val niveles = mapOf(
            "0-1 mes" to 13.0..26.0,
            "1-6 meses" to 10.0..18.0,
            "6-12 meses" to 11.0..15.0,
            "1-5 años" to 11.5..15.0,
            "5-10 años" to 12.6..15.5,
            "10-15 años" to 13.0..15.5,
            "Mujeres > 15 años" to 12.0..16.0,
            "Hombres > 15 años" to 14.0..18.0
        )
        val rango = niveles[edad + if (edad.contains("mes") || edad.contains("año")) "" else " años"]
        return if (rango != null) {
            if (sexo == "Mujer" && edad.contains("mes")) nivelHemoglobina !in rango
            else nivelHemoglobina !in rango
        } else false
    }

    fun main() {
        val edad = "10-15 años"
        val nivelHemoglobina = 14.5
        val sexo = "Hombre"
        val resultado = if (tieneAnemia(edad, nivelHemoglobina, sexo)) "Tiene anemia." else "No tiene anemia."
        println(resultado)
    }

}