import java.util.Scanner;

public class Main {
    public static double variableB;
    public static double variableA;
    public static int opcion;
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menu de Operaciones");
            System.out.println("1.-Conversion de C° a F°");
            System.out.println("2.-Conversion de F° a C°");
            System.out.println("3.-Conversion de Kilometros a Millas");
            System.out.println("4.-Conversion de Millas a Kilometros");
            System.out.println("5.-Salir");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Conversion de C° a F°");
                    variableA = obtenerDatos(sc, "Ingresa los C° a convertir: ");
                    double respuestaCoversionC = calcularConversiones(variableB);
                    System.out.printf("El resultado de la conversion de C° a F° es %.2f: ", respuestaCoversionC,"F°");
                    break;
                case 2:
                    System.out.println("Conversion de F° a C°");
                    variableA = obtenerDatos(sc, "Ingresa los F° a convertir: ");
                    double respuestaCoversionF = calcularConversiones(variableA);
                    System.out.printf("El resultado de la conversión de F° a C° es %.2f%n", respuestaCoversionF,"C°");
                    break;
                case 3:
                    System.out.println("Conversion de Kilometros a Millas");
                    variableA = obtenerDatos(sc, "Ingresa los Kilometros a calcular: ");
                    double respuestaConversionKm = calcularConversiones(variableA);
                    System.out.printf("La conversion de Kilometros a Millas es de: ",respuestaConversionKm," Millas");
                    break;
                case 4:
                    System.out.println("Conversion de Millas a Kilometros");
                    variableA = obtenerDatos(sc, "Ingresa las Millas a calcular: ");
                    double respuestaConversionMilla = calcularConversiones(variableA);
                    System.out.printf("La conversion de Millas a Kilometros es de: ",respuestaConversionMilla," Kilometros");
                    break;
                case 5:
                    System.out.println("Saliste del menu. Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 5);
    }

    public static double obtenerDatos(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    public static double calcularConversiones(double variableA){
        double resultadoConversion=0;
        if (opcion==1){
        resultadoConversion = (variableA * (9/5)) + 32;
        } else if (opcion==2) {
            resultadoConversion = (variableA - 32)/1.8;
        } else if (opcion==3) {
            resultadoConversion = variableA * 0.621371;
        }else {
            resultadoConversion = variableA * 160934;
        }
        return resultadoConversion;
    }

}
