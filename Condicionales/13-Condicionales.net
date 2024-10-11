using System;

class Program
{
    static void Main()
    {
        Console.Write("Ingrese su peso en Kg: ");
        double peso = double.Parse(Console.ReadLine());

        Console.Write("Ingrese su estatura en metros: ");
        double estatura = double.Parse(Console.ReadLine());

        double imc = peso / (estatura * estatura);

        if (imc < 18.5)
        {
            Console.WriteLine("Desnutrido");
        }
        else if (imc < 25)
        {
            Console.WriteLine("Normal");
        }
        else if (imc < 30)
        {
            Console.WriteLine("Sobrepeso");
        }
        else if (imc < 35)
        {
            Console.WriteLine("Obesidad Grado 1");
        }
        else if (imc < 40)
        {
            Console.WriteLine("Obesidad Grado 2");
        }
        else if (imc < 50)
        {
            Console.WriteLine("Obesidad Grado 3");
        }
        else
        {
            Console.WriteLine("Obesidad Grado 4");
        }
    }
}
