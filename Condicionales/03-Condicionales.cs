using System;

class Program
{
    static void Main()
    {
        Console.Write("Ingrese un numero: ");
        int numero = int.Parse(Console.ReadLine());

        if (numero == 0)
        {
            Console.WriteLine("El numero es cero.");
        }
        else if (numero > 0)
        {
            Console.WriteLine("El numero es positivo.");
        }
        else
        {
            Console.WriteLine("El numero es negativo.");
        }
    }
}
