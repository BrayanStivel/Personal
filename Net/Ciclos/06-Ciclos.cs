using System;

class Program
{
    static void Main()
    {
        // Mostrar el patron como triangulo con asteriscos
        int n = 5;

        // Parte superior del triángulo
        for (int i = 1; i <= n; i++)
        {
            Console.WriteLine("* " + new string('*', i - 1).Replace("*", "* ") );
        }

        // Parte inferior del triángulo
        for (int i = n - 1; i > 0; i--)
        {
            Console.WriteLine("* " + new string('*', i - 1).Replace("*", "* ") );
        }
    }
}
