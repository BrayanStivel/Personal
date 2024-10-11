using System;

class Program
{
    static void Main()
    {
        // Calcular el factorial de un número dado
        Console.Write("Ingrese un numero para calcular su factorial: ");
        int numero = int.Parse(Console.ReadLine());

        long factorial = 1; // Usar long para evitar desbordamiento en números grandes
        for (int i = 1; i <= numero; i++)
        {
            factorial *= i;
        }

        Console.WriteLine("El factorial de " + numero + " es: " + factorial);
    }
}
