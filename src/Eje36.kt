class Eje36 {
    fun desglosarBolivares(cantidad: Int) {
        val billetes = listOf(50000, 20000, 10000, 5000, 2000, 1000, 500, 100, 50, 20, 10)
        var resto = cantidad
        for (billete in billetes) {
            val cantidadBilletes = resto / billete
            if (cantidadBilletes > 0) {
                println("$cantidadBilletes billetes de $billete Bs.")
                resto %= billete
            }
        }
    }

    fun main() {
        val cantidadBolivares = 123456
        println("Desglose de $cantidadBolivares Bs:")
        desglosarBolivares(cantidadBolivares)
    }

}