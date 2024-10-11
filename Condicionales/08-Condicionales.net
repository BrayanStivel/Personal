using System;

class Program
{
    static void Main()
    {
        int[] numeros = new int[3];

        for (int i = 0; i < 3; i++)
        {
            Console.Write($"Ingrese el numero {i + 1}: ");
            numeros[i] = int.Parse(Console.ReadLine());
        }

        Array.Sort(numeros);
        Console.WriteLine("Orden ascendente: " + string.Join(", ", numeros));

        Array.Reverse(numeros);
        Console.WriteLine("Orden descendente: " + string.Join(", ", numeros));
    }
}
