using System;

class Program
{
    static void Main()
    {
        // Leer 10 números del teclado y encontrar su suma y promedio
        int suma = 0;
        const int cantidadNumeros = 10;

        for (int i = 0; i < cantidadNumeros; i++)
        {
            Console.Write("Ingrese un numero: ");
            int num = int.Parse(Console.ReadLine());
            suma += num;
        }

        double promedio = (double)suma / cantidadNumeros;
        Console.WriteLine("La suma de los numeros es: " + suma);
        Console.WriteLine("El promedio de los numeros es: " + promedio);
    }
}
