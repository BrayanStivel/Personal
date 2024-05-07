class Eje52 {

  fun main() {
    var pesoNinos = 0
    var pesoJovenes = 0
    var pesoAdultos = 0
    var pesoViejos = 0
    var totalNinos = 0
    var totalJovenes = 0
    var totalAdultos = 0
    var totalViejos = 0

    for (i in 1..100) {
        print("Edad de la persona $i: ")
        val edad = readLine()!!.toInt()

        print("Peso de la persona $i: ")
        val peso = readLine()!!.toDouble()

        when {
            edad < 13 -> {
                pesoNinos += peso
                totalNinos++
            }
            edad < 30 -> {
                pesoJovenes += peso
                totalJovenes++
            }
            edad < 60 -> {
                pesoAdultos += peso
                totalAdultos++
            }
            else -> {
                pesoViejos += peso
                totalViejos++
            }
        }
    }

    val promedioNinos = if (totalNinos > 0) pesoNinos / totalNinos else 0
    val promedioJovenes = if (totalJovenes > 0) pesoJovenes / totalJovenes else 0
    val promedioAdultos = if (totalAdultos > 0) pesoAdultos / totalAdultos else 0
    val promedioViejos = if (totalViejos > 0) pesoViejos / totalViejos else 0

    println("Promedio de peso de niños: $promedioNinos")
    println("Promedio de peso de jóvenes: $promedioJovenes")
    println("Promedio de peso de adultos: $promedioAdultos")
    println("Promedio de peso de viejos: $promedioViejos")
}

}
