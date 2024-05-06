class Eje20 {
    fun calcularPorcentajeInteres(capital: Double, intereses: Double, tiempo: Int): Double {
        return (intereses * 100) / (capital * tiempo)
    }

    fun main() {
        val capital = 10000.0
        val intereses = 5000.0
        val tiempo = 4
        println("Porcentaje de interés anual: ${calcularPorcentajeInteres(capital, intereses, tiempo)}%")
    }

}