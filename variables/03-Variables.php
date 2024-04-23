<?php
//Programa para calcular la distancia recorrida en un movimiento rectilíneo. 
//Recuerde $=v*tx$ donde $v$ es velocidad y $t$ es tiempo. Solicitar al usuario velocidad en 
//kilómetros por hora (Km/h) y tiempo en horas (h) para obtener la distancia en kilómetros (Km).
$Velocidad  = readline("Digite la velocidad recorrida en km:");
$Tiempo = readline("Digite el tiempo recorrido en H: ");
$Distancia = $Velocidad * $Tiempo;

echo "La distancia recorrida es: " . $Distancia;
echo "KM/H:  ";