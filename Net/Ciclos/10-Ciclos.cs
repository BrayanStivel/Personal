using System;

class Program
{
    static void Main()
    {
        // Mostrar el patron como Z con asteriscos
        Console.WriteLine("*******");

        for (int i = 0; i < 5; i++)
        {
            Console.WriteLine(new string(' ', 5 - i - 1) + "*");
        }

        Console.WriteLine("*******");
    }
}
