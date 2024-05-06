class Eje24 {
    fun calcularInteresesYSaldoInicial(capital: Double, tasaInteres: Double, tiempo: Int): Pair<Double, Double> {
        val intereses = capital * tasaInteres / 100 * tiempo
        val saldoFinal = capital + intereses
        return Pair(intereses, saldoFinal)
    }

    fun main() {
        val capital = 10000.0
        val tasaInteres = 5.0
        val tiempo = 4
        val (intereses, saldoFinal) = calcularInteresesYSaldoInicial(capital, tasaInteres, tiempo)
        println("Intereses generados: $intereses")
        println("Saldo final: $saldoFinal")
    }

}