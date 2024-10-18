using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        int añoActual, añoNacimiento, edad;

        // Solicitar al usuario que ingrese el año actual
        Console.WriteLine("Ingrese el año actual:");
        añoActual = int.Parse(Console.ReadLine());

        // Solicitar al usuario que ingrese su año de nacimiento
        Console.WriteLine("Ingrese su año de nacimiento:");
        añoNacimiento = int.Parse(Console.ReadLine());

        // Calcular la edad
        edad = añoActual - añoNacimiento;

        // Mostrar el resultado
        Console.WriteLine("Su edad es: " + edad);
    }
}
