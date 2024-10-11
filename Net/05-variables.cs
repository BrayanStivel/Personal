using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        double numero, porcentaje20;

        // Solicitar al usuario que ingrese un numero
        Console.WriteLine("Ingrese un numero:");
        numero = double.Parse(Console.ReadLine());

        // Calcular el 20% del numero
        porcentaje20 = numero * 0.20;

        // Mostrar el resultado
        Console.WriteLine("El 20% del numero es: " + porcentaje20);
    }
}
