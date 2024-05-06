class Eje22 {
    fun calcularPorcentajeRecargo(precioContado: Double, precioCuotas: Double): Double {
        val recargo = (precioCuotas - precioContado) / precioContado * 100
        return recargo
    }

    fun main() {
        val precioContado = 5000.0
        val precioCuotas = 5500.0
        println("Porcentaje de recargo por cuotas: ${calcularPorcentajeRecargo(precioContado, precioCuotas)}%")
    }

}