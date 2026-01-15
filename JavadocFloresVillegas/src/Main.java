import java.util.Scanner;

public class Main {
    public static double VALOR_PI=3.1416;
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
        System.out.println("Menu de Calculos");
        System.out.println("1.-Calcular IMC");
        System.out.println("2.-Calcular área de un rectángulo");
        System.out.println("3.-Convertir °C a °F");
        System.out.println("4.-Calcular area de un circulo");
        System.out.println("5.-Salir");
        opcion = sc.nextInt();

        switch (opcion){
            case 1:
                System.out.println("Calculadora de IMC");
                double pesoKg= obtenerDouble(sc, "Ingresa el peso en Kilogramos: ");
                double alturaM= obtenerDouble(sc, "Ingresa tu altura en metros: ");
                double IMC=calcularIMC(pesoKg, alturaM);
                System.out.println("IMC: "+IMC);
                break;
            case 2:
                System.out.println("Calculadora de Area de Rectangulo");
                double medidaALTURA = obtenerDouble(sc, "Ingresa la altura del rectangulo: ");
                double medidaBASE = obtenerDouble(sc, "Ingresa la base del rectangulo: ");
                double areaRectangulo = calcularAreaRectangulo(medidaBASE, medidaALTURA);
                System.out.println("El area del rectangulo es: "+areaRectangulo);
                break;
            case 3:
                System.out.println("Convertidor de °C a °F");
                double valorC = obtenerDouble(sc, "Ingresa los °C para hacer la conversion a °F: ");
                double resultadoConversion = operacionConversion(valorC);
                System.out.println("La conversion es: "+resultadoConversion+"°F");
                break;
            case 4:
                System.out.println("Calculadora de area de Circulo");
                double valorRadio = obtenerDouble(sc, "Ingresa el valor del radio del circulo: ");
                break;
            case 5:
                System.out.println("Haz salido del menu, hasta luego");
                break;
            default:
                System.out.println("Opcion incorrecta");
        }
        }while (opcion >5);
    }

    /**
     * Metodo que retornara los valores que se ingresaron en la terminal
     * @param sc -> declarado en el main
     * @param mensaje -> es un parametro
     * @return -> double
     */
    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**
     * Este metodo sirve para hacer el calculo de los datos obtenidos
     * @param pesoKg ->se registra el valor en kilogramos
     * @param alturaM -> se registra el valor en metros
     * @return double IMC
     */
    public static double calcularIMC(double pesoKg, double alturaM){
        return pesoKg/(alturaM*alturaM);
    }

    /**
     * Este metodo calcula la area del rectangulo en base a los datos ingresados
     * @param medidaALTURA -> Variable que guarda el valor dado
     * @param medidaBASE -> Variable que guarda el valor dado
     * @return double area del rectangulo
     */
    public static double calcularAreaRectangulo(double medidaALTURA, double medidaBASE){
        return medidaALTURA*medidaBASE;
    }

    /**
     * Concertidor de grados Celsius a Fahrenheit
     * @param valorC -> variable con valor dado desde la terminal
     * @return grados Fahrenheit
     */
    public static double operacionConversion(double valorC){
        return (valorC * 1.8) + 32;
    }

    /**
     * Metodo que calcula el area del circulo
     * @param valorRadio -> medida del radio ingresado
     * @return Area del circulo
     */
    public static double operacionAreaCirculo(double valorRadio){
        return VALOR_PI * Math.pow(valorRadio, 2);
    }
}