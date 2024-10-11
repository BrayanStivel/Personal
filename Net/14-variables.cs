double distanciaMetros, km, cm, mm;
Console.WriteLine("Ingrese la distancia en metros:");
distanciaMetros = double.Parse(Console.ReadLine());
km = distanciaMetros / 1000;
cm = distanciaMetros * 100;
mm = distanciaMetros * 1000;
Console.WriteLine("Distancia: " + km + " km, " + cm + " cm, " + mm + " mm");
