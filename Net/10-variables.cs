using System;

class Program
{
    static void Main()
    {
        // Declaracion de variables
        double salarioDiario, diasTrabajados, salarioBruto, descuentoPension, descuentoSalud, salarioNeto;

        // Solicitar al usuario que ingrese el salario diario
        Console.WriteLine("Ingrese el salario diario:");
        salarioDiario = double.Parse(Console.ReadLine());

        // Solicitar al usuario que ingrese el número de días trabajados
        Console.WriteLine("Ingrese el numero de dias trabajados:");
        diasTrabajados = double.Parse(Console.ReadLine());

        // Calcular el salario bruto
        salarioBruto = salarioDiario * diasTrabajados;

        // Calcular los descuentos
        descuentoPension = salarioBruto * 0.10;
        descuentoSalud = salarioBruto * 0.15;

        // Calcular el salario neto
        salarioNeto = salarioBruto - (descuentoPension + descuentoSalud);

        // Mostrar el resultado
        Console.WriteLine("El salario neto a pagar es: " + salarioNeto);
    }
}
