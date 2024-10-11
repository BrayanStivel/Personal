using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        double distanciaMetros, km, cm, mm;

        // Solicitar al usuario que ingrese la distancia en metros
        Console.WriteLine("Ingrese la distancia en metros:");
        distanciaMetros = double.Parse(Console.ReadLine());

        // Realizar las conversiones
        km = distanciaMetros / 1000;
        cm = distanciaMetros * 100;
        mm = distanciaMetros * 1000;

        // Mostrar el resultado
        Console.WriteLine("Distancia: " + km + " km, " + cm + " cm, " + mm + " mm");
    }
}
