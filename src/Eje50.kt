class Eje50 {
fun main() {
    var suma = 0

    for (i in 97..1003) {
        if (i % 2 == 0) { 
            suma += i
        }
    }

    println("La suma de todos los números pares entre 97 y 1003 es: $suma")
}

}
