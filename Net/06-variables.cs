using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        double numero, porcentaje30, porcentaje60, porcentaje90;

        // Solicitar al usuario que ingrese un numero
        Console.WriteLine("Ingrese un numero:");
        numero = double.Parse(Console.ReadLine());

        // Calcular los porcentajes
        porcentaje30 = numero * 0.30;
        porcentaje60 = numero * 0.60;
        porcentaje90 = numero * 0.90;

        // Mostrar los resultados
        Console.WriteLine("30%: " + porcentaje30 + ", 60%: " + porcentaje60 + ", 90%: " + porcentaje90);
    }
}
