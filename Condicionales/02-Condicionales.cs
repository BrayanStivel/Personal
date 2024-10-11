using System;

class Program
{
    static void Main()
    {
        Console.Write("Ingrese su nombre: ");
        string nombre = Console.ReadLine();
        
        Console.Write("Ingrese su edad: ");
        int edad = int.Parse(Console.ReadLine());

        if (edad < 0 || edad > 100)
        {
            Console.WriteLine("Ingrese una edad valida.");
        }
        else if (edad >= 18)
        {
            Console.WriteLine("Usted es mayor de edad.");
        }
        else
        {
            Console.WriteLine("Usted es menor de edad.");
        }
    }
}
