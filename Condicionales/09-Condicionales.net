
using System;

class Program
{
    static void Main()
    {
        // Leer el monto de la cuenta desde el usuario
        Console.Write("Ingrese el monto de la cuenta: ");
        double montoCuenta = double.Parse(Console.ReadLine());

        if (montoCuenta < 150000)
        {
            Console.WriteLine("Forma de pago: Efectivo");
        }
        else if (montoCuenta <= 300000)
        {
            Console.WriteLine("Forma de pago: Pago con celular (dinero electronico)");
        }
        else if (montoCuenta <= 600000)
        {
            Console.WriteLine("Forma de pago: Pago con tarjeta de debito");
        }
        else
        {
            Console.WriteLine("Forma de pago: Pago con tarjeta de credito");
        }
    }
}
