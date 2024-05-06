class Eje26 {
    fun calcularExpresion(A: Int, B: Int, C: Int, D: Int): Double {
        return if (D == 0) {
            Math.pow((A - C).toDouble(), 2.0)
        } else {
            Math.pow((A - B).toDouble(), 3.0) / D
        }
    }

    fun main() {
        val A = 5
        val B = 3
        val C = 8
        val D = 2
        println("Resultado de la expresión: ${calcularExpresion(A, B, C, D)}")
    }


}