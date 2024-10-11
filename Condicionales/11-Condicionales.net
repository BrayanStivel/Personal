using System;

class Program
{
    static void Main()
    {
        Console.Write("Ingrese el tamano de la pizza (1: pequena, 2: mediana, 3: grande): ");
        int tamanoPizza = int.Parse(Console.ReadLine());
        
        Console.Write("Ingrese la cantidad de ingredientes adicionales: ");
        int ingredientesAdicionales = int.Parse(Console.ReadLine());

        int precioPizza = 0;

        switch (tamanoPizza)
        {
            case 1:
                precioPizza = 15000;
                break;
            case 2:
                precioPizza = 24000;
                break;
            case 3:
                precioPizza = 36000;
                break;
            default:
                Console.WriteLine("Tamano de pizza no valido.");
                return; // Termina el programa si el tamaño es inválido.
        }

        int precioTotal = precioPizza + (ingredientesAdicionales * 4000);
        Console.WriteLine($"El precio a pagar es: {precioTotal}");
    }
}
