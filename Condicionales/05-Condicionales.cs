using System;

class Program
{
    static void Main()
    {
        double[] notas = new double[5];

        for (int i = 0; i < 5; i++)
        {
            Console.Write($"Ingrese la nota {i + 1}: ");
            notas[i] = double.Parse(Console.ReadLine());
        }

        double promedio = 0;
        foreach (double nota in notas)
        {
            promedio += nota;
        }
        promedio /= notas.Length;

        if (promedio >= 3.0)
        {
            Console.WriteLine("Aprobo.");
        }
        else
        {
            Console.WriteLine("No aprobo.");
        }
    }
}
