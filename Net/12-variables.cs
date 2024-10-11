using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        double cateto1, cateto2, hipotenusa;

        // Solicitar al usuario que ingrese el primer cateto
        Console.WriteLine("Ingrese el primer cateto:");
        cateto1 = double.Parse(Console.ReadLine());

        // Solicitar al usuario que ingrese el segundo cateto
        Console.WriteLine("Ingrese el segundo cateto:");
        cateto2 = double.Parse(Console.ReadLine());

        // Calcular la hipotenusa
        hipotenusa = Math.Sqrt(cateto1 * cateto1 + cateto2 * cateto2);

        // Mostrar el resultado
        Console.WriteLine("La hipotenusa es: " + hipotenusa);
    }
}
