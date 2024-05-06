class Eje18 {
    fun calcularMontoGasolina(galones: Double): Double {
        val litros = galones * 3.785
        val precioLitro = 100.0
        return litros * precioLitro
    }

    fun main() {
        println("Monto a cobrar en la gasolinera: ${calcularMontoGasolina(10.0)}")
    }

}