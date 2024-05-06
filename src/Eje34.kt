class Eje34 {
    fun calcularAumentoSueldo(categoria: Int, sueldo: Double): Double {
        return when (categoria) {
            1 -> sueldo * 1.12
            2 -> sueldo * 1.08
            3 -> sueldo * 1.05
            4 -> sueldo * 1.038
            else -> sueldo * 1.025
        }
    }

    fun main() {
        val categoria = 3
        val sueldo = 30000.0
        println("Categoría del trabajador: $categoria")
        println("Nuevo sueldo: ${calcularAumentoSueldo(categoria, sueldo)}")
    }

}