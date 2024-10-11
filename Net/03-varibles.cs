using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        double velocidad, tiempo, distancia;

        // Solicitar al usuario que ingrese la velocidad
        Console.WriteLine("Ingrese la velocidad en Km/h:");
        velocidad = double.Parse(Console.ReadLine());

        // Solicitar al usuario que ingrese el tiempo
        Console.WriteLine("Ingrese el tiempo en horas:");
        tiempo = double.Parse(Console.ReadLine());

        // Calcular la distancia
        distancia = velocidad * tiempo;

        // Mostrar el resultado
        Console.WriteLine("La distancia recorrida es: " + distancia + " Km");
    }
}
