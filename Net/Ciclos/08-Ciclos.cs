using System;

class Program
{
    static void Main()
    {
        int numNiveles = 4;
        int contador = 1;
        int maximoNumero = 10;

        int maxDigitos = maximoNumero.ToString().Length;

        for (int i = 1; i <= numNiveles; i++)
        {
            int numElementos = i;
            int espaciosIniciales = (numNiveles - i) * (maxDigitos + 1) / 2;

            // Imprimir espacios iniciales
            Console.Write(new string(' ', espaciosIniciales));

            for (int j = 0; j < numElementos; j++)
            {
                Console.Write($"{contador.ToString().PadLeft(maxDigitos)} ");
                contador++;
                if (contador > maximoNumero)
                {
                    break;
                }
            }
            Console.WriteLine();
        }
    }
}
