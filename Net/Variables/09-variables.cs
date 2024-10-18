using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        double valorUnitario, cantidad, valorTotal, IVA;

        // Solicitar al usuario que ingrese el valor unitario
        Console.WriteLine("Ingrese el valor unitario:");
        valorUnitario = double.Parse(Console.ReadLine());

        // Solicitar al usuario que ingrese la cantidad de productos
        Console.WriteLine("Ingrese la cantidad de productos:");
        cantidad = double.Parse(Console.ReadLine());

        // Calcular el valor total y el IVA
        valorTotal = valorUnitario * cantidad;
        IVA = valorTotal * 0.16;
        valorTotal += IVA;

        // Mostrar el resultado
        Console.WriteLine("El valor total a pagar es: " + valorTotal);
    }
}
