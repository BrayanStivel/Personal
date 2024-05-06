class Eje50 {
    fun sumaNumerosPares() {
        var suma = 0
        for (i in 98 until 1003 step 2) {
            suma += i
        }
        println("La suma de todos los números pares entre 97 y 1003 es: $suma")
    }

    fun main() {
        sumaNumerosPares()
    }

}