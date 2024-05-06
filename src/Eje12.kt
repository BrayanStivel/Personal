class Eje12 {
    fun calcularPromedioGeneral(matematica: Pair<Double, List<Double>>, fisica: Pair<Double, List<Double>>, quimica: Pair<Double, List<Double>>): Double {
        val promedioMatematica = (matematica.first * 0.90) + (matematica.second.sum() / matematica.second.size * 0.10)
        val promedioFisica = (fisica.first * 0.80) + (fisica.second.sum() / fisica.second.size * 0.20)
        val promedioQuimica = (quimica.first * 0.85) + (quimica.second.sum() / quimica.second.size * 0.15)
        return (promedioMatematica + promedioFisica + promedioQuimica) / 3
    }

    fun main() {
        val promedioMatematica = Pair(90.0, listOf(80.0, 85.0, 88.0))
        val promedioFisica = Pair(85.0, listOf(75.0, 80.0))
        val promedioQuimica = Pair(88.0, listOf(90.0, 85.0, 92.0))
        println("Promedio general del alumno: ${(calcularPromedioGeneral(promedioMatematica, promedioFisica, promedioQuimica))}")
    }

}