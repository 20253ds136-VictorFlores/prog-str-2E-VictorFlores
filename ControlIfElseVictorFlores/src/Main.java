import java.util.Scanner;
public class Main {
    public static boolean esAlumno = false;
    public static boolean valorValido = false;
    public static int TARIFA;
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Registro de alumnos");
        System.out.print("¿Es un alumno? (True/False): ");
        if (sc.hasNextBoolean()) {
            esAlumno = sc.nextBoolean();
        } else {
            System.out.println("El valor esta mal. Escribe 'true' o 'false' para la función correcta.");
            System.exit(0);
        }
        int edadIngresada = pedirEdad(sc, "Ingresa tu edad: ");
        int tarifaFinal = calcularTarifa(edadIngresada, esAlumno);

        System.out.println("¿Es estudiante? "+esAlumno+", la edad del estudiante es de: "+edadIngresada+" años y su tarifa es de: "+tarifaFinal);
    }

    public static int datosIngresados(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }

    public static int pedirEdad(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        int edad = sc.nextInt();

        if (edad <= 0 || edad > 120) {
            System.out.println("Edad inválida");
            System.exit(0);
        }
        return edad;
    }

    public static int calcularTarifa(int edad, boolean esEstudiante) {
        if (edad < 12) {
            TARIFA = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (esEstudiante) {
                TARIFA = 60;
            } else {
                TARIFA = 80;
            }
        } else { // edad >= 18
            if (esEstudiante) {
                TARIFA = 90;
            } else {
                TARIFA = 120;
            }
        }
        return TARIFA;
    }
}