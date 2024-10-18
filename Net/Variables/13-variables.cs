using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        int tiempoSegundos, horas, minutos;

        // Solicitar al usuario que ingrese el tiempo en segundos
        Console.WriteLine("Ingrese el tiempo en segundos:");
        tiempoSegundos = int.Parse(Console.ReadLine());

        // Calcular horas y minutos
        horas = tiempoSegundos / 3600;
        minutos = (tiempoSegundos % 3600) / 60;

        // Mostrar el resultado
        Console.WriteLine("Tiempo: " + horas + " horas y " + minutos + " minutos");
    }
}
