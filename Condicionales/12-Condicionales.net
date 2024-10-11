using System;

class Program
{
    static void Main()
    {
        Console.Write("Ingrese la cantidad de articulos comprados: ");
        int cantidadArticulos = int.Parse(Console.ReadLine());

        Console.Write("Ingrese el precio unitario original: ");
        double precioUnitarioOriginal = double.Parse(Console.ReadLine());

        double descuento;

        if (cantidadArticulos <= 5)
        {
            descuento = 0;
        }
        else if (cantidadArticulos < 10)
        {
            descuento = 0.05;
        }
        else
        {
            descuento = 0.08;
        }

        double totalPagar = cantidadArticulos * precioUnitarioOriginal * (1 - descuento);
        Console.WriteLine($"El total a pagar es: {totalPagar}");
    }
}
