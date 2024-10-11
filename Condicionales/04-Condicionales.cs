using System;

class Program
{
    static void Main()
    {
        Console.Write("Ingrese el primer numero: ");
        int numero1 = int.Parse(Console.ReadLine());
        
        Console.Write("Ingrese el segundo numero: ");
        int numero2 = int.Parse(Console.ReadLine());

        if (numero1 == numero2)
        {
            Console.WriteLine("Los dos numeros son iguales.");
        }
        else if (numero1 > numero2)
        {
            Console.WriteLine("El primer numero es mayor y el segundo numero es menor.");
        }
        else
        {
            Console.WriteLine("El segundo numero es mayor y el primer numero es menor.");
        }
    }
}
