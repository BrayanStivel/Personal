class Eje30 {
    fun redondearACentena(numero: Int): Int {
        val centena = numero / 100 * 100
        val resto = numero % 100
        return if (resto >= 50) {
            centena + 100
        } else {
            centena
        }
    }

    fun main() {
        val numero = 2362
        println("Número redondeado: ${redondearACentena(numero)}")
    }

}