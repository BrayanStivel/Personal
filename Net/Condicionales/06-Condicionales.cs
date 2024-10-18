using System;

class Program
{
    static void Main()
    {
        string menu = "Seleccione una opcion:\n" +
                      "1- Calcular el area de un cuadrado\n" +
                      "2- Calcular el area de un rectangulo\n" +
                      "3- Calcular el area de un paralelogramo\n" +
                      "4- Calcular el area de un rombo\n" +
                      "5- Calcular el area de un trapecio\n" +
                      "6- Calcular el area de un triangulo\n" +
                      "7- Calcular el area de un poligono regular\n" +
                      "8- Salir\n";

        Console.Write(menu);
        int opcion = int.Parse(Console.ReadLine());

        switch (opcion)
        {
            case 1:
                Console.Write("Ingresa el lado del cuadrado: ");
                double ladoCuadrado = double.Parse(Console.ReadLine());
                double areaCuadrado = ladoCuadrado * ladoCuadrado;
                Console.WriteLine($"El area del cuadrado es: {areaCuadrado}");
                break;

            case 2:
                Console.Write("Escriba la base del rectangulo: ");
                double baseRectangulo = double.Parse(Console.ReadLine());
                Console.Write("Escriba la altura del rectangulo: ");
                double alturaRectangulo = double.Parse(Console.ReadLine());
                double areaRectangulo = baseRectangulo * alturaRectangulo;
                Console.WriteLine($"El area del rectangulo es: {areaRectangulo}");
                break;

            case 3:
                Console.Write("Digite la base del paralelogramo: ");
                double baseParalelogramo = double.Parse(Console.ReadLine());
                Console.Write("Digite la altura del paralelogramo: ");
                double alturaParalelogramo = double.Parse(Console.ReadLine());
                double areaParalelogramo = baseParalelogramo * alturaParalelogramo;
                Console.WriteLine($"El area del paralelogramo es: {areaParalelogramo}");
                break;

            case 4:
                Console.Write("¿Cuál es el valor de la relación entre los lados A y C? ");
                double ladoAC = double.Parse(Console.ReadLine());
                Console.Write("¿Cuál es el valor de la relación entre los lados B y D? ");
                double ladoBD = double.Parse(Console.ReadLine());
                double areaRombo = (ladoAC * ladoBD) / 2;
                Console.WriteLine($"El area del rombo es: {areaRombo}");
                break;

            case 5:
                Console.Write("Ingrese el lado A: ");
                double ladoA = double.Parse(Console.ReadLine());
                Console.Write("Ingrese el lado B: ");
                double ladoB = double.Parse(Console.ReadLine());
                double baseTrapecio = (ladoA + ladoB) / 2;
                Console.Write("Ingrese la altura del trapecio: ");
                double alturaTrapecio = double.Parse(Console.ReadLine());
                double areaTrapecio = alturaTrapecio * baseTrapecio;
                Console.WriteLine($"El area del trapecio es: {areaTrapecio}");
                break;

            case 6:
                Console.Write("Ingrese la altura del triangulo: ");
                double alturaTriangulo = double.Parse(Console.ReadLine());
                Console.Write("Ingrese la base del triangulo: ");
                double baseTriangulo = double.Parse(Console.ReadLine());
                double areaTriangulo = (alturaTriangulo * baseTriangulo) / 2;
                Console.WriteLine($"El area del triangulo es: {areaTriangulo}");
                break;

            case 7:
                Console.Write("Ingrese el apotema: ");
                double apotema = double.Parse(Console.ReadLine());
                Console.Write("Ingrese el perimetro del poligono: ");
                double perimetroPoligono = double.Parse(Console.ReadLine());
                double areaPoligono = (perimetroPoligono * apotema) / 2;
                Console.WriteLine($"El area del poligono es: {areaPoligono}");
                break;

            case 8:
                Console.WriteLine("Saliendo del programa...");
                break;

            default:
                Console.WriteLine("Opcion no valida, por favor ingresar una opcion valida (1-8).");
                break;
        }
    }
}
