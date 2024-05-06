class Eje14 {
    fun resolverEcuacionesLineales(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int): Pair<Double, Double> {
        val determinante = a * e - b * d
        val x = (c * e - b * f) / determinante.toDouble()
        val y = (a * f - c * d) / determinante.toDouble()
        return Pair(x, y)
    }

    fun main() {
        val ecuacion1 = Pair(2, 3)
        val ecuacion2 = Pair(4, 5)
        val resultadoEcuaciones = resolverEcuacionesLineales(ecuacion1.first, ecuacion1.second, 10, ecuacion2.first, ecuacion2.second, 20)
        println("X = ${resultadoEcuaciones.first}, Y = ${resultadoEcuaciones.second}")
    }

}