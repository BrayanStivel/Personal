using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        int numero, cuadrado;

        // Solicitar al usuario que ingrese un numero
        Console.WriteLine("Ingrese un numero:");
        numero = int.Parse(Console.ReadLine());

        // Calcular el cuadrado del numero
        cuadrado = numero * numero;

        // Mostrar el resultado
        Console.WriteLine("El cuadrado del numero es: " + cuadrado);
    }
}
