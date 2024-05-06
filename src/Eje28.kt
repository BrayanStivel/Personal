class Eje28 {
    fun calcularCompra(montoTotal: Double): Triple<Double, Double, Double> {
        val inversion = if (montoTotal > 500000) {
            montoTotal * 0.55
        } else {
            montoTotal * 0.70
        }
        val credito = if (montoTotal > 500000) {
            montoTotal * 0.15
        } else {
            montoTotal * 0.30
        }
        val intereses = credito * 0.20
        return Triple(inversion, credito, intereses)
    }

    fun main() {
        val montoTotal = 600000.0
        val (inversion, credito, intereses) = calcularCompra(montoTotal)
        println("Cantidad a invertir: $inversion")
        println("Cantidad a pagar a crédito: $credito")
        println("Monto de intereses: $intereses")
    }

}