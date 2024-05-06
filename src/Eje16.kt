class Eje16 {
    fun calcularPiezasYLaminas(): Pair<Int, Double> {
        val largoLamina = 4.0
        val anchoLamina = 1.5
        val totalLamina = largoLamina * anchoLamina
        val consumoPieza = 0.5
        val cantidadPiezas = (totalLamina / consumoPieza).toInt()
        val desperdicio = totalLamina - consumoPieza * cantidadPiezas
        return Pair(cantidadPiezas, desperdicio)
    }

    fun main() {
        val resultadoPiezasYLaminas = calcularPiezasYLaminas()
        println("Cantidad de piezas fabricadas: ${resultadoPiezasYLaminas.first}, Desperdicio: ${resultadoPiezasYLaminas.second} metros")
    }

}