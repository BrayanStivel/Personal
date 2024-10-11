using System;

class Program
{
    static void Main()
    {
        Console.Write("Ingrese su edad: ");
        int edad = int.Parse(Console.ReadLine());

        Console.Write("Ingrese su genero (1: femenino, 2: masculino): ");
        int genero = int.Parse(Console.ReadLine());

        double pulsaciones;

        if (genero == 1)
        {
            pulsaciones = (220 - edad) / 10.0;
        }
        else
        {
            pulsaciones = (210 - edad) / 10.0;
        }

        Console.WriteLine($"El numero de pulsaciones es: {pulsaciones}");
    }
}
