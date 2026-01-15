import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu de Calculos");
        System.out.println("1.-Calcular IMC");
        System.out.println("2.-Calcular área de un rectángulo");
        System.out.println("3.-Convertir °C a °F");
        System.out.println("4.-Calcular area de un circulo");
        System.out.println("5.-Salir");
        int opciones = sc.nextInt();

        switch (opciones){
            case 1:
                System.out.println("Calculadora de IMC");
                double pesoKg= obtenerDouble(sc, "Ingresa el peso en Kilogramos: ");
                double alturaM= obtenerDouble(sc, "Ingresa tu altura en metros: ");
                double IMC=calcularIMC(pesoKg, alturaM);
                System.out.println("IMC: "+IMC);
            case 2:
                System.out.println("Calculadora de Area de Rectangulo");
                double medidaALTURA = obtenerArea(sc, "Ingresa la altura del rectangulo: ");
                double medidaBASE = obtenerArea(sc, "Ingresa la base del rectangulo: ");
                double areaRectangulo = calcularAreaRectangulo(medidaBASE, medidaALTURA);
                System.out.println("El area del rectangulo es: "+areaRectangulo);
        }

    }

    /**
     * Muestreo de mensaje y registro de los datos dados
     * @param sc
     * @param mensaje
     * @return
     */
    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**
     * Calculo de los datos y devolucion del resultado
     * @param pesoKg
     * @param alturaM
     * @return
     */
    public static double calcularIMC(double pesoKg, double alturaM){
        return pesoKg/(alturaM*alturaM);
    }

    public static double obtenerArea(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    public static double calcularAreaRectangulo(double medidaALTURA, double medidaBASE){
        return medidaALTURA*medidaBASE;
    }


}