using System;

class Program
{
    static void Main()
    {
        Console.Write("Ingrese la cantidad de llantas compradas: ");
        int cantidadLlantas = int.Parse(Console.ReadLine());
        int precioUnitario;

        if (cantidadLlantas < 6)
        {
            precioUnitario = 240000;
        }
        else if (cantidadLlantas <= 7)
        {
            precioUnitario = 221000;
        }
        else
        {
            precioUnitario = 180000;
        }

        int total = cantidadLlantas * precioUnitario;
        Console.WriteLine($"El valor a pagar es: {total}");
    }
}
