using System;

class Program
{
    static void Main()
    {
        // Encontrar la suma de los primeros 20 numeros naturales
        int suma = 0;

        for (int i = 1; i <= 20; i++)
        {
            suma += i;
        }

        Console.WriteLine("La suma de los primeros 20 numeros naturales es: " + suma);
    }
}
