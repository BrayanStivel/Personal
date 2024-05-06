class Eje44 {
    fun determinarInversiones(montoHipoteca: Double, saldoCuenta: Double, inversionTotal: Double) {
        if (montoHipoteca < 1000000) {
            val inversionPropia = montoHipoteca / 2
            val inversionSocio = montoHipoteca / 2
            println("Inversión propia: $inversionPropia")
            println("Inversión del socio: $inversionSocio")
        } else {
            val inversionPropia = montoHipoteca
            val inversionSocio = (inversionTotal - montoHipoteca) / 2
            println("Inversión propia: $inversionPropia")
            println("Inversión del socio: $inversionSocio")
        }
    }

    fun main() {
        val montoHipoteca = 1200000.0
        val saldoCuenta = 200000.0
        val inversionTotal = 2500000.0
        determinarInversiones(montoHipoteca, saldoCuenta, inversionTotal)
    }

}