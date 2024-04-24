<?php
//Programa que solicite un número al usuario 
//y permita calcular la raíz cuadrada del mismo (sin usar función).
echo "Por favor, introduce un número: ";
$numero = readline();
$aproximacion = $numero / 2;
$tolerancia = 0.0001;
while (abs($aproximacion * $aproximacion - $numero) > $tolerancia) {
$aproximacion = ($aproximacion + $numero / $aproximacion) / 2;
}
echo "La raíz cuadrada de $numero es aproximadamente: $aproximacion";
?>