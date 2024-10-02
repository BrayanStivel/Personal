//Calcluladora que haga 7 operaciones
//Que el usuario pueda elegir la operacion que quiera realizar
import java.util.Scanner; // Importa la clase Scanner para leer lo que el usuario escriba en consola

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para la entrada
        int opcion; // Variable para almacenar la opcion que elija el usuario
        
        // Bucle do-while para mostrar el menu hasta que el usuario decida salir
        do {
            // Muestra el menu de operaciones
            System.out.println("Seleccione una operacion:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Modulo");
            System.out.println("6. Potencia");
            System.out.println("7. Raiz cuadrada");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt(); // Lee la opcion elegida por el usuario
            
            // segun lo que el usuario elija, nos dara una de las opciones seleccionadas
            switch (opcion) {
                case 1:
                    realizarSuma(scanner);
                    break;
                case 2:
                    realizarResta(scanner);
                    break;
                case 3:
                    realizarMultiplicacion(scanner);
                    break;
                case 4:
                    realizarDivision(scanner);
                    break;
                case 5:
                    realizarModulo(scanner);
                    break;
                case 6:
                    realizarPotencia(scanner);
                    break;
                case 7:
                    realizarRaizCuadrada(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 0); // Continua el bucle hasta que el usuario elija salir
        
        scanner.close(); // Cierra el scanner al finalizar
    }

    // Metodo para realizar la suma 
    private static void realizarSuma(Scanner scanner) {
        System.out.print("Ingrese el numero 1: ");
        double numero1 = scanner.nextDouble(); // Lee el primer numero
        System.out.print("Ingrese el numero 2: ");
        double numero2 = scanner.nextDouble(); // Lee el segundo numero
        System.out.println("Resultado: " + (numero1 + numero2));
    }

    // Metodo para realizar la resta
    private static void realizarResta(Scanner scanner) {
        System.out.print("Ingrese el numero 1: ");
        double numero1 = scanner.nextDouble();
        System.out.print("Ingrese el numero 2: ");
        double numero2 = scanner.nextDouble();
        System.out.println("Resultado: " + (numero1 - numero2));
    }

    // Metodo para realizar la multiplicacion
    private static void realizarMultiplicacion(Scanner scanner) {
        System.out.print("Ingrese el numero 1: ");
        double numero1 = scanner.nextDouble();
        System.out.print("Ingrese el numero 2: ");
        double numero2 = scanner.nextDouble();
        System.out.println("Resultado: " + (numero1 * numero2));
    }

    // Metodo para realizar la division
    private static void realizarDivision(Scanner scanner) {
        System.out.print("Ingrese el numero 1: ");
        double numero1 = scanner.nextDouble();
        System.out.print("Ingrese el numero 2: ");
        double numero2 = scanner.nextDouble();
        if (numero2 != 0) {
            System.out.println("Resultado: " + (numero1 / numero2));
        } else {
            System.out.println("Error: Division por cero no permitida.");
        }
    }

    // Metodo para realizar el modulo de dos numeros
    private static void realizarModulo(Scanner scanner) {
        System.out.print("Ingrese el numero 1: ");
        double numero1 = scanner.nextDouble();
        System.out.print("Ingrese el numero 2: ");
        double numero2 = scanner.nextDouble();
        System.out.println("Resultado: " + (numero1 % numero2));
    }

    // Metodo para calcular la potencia
    //Math.pow() para calcular el numero 1 elevado a la potencia del 2
    private static void realizarPotencia(Scanner scanner) {
        System.out.print("Ingrese el numero 1 (base): ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese el numero 2 (exponente): ");
        double exponente = scanner.nextDouble();
        System.out.println("Resultado: " + Math.pow(base, exponente));
    }

    // Metodo para calcular la raiz cuadrada
    //Math.sqrt() para realizar la raiz cuadrada
    private static void realizarRaizCuadrada(Scanner scanner) {
        System.out.print("Ingrese el numero: ");
        double numero = scanner.nextDouble();
        if (numero >= 0) { // Verifica que el numero no sea negativo
            System.out.println("Resultado: " + Math.sqrt(numero));
        } else {
            System.out.println("Error: No se puede calcular la raiz cuadrada de un numero negativo.");
        }
    }
}
