<?php
//Solicitar tiempo en segundos y transformar a horas y minutos.
echo"Por favor, introduzca el tiempo en segundos";
$segundo=readline();
$horas=$segundo/3600;
$segundo_restantes=$segundo%3600;
$minutos= $segundo_restantes/60;
echo"El tiempo en $segundo segundos equivale a $horas y $minutos minutos";
?>