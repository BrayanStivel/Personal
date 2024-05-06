class Eje40 {
    fun calcularMontoLuzElectricayAseo(lecturaAnterior: Int, lecturaActual: Int): Double {
        val consumo = lecturaActual - lecturaAnterior
        return when {
            consumo <= 100 -> consumo * 2622.0
            consumo <= 300 -> 100 * 2622.0 + (consumo - 100) * 79.78
            consumo <= 500 -> 100 * 2622.0 + 200 * 79.78 + (consumo - 300) * 89.52
            else -> 100 * 2622.0 + 200 * 79.78 + 200 * 89.52 + (consumo - 500) * 97.95
        }
    }

    fun main() {
        val lecturaAnterior = 500
        val lecturaActual = 800
        println("Monto a pagar por consumo de luz eléctrica y aseo urbano: ${calcularMontoLuzElectricayAseo(lecturaAnterior, lecturaActual)} Bolívares")
    }

}