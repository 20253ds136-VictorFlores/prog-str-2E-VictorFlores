import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static double variableA;
    public static double variableB;
    public static int opcion;
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu de Calculos");
        System.out.println("1.-Suma");
        System.out.println("2.-Restar");
        System.out.println("3.-Multiplicar");
        System.out.println("4.-Dividir");
        opcion = sc.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Calculadora de Suma");
                variableA = obtenerDouble(sc, "Ingresa un valor a la variableA: ");
                variableB = obtenerDouble(sc, "Ingresa un valor a la variableB: ");
                double respuestaSuma = calcularOperacion(variableA, variableB);
                System.out.println("El resultado de la suma es: "+respuestaSuma);
                break;
            case 2:
                System.out.println("Calculadora de Resta");
                variableA = obtenerDouble(sc, "Ingresa un valor a la variableA: ");
                variableB = obtenerDouble(sc, "Ingresa un valor a la variableB: ");
                double respuestaResta = calcularOperacion(variableB, variableA);
                System.out.println("El resultado de la resta es: "+respuestaResta);
                break;
            case 3:
                System.out.println("Calculadora de Multiplicacion");
                variableA = obtenerDouble(sc, "Ingresa un valor a la variableA: ");
                variableB = obtenerDouble(sc, "Ingresa un valor a la variableB: ");
                double respuestaMultiplicacion = calcularOperacion(variableB, variableA);
                System.out.println("El resultado de la multiplicacion es: "+respuestaMultiplicacion);
                break;
            case 4:
                System.out.println("Calculadora de Division");
                variableA = obtenerDouble(sc, "Ingresa un valor a la variableA: ");
                variableB = obtenerDouble(sc, "Ingresa un valor a la variableB: ");
                if (variableB == 0){
                    System.out.println("No se puede dividir entre cero");
                    break;
                }
                double respuestaDivision = calcularOperacion(variableB, variableA);
                System.out.println("El resultado de la division es: "+respuestaDivision);
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }

    /**
     * Metodo que retornara los valores que se ingresaron en la terminal
     * @param sc -> declarado en el main
     * @param mensaje -> muestra los mensajes para los usuarios
     * @return -> double
     */
    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**
     * Este metodo sirve para hacer el calculo de los datos obtenidos
     * @param variableA ->se registra un valor para hacer la operacion
     * @param variableB ->se registra un valor para hacer la operacion
     * @return el resultado de cada operacion segun la opcion escogida
     */
    public static double calcularOperacion(double variableA, double variableB){
        if (opcion == 1){
            return variableA + variableB;
        } else if (opcion == 2) {
            return variableA - variableB;
        } else if (opcion == 3) {
            return variableA * variableB;
        }else {
            return  variableA / variableB;
        }
    }
}