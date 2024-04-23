<?php
//programa que permita calcular el 30%, el 60% y el 90% de cualquier número.
$Num = readline("Escribe el numero a que quieras conocer el porcentaje: ");
$porcentaje = $Num * 30 / 100;
$porcentaje2 = $Num * 60 / 100;
$porcentaje3 = $Num * 90 / 100;

echo "El 30% de tu numero es: " . $porcentaje;

echo "...................................";

echo "El 60% de tu numero es: " . $porcentaje2;

echo "...................................";

echo "El 90% de tu numero es: " . $porcentaje3;

echo "...................................";


?>