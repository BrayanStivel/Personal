class Eje38 {
    fun determinarSignoZodiacal(fechaNacimiento: String): String {
        val signos = listOf("Capricornio", "Acuario", "Piscis", "Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio")
        val meses = listOf("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
        val (dia, mes, anio) = fechaNacimiento.split("/")
        val signoIndex = if (dia.toInt() < 21) mes.toInt() - 1 else mes.toInt() % 12
        return "Tu signo zodiacal es ${signos[signoIndex]}, y tienes ${2024 - anio.toInt()} años."
    }

    fun main() {
        val fechaNacimiento = "14/07/1995"
        println(determinarSignoZodiacal(fechaNacimiento))
    }

}