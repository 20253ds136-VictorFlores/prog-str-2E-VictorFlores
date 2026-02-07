import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService mostrar = new GradeService();
        System.out.println("--SISTEMA DE CONTROL DE CALIFICACIONES--");
        String nombre = leerTextoNoVacio(sc, "Ingrese el nombre del alumno: ");
        double califiacion1 = leerDoubleEnRango(sc, "Ingrese la primera calificacion: ", 0, 100);
        double califiacion2 = leerDoubleEnRango(sc, "Ingrese la segunda calificacion: ", 0, 100);
        double califiacion3 = leerDoubleEnRango(sc, "Ingrese la tercera calificacion: ", 0, 100);
        int asistencia = leerIntEnRango(sc, "Ingrese porcentaje de asistencia : ", 0, 100);
        boolean entregoProyecto = leerBoolean(sc, "¿Entregaste proyecto? (true/false): ");
        double promedio = mostrar.calcularPromedio(califiacion1, califiacion2, califiacion3);
        double calificacionFinal = mostrar.calcularFinal(promedio, asistencia);
        String estado = mostrar.determinarEstado(calificacionFinal, asistencia, entregoProyecto);
        imprimirReporteSistema(nombre, califiacion1, califiacion2, califiacion3, promedio, asistencia, entregoProyecto, calificacionFinal, estado);
        sc.close();
    }

    public static String leerTextoNoVacio(Scanner sc, String mensaje1) {
        String mensaje;
        do {
            System.out.print(mensaje1);
            mensaje = sc.nextLine().trim();
            if (mensaje.isEmpty()) {
                System.out.println("Debes de ingresar datos.");
            }
        } while (mensaje.isEmpty());
        return mensaje;
    }

    public static double leerDoubleEnRango(Scanner sc, String mensaje1, double min, double max) {
        double valor;
        do {
            System.out.print(mensaje1);
            while (!sc.hasNextDouble()) {
                System.out.println("Dato incorrecto, ingrese un número válido.");
                sc.next();
                System.out.print(mensaje1);
            }
            valor = sc.nextDouble();
            if (valor < min || valor > max) {
                System.out.println("El valor debe estar entre " + min + " y " + max);
            }
        } while (valor < min || valor > max);
        sc.nextLine();
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String mensaje1, int min, int max) {
        int valor;
        do {
            System.out.print(mensaje1);
            while (!sc.hasNextInt()) {
                System.out.println("Dato incorrecto, ingrese un número entero válido.");
                sc.next();
                System.out.print(mensaje1);
            }
            valor = sc.nextInt();
            if (valor < min || valor > max) {
                System.out.println("El valor debe estar entre " + min + " y " + max);
            }
        } while (valor < min || valor > max);
        sc.nextLine();
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String mensaje1) {
        boolean valor = false;
        boolean valido = false;
        do {
            System.out.print(mensaje1);
            if (sc.hasNextBoolean()) {
                valor = sc.nextBoolean();
                valido = true;
            } else {
                System.out.println("Dato inválido, debe escribir 'true' o 'false'.");
                sc.next();
            }
        } while (!valido);
        sc.nextLine();
        return valor;
    }

    public static void imprimirReporteSistema(String nombre, double califiacion1, double califiacion2, double califiacion3, double promedio, int asistencia, boolean entregoProyecto, double calificacionFinal, String estado) {
        System.out.println("========================");
        System.out.println("Promedio: " + promedio);
        System.out.println("========================");
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("========================");
        System.out.println("Proyecto entrego: " + entregoProyecto);
        System.out.println("========================");
        System.out.println("Calificacion final: " + calificacionFinal);
        System.out.println("========================");
        System.out.println("Estado: " + estado);
        System.out.println("=========================");
    }
}