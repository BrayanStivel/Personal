<?php
//Programa que permita a una tienda saber el valor que pagara un cliente por la compra
// de varios elementos de la misma referencia. Debe tener como entradas el valor unitario, 
//la cantidad de productos comprados y al valor final se debe adicionar el 16% correspondiente al IVA.
$Valor_por_unidad = 1500;
$cantidad = 2;
$subtotal = $Valor_por_unidad * $cantidad;
$iva = $subtotal * 0.16;


$total = $subtotal + $iva;

echo "El subtotal:  ". $subtotal;
echo "El valor  IVA".$iva ; ."br";
echo "El total es: ". $total;