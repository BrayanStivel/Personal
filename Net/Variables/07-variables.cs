using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        double lado, area;

        // Solicitar al usuario que ingrese la longitud de un lado del cuadrado
        Console.WriteLine("Ingrese la longitud de un lado del cuadrado:");
        lado = double.Parse(Console.ReadLine());

        // Calcular el área del cuadrado
        area = lado * lado;

        // Mostrar el resultado
        Console.WriteLine("El area del cuadrado es: " + area);
    }
}
