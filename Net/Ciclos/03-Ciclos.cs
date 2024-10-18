## Mostrar n términos de la serie Fibonacci y su suma
n = int(input("Ingrese el número de términos de la serie Fibonacci: "))

a, b = 0, 1
suma = 0
print("Los primeros", n, "términos de la serie Fibonacci son:")
for _ in range(n):
    print(a, end=" ")
    suma += a
    a, b = b, a + b

print("\nLa suma de los primeros", n, "términos de Fibonacci es:", suma)
