import java.util.Scanner;

public class Main {

    public static double variableA;
    public static int opcion;
    public static int contadorC = 0;
    public static int contadorF = 0;
    public static int contadorMi = 0;
    public static int contadorKm = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nMenu de Operaciones");
            System.out.println("1.-Conversion de C° a F°");
            System.out.println("2.-Conversion de F° a C°");
            System.out.println("3.-Conversion de Kilometros a Millas");
            System.out.println("4.-Conversion de Millas a Kilometros");
            System.out.println("5.-Salir");

            if (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Debes ingresar un número.");
                sc.next();
                continue;
            }
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    variableA = obtenerDatos(sc, "Ingresa los C° a convertir: ");
                    double respuestaConversionC = calcularConversiones(variableA, 1);
                    System.out.printf("El resultado de la conversion de C° a F° es %.2f F°%n", respuestaConversionC);
                    contadorC++;
                    break;
                case 2:
                    variableA = obtenerDatos(sc, "Ingresa los F° a convertir: ");
                    double respuestaConversionF = calcularConversiones(variableA, 2);
                    System.out.printf("El resultado de la conversión de F° a C° es %.2f C°%n", respuestaConversionF);
                    contadorF++;
                    break;
                case 3:
                    variableA = obtenerDatos(sc, "Ingresa los Kilometros a calcular: ");
                    double respuestaConversionKm = calcularConversiones(variableA, 3);
                    System.out.printf("La conversion de Kilometros a Millas es de: %.2f%n", respuestaConversionKm);
                    contadorKm++;
                    break;
                case 4:
                    variableA = obtenerDatos(sc, "Ingresa las Millas a calcular: ");
                    double respuestaConversionMilla = calcularConversiones(variableA, 4);
                    System.out.printf("La conversion de Millas a Kilometros es de: %.2f%n", respuestaConversionMilla);
                    contadorMi++;
                    break;
                case 5:
                    imprimirResumen();
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 5);
    }

    /**
     * Muestra un mensaje en pantalla y registra el valor ingresado por el usuario.
     * Valida que la entrada sea numerica antes de devolverla.
     * @param sc -> Scanner utilizado para leer los valores.
     * @param mensaje -> Mensaje que se muestra al usuario.
     * @return El numero ingresado por el usuario como double.
     */
    public static double obtenerDatos(Scanner sc, String mensaje){
        double valor;
        while (true){
            System.out.println(mensaje);
            if (sc.hasNextDouble()){
                valor = sc.nextDouble();
                break;
            } else {
                System.out.println("Entrada invalida. Ingresa un numero.");
                sc.next();
            }
        }
        return valor;
    }

    /**
     * Compara la opcion ingresada por la consola, evalua y elabora la operacion correspondiente
     * @param variableA -> Variable ingresada y declarada por el usuario
     * @param opcion -> parametro usado para escoger una opcion y a su vez realizar la operacion de la misma
     * @return devuelve el resultado de la operacion elaborada
     */
    public static double calcularConversiones(double variableA, int opcion) {
        double resultadoConversion = 0;
        if (opcion == 1) {
            resultadoConversion = (variableA * (9.0/5.0)) + 32;
        } else if (opcion == 2) {
            resultadoConversion = (variableA - 32) / 1.8;
        } else if (opcion == 3) {
            resultadoConversion = variableA * 0.621371;
        } else if (opcion == 4) {
            resultadoConversion = variableA * 1.60934;
        }
        return resultadoConversion;
    }

    /**
     * Imprime los procesos elaborados y la cantidad de ellos
     */
    public static void imprimirResumen(){
        int total = contadorC + contadorF + contadorKm + contadorMi;
        System.out.println("Resumen de conversiones");
        System.out.println("Total de conversiones: "+total);
        System.out.println("C° a F°: "+contadorC);
        System.out.println("F° a C°: "+contadorF);
        System.out.println("Kilometros a Millas: "+contadorKm);
        System.out.println("Millas a Kilometros: "+contadorMi);
    }
}