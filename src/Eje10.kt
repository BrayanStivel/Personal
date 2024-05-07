class Eje10 {
  fun main() {
    val tasaChelinesAPesetas = 956.871
    val tasaDolaresAPesetas = 122.499
    val tasaDracmasAGriegos = 88.607
    val tasaFrancosABelgas = 323.728
    val tasaFrancosAPesetas = 20.110
    val tasaLibrasAPesetas = 178.938
    val tasaLirasAPesetas = 9.289

    println("Ingrese la cantidad en chelines austríacos:")
    val chelines = readLine()!!.toDouble()
    val pesetasChelines = chelines * tasaChelinesAPesetas
    println("$chelines chelines austríacos equivalen a $pesetasChelines pesetas.")

    println("Ingrese la cantidad en dracmas griegos:")
    val dracmas = readLine()!!.toDouble()
    val francos = dracmas / tasaDracmasAGriegos * tasaFrancosAPesetas
    println("$dracmas dracmas griegos equivalen a $francos francos franceses.")

    println("Ingrese la cantidad en pesetas:")
    val pesetas = readLine()!!.toDouble()
    val dolares = pesetas / tasaDolaresAPesetas
    val liras = pesetas / tasaLirasAPesetas
    println("$pesetas pesetas equivalen a $dolares dólares y $liras liras italianas.")
}

}
