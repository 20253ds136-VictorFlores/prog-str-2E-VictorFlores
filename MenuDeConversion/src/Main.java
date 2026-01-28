import java.util.Scanner;

public class Main {

    public static double variableB;
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
                    System.out.println("Conversion de C° a F°");
                    variableA = obtenerDatos(sc, "Ingresa los C° a convertir: ");
                    double respuestaConversionC = calcularConversiones(variableA, 1);
                    System.out.printf("El resultado de la conversion de C° a F° es %.2f: ", respuestaConversionC,"F°");
                    contadorC++;
                    break;
                case 2:
                    System.out.println("Conversion de F° a C°");
                    variableA = obtenerDatos(sc, "Ingresa los F° a convertir: ");
                    double respuestaCoversionF = calcularConversiones(variableA, 2);
                    System.out.printf("El resultado de la conversión de F° a C° es %.2f%n", respuestaCoversionF,"C°");
                    contadorF++;
                    break;
                case 3:
                    System.out.println("Conversion de Kilometros a Millas");
                    variableA = obtenerDatos(sc, "Ingresa los Kilometros a calcular: ");
                    double respuestaConversionKm = calcularConversiones(variableA, 3);
                    System.out.printf("La conversion de Kilometros a Millas es de: ",respuestaConversionKm);
                    contadorKm++;
                    break;
                case 4:
                    System.out.println("Conversion de Millas a Kilometros");
                    variableA = obtenerDatos(sc, "Ingresa las Millas a calcular: ");
                    double respuestaConversionMilla = calcularConversiones(variableA, 4);
                    System.out.printf("La conversion de Millas a Kilometros es de: ",respuestaConversionMilla);
                    contadorMi++;
                    break;
                case 5:
                    System.out.println("Saliste del menu. Hasta luego.");
                    imprimirResumen();
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 5);
    }

    public static double obtenerDatos(Scanner sc, String mensaje){
        double valor;
        while (true){
            System.out.println(mensaje);
            if (sc.hasNextDouble()){
                valor = sc.nextDouble();
                break;
            }else {
                System.out.println("Entrada invalida. Ingresa un numero.");
                sc.next();
            }
        }
        return valor;
    }

    public static double calcularConversiones(double variableA, int opcion) {
        double resultadoConversion = 0;
        if (opcion == 1) {
            resultadoConversion = (variableA * (9.0/5.0)) + 32;
        } else if (opcion == 2) {
            resultadoConversion = (variableA - 32) / 1.8;
        } else if (opcion == 3) {
            resultadoConversion = variableA * 0.621371;
        } else if (opcion == 4) {
            resultadoConversion = variableA * 1609.34;
        }
        return resultadoConversion;
    }

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
