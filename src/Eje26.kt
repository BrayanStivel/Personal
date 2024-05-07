class Eje26 {
fun main() {
    val A = 5
    val B = 3
    val C = 2
    val D = 1

    val resultado = if (D == 0) {
        (A - C) * (A - C)
    } else {
        (A - B) * (A - B) * (A - B) / D.toDouble()
    }

    println("El resultado es: $resultado")
}



}
