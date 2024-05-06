class Eje32 {
    fun verificarExpresion(P: Int, Q: Int): Boolean {
        val resultado = P * P * P + Q * Q * Q - 2 * P * P > 680
        return resultado
    }

    fun main() {
        val P = 5
        val Q = 10
        if (verificarExpresion(P, Q)) {
            println("Los valores de P y Q satisfacen la expresión.")
        } else {
            println("Los valores de P y Q no satisfacen la expresión.")
        }
    }


}