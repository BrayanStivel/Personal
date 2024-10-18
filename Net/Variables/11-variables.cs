using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        double numero, raiz, i;

        // Solicitar al usuario que ingrese un numero
        Console.WriteLine("Ingrese un numero:");
        numero = double.Parse(Console.ReadLine());

        // Inicializar la variable raiz
        raiz = 0;

        // Encontrar la raíz cuadrada utilizando un bucle
        for (i = 0; i * i <= numero; i += 0.01) { }

        // Ajustar la raiz al último valor válido
        raiz = i - 0.01;

        // Mostrar el resultado
        Console.WriteLine("La raiz cuadrada es: " + raiz);
    }
}
