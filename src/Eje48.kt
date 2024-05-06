class Eje48 {
    fun conversionTemperatura() {
        println("| Fahrenheit | Celsius | Rankine | Kelvin |")
        println("|------------|---------|---------|--------|")
        for (fahrenheit in 28..54) {
            val celsius = (5 * (fahrenheit - 32)) / 9
            val rankine = fahrenheit + 459.67
            val kelvin = celsius + 273.15
            println("| $fahrenheit          | $celsius         | $rankine        | $kelvin     |")
        }
        for (fahrenheit in 450..950 step 50) {
            val celsius = (5 * (fahrenheit - 32)) / 9
            val rankine = fahrenheit + 459.67
            val kelvin = celsius + 273.15
            println("| $fahrenheit         | $celsius        | $rankine        | $kelvin    |")
        }
        for (fahrenheit in -50..250 step 10) {
            val celsius = (5 * (fahrenheit - 32)) / 9
            val rankine = fahrenheit + 459.67
            val kelvin = celsius + 273.15
            println("| $fahrenheit          | $celsius        | $rankine        | $kelvin     |")
        }
    }

    fun main() {
        conversionTemperatura()
    }

}