double cateto1, cateto2, hipotenusa;
Console.WriteLine("Ingrese el primer cateto:");
cateto1 = double.Parse(Console.ReadLine());
Console.WriteLine("Ingrese el segundo cateto:");
cateto2 = double.Parse(Console.ReadLine());
hipotenusa = Math.Sqrt(cateto1 * cateto1 + cateto2 * cateto2);
Console.WriteLine("La hipotenusa es: " + hipotenusa);
