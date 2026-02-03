import java.util.Scanner;

public class CotizadorDeEnvio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator calculadora = new ShippingCalculator();
        System.out.println("--SISTEMA DE COTIZADORA DE ENVIOS--");
        double peso = leerDoubleEnRango(sc, "Ingrese el peso de puede ser de 0.1 a 50.0 kg: ", 0.1, 50.0);
        int distancia = leerIntEnRango(sc, "Ingrese la distancia debe ser de 1 a 2000 km: ", 1, 2000);
        System.out.println("Tipos de servicio: 1)-Estándar  2)-Express");
        int servicio = leerIntEnRango(sc, "Seleccione tipo de servicio (1 o 2): ", 1, 2);
        boolean esRemoto = leerBoolean(sc, "¿Tu zona es remota? (true/false): ");
        double subtotal = calculadora.calcularSubtotal(peso, distancia, servicio, esRemoto);
        double iva = calculadora.calcularIVA(subtotal);
        double total = calculadora.calcularTotal(subtotal, iva);
        imprimirTicket(servicio, peso, distancia, esRemoto, subtotal, iva, total);
        sc.close();
    }

    /**
     * Pide al usuario un numero con decimales dentro de un rango especifico.
     *
     * Muestra un mensaje en pantalla y espera la respuesta.
     * Si el usuario escribe algo que no es un numero válido,
     * se marca el error y se vuelve a pedir.
     * Tambien valida que el numero esté entre el minimo y el maxino
     * @param sc -> Scanner que se usa para leer lo que escribe el usuario.
     * @param mensaje -> Texto que aparece en pantalla para pedir el numero.
     * @param min -> Valor minimo permitido.
     * @param max -> Valor maximo permitido.
     * @return -> El numero ingresado por el usuario dentro del rango.
     */
    public static double leerDoubleEnRango(Scanner sc, String mensaje, double min, double max) {
        double valor;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextDouble()) {
                System.out.println("Dato incorrecto, Ingrese un numero válido.");
                sc.next();
                System.out.print(mensaje);
            }
            valor = sc.nextDouble();
            if (valor < min || valor > max) {
                System.out.println("Error el valor debe estar entre " + min + " y " + max);
            }
        } while (valor < min || valor > max);
        return valor;
    }

    /**
     * Pide al usuario un numero entero dentro de un rango especifico.
     *
     * Muestra un mensaje en pantalla y espera la respuesta.
     * Si el usuario escribe algo que no es un numero entero,
     * se le avisa y se vuelve a pedir.
     * Tambien valida que el numero este entre el minimo y el maxino
     * @param sc -> Scanner que se usa para leer lo que escribe el usuario.
     * @param mensaje -> Texto que aparece en pantalla para pedir el numero.
     * @param min -> Valor minimo permitido.
     * @param max -> Valor maxino permitido.
     * @return -> El numero entero ingresado por el usuario dentro del rango.
     */
    public static int leerIntEnRango(Scanner sc, String mensaje, int min, int max) {
        int valor;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un numero entero.");
                sc.next();
                System.out.print(mensaje);
            }
            valor = sc.nextInt();
            if (valor < min || valor > max) {
                System.out.println("Incorrecto el valor debe estar entre " + min + " y " + max);
            }
        } while (valor < min || valor > max);
        return valor;
    }

    /**
     * Pide al usuario que escriba un valor verdadero o falso.
     *
     * Muestra un mensaje en pantalla y espera la respuesta.
     * Si el usuario escribe algo distinto de "true" o "false",
     * se le avisa y se vuelve a pedir hasta que lo escriba correctamente.
     * @param sc -> Scanner que se usa para leer lo que escribe el usuario.
     * @param mensaje -> Texto que aparece en pantalla para pedir el dato.
     * @return -> El valor ingresado por el usuario (true o false).
     */
    public static boolean leerBoolean(Scanner sc, String mensaje) {
        boolean valor = false;
        boolean entradaValida = false;
        do {
            System.out.print(mensaje);
            if (sc.hasNextBoolean()) {
                valor = sc.nextBoolean();
                entradaValida = true;
            } else {
                System.out.println("Dato invalido debe escribir 'true' o 'false'.");
                sc.next();
            }
        } while (!entradaValida);
        return valor;
    }

    /**
     * Muestra en pantalla un ticket de envío con los datos principales.
     *
     * Incluye el tipo de servicio, peso, distancia, si la zona es remota,
     * así como el subtotal, el IVA y el total final.
     * @param servicio -> Numero que indica el tipo de servicio.
     * @param peso -> Peso del paquete en kilogramos.
     * @param dist -> Distancia del envío en kilometros.
     * @param remoto -> Indica si la zona es remota con un indicador booleano
     * @param sub -> Subtotal del costo antes de impuestos.
     * @param iva -> Impuesto calculado (IVA).
     * @param tot -> Total final del envío.
     */
    public static void imprimirTicket(int servicio, double peso, int dist, boolean remoto, double sub, double iva, double tot) {
        String nombreServicio;
        if (servicio == 1) {
            nombreServicio = "Estándar";
        } else {
            nombreServicio = "Express";
        }
        String zonaDiferente;
        if (remoto == true) {
            zonaDiferente = "SÍ";
        } else {
            zonaDiferente = "NO";
        }
        System.out.println("\n---------------------------------");
        System.out.println("      TICKET DE ENVÍO");
        System.out.println("---------------------------------");
        System.out.printf("Servicio     : %s%n", nombreServicio);
        System.out.printf("Peso         : %.2f kg%n", peso);
        System.out.printf("Distancia    : %d km%n", dist);
        System.out.printf("Zona Remota  : %s%n", zonaDiferente);
        System.out.println("---------------------------------");
        System.out.printf("Subtotal     : $ %.2f%n", sub);
        System.out.printf("IVA (16%%)    : $ %.2f%n", iva);
        System.out.println("=================================");
        System.out.printf("TOTAL FINAL  : $ %.2f%n", tot);
        System.out.println("=================================");
    }
}