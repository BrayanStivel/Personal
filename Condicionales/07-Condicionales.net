
using System;

class Program
{
    static void Main()
    {
        string menu = @"
Seleccione una opcion:
(1) Convertir de Celsius a Fahrenheit
(2) Convertir de Fahrenheit a Celsius
(3) Convertir de Celsius a Kelvin
(4) Convertir de Celsius a Rankine
(5) Convertir de Celsius a Reaumur
(6) Salir
";

        while (true)
        {
            // Mostrar el menú y solicitar la opción al usuario
            Console.WriteLine(menu);
            Console.Write("Ingrese el numero de la opcion que desea realizar o '6' para salir: ");
            string opcion = Console.ReadLine();

            // Convertir de Celsius a Fahrenheit
            if (opcion == "1")
            {
                Console.Write("Ingrese la temperatura en grados Celsius: ");
                double celsius = double.Parse(Console.ReadLine());
                double fahrenheit = (celsius * 9 / 5) + 32;
                Console.WriteLine($"{celsius} grados Celsius equivalen a {fahrenheit:F2} grados Fahrenheit.\n");
            }
            // Convertir de Fahrenheit a Celsius
            else if (opcion == "2")
            {
                Console.Write("Ingrese la temperatura en grados Fahrenheit: ");
                double fahrenheit = double.Parse(Console.ReadLine());
                double celsius = (fahrenheit - 32) * 5 / 9;
                Console.WriteLine($"{fahrenheit} grados Fahrenheit equivalen a {celsius:F2} grados Celsius.\n");
            }
            // Convertir de Celsius a Kelvin
            else if (opcion == "3")
            {
                Console.Write("Ingrese la temperatura en grados Celsius: ");
                double celsius = double.Parse(Console.ReadLine());
                double kelvin = celsius + 273.15;
                Console.WriteLine($"{celsius} grados Celsius equivalen a {kelvin:F2} grados Kelvin.\n");
            }
            // Convertir de Celsius a Rankine
            else if (opcion == "4")
            {
                Console.Write("Ingrese la temperatura en grados Celsius: ");
                double celsius = double.Parse(Console.ReadLine());
                double rankine = (celsius + 273.15) * 9 / 5;
                Console.WriteLine($"{celsius} grados Celsius equivalen a {rankine:F2} grados Rankine.\n");
            }
            // Convertir de Celsius a Reaumur
            else if (opcion == "5")
            {
                Console.Write("Ingrese la temperatura en grados Celsius: ");
                double celsius = double.Parse(Console.ReadLine());
                double reaumur = celsius * 4 / 5;
                Console.WriteLine($"{celsius} grados Celsius equivalen a {reaumur:F2} grados Reaumur.\n");
            }
            // Salir del programa
            else if (opcion == "6")
            {
                Console.WriteLine("¡Hasta luego!");
                break;
            }
            else
            {
                Console.WriteLine("Opcion no valida. Por favor ingrese una opcion valida (1, 2, 3, 4, 5 o 6).\n");
            }
        }
    }
}
