class Eje46 {
    fun escribirNumeros(n: Int, k: Int) {
        var numero = n
        while (numero >= k) {
            println(numero)
            numero--
        }
    }

    fun main() {
        val n = 10
        val k = 3
        escribirNumeros(n, k)
    }

}