class Eje8 {
    val ladoA = 3.0
    val ladoB = 4.0
    val ladoC = 5.0
    val p = (ladoA + ladoB + ladoC) / 2
    val areaTriangulo = (p * (p - ladoA) * (p - ladoB) * (p - ladoC))
    println("El área del triángulo es: $areaTriangulo")

}