import java.util.Scanner;

public class Personas2 {
    static PersonaCRUD[] alumnos = new PersonaCRUD[25];
    public static int CONTADOR = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--Menu Alumnos CRUD simple--");
            System.out.println("1.-Alta alumno");
            System.out.println("2.-Buscar por ID");
            System.out.println("3.-Actualizar promedio por ID");
            System.out.println("4.-Baja logica por ID");
            System.out.println("5.-Listar activos");
            System.out.println("6.-Reportes");
            System.out.println("0.-Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    alta(sc);
                    break;
                case 2:
                    buscar(sc);
                    break;
                case 3:
                    actualizarPromedio(sc);
                    break;
                case 4:
                    baja(sc);
                    break;
                case 5:
                    listarActivos();
                    break;
                case 6: reportes();
                    break;
                case 0:
                    System.out.println("Saliendo..., hasta luego");
                    break;
                default:
                    System.out.println("Opcion incorrecta, intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    static void alta(Scanner sc) {
        if (CONTADOR >= alumnos.length) {
            System.out.println("No hay espacio disponible.");
            return;
        }
        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (id <= 0) {
            System.out.println("ID invalido.");
            return;
        }
        if (idExistente(id)) {
            System.out.println("ID repetido, no se puede registrar.");
            return;
        }
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("Nombre invalido.");
            return;
        }
        System.out.print("Ingrese promedio (0-10): ");
        double promedio = sc.nextDouble();
        sc.nextLine();
        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio invalido.");
            return;
        }
        alumnos[CONTADOR++] = new PersonaCRUD();
        System.out.println("Alumno registrado con exito.");
    }

    static void buscar(Scanner sc) {
        System.out.print("Ingrese ID a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();
        PersonaCRUD a = obtenerAlumno(id);
        if (a != null && a.isActivo()) {
            System.out.println("Encontrado: " + a);
        } else {
            System.out.println("No encontrado o inactivo.");
        }
    }

    static void actualizarPromedio(Scanner sc) {
        System.out.print("Ingrese ID a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        PersonaCRUD a = obtenerAlumno(id);
        if (a != null && a.isActivo()) {
            System.out.print("Nuevo promedio (0-10): ");
            double promedio = sc.nextDouble();
            sc.nextLine();
            if (promedio < 0 || promedio > 10) {
                System.out.println("Promedio invalido.");
                return;
            }
            a.setPromedio(promedio);
            System.out.println("Promedio actualizado.");
        } else {
            System.out.println("No encontrado o inactivo.");
        }
    }

    static void baja(Scanner sc) {
        System.out.print("Ingrese ID a dar de baja: ");
        int id = sc.nextInt();
        sc.nextLine();
        PersonaCRUD a = obtenerAlumno(id);
        if (a != null && a.isActivo()) {
            a.setActivo(false);
            System.out.println("Alumno ya dado de baja.");
        } else {
            System.out.println("No encontrado o ya inactivo.");
        }
    }

    static void listarActivos() {
        System.out.println("---Alumnos activos---");
        for (int i = 0; i < CONTADOR; i++) {
            if (alumnos[i].isActivo()) {
                System.out.println(alumnos[i]);
            }
        }
    }

    static void reportes() {
        if (CONTADOR == 0) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        double suma = 0;
        int activos = 0;
        PersonaCRUD mayor = null;
        PersonaCRUD menor = null;
        int sobresalientes = 0;

        for (int i = 0; i < CONTADOR; i++) {
            PersonaCRUD a = alumnos[i];
            if (a.isActivo()) {
                activos++;
                suma += a.getPromedio();
                if (mayor == null || a.getPromedio() > mayor.getPromedio()) mayor = a;
                if (menor == null || a.getPromedio() < menor.getPromedio()) menor = a;
                if (a.getPromedio() >= 8.0) sobresalientes++;
            }
        }

        if (activos == 0) {
            System.out.println("No hay alumnos activos.");
            return;
        }

        System.out.println("Promedio general de activos: " + (suma / activos));
        System.out.println("PersonaCRUD con mayor promedio: " + mayor);
        System.out.println("PersonaCRUD con menor promedio: " + menor);
        System.out.println("Alumnos con promedio >= 8.0: " + sobresalientes);
    }

    static boolean idExistente(int id) {
        for (int i = 0; i < CONTADOR; i++) {
            if (alumnos[i].getId() == id) return true;
        }
        return false;
    }

    static PersonaCRUD obtenerAlumno(int id) {
        for (int i = 0; i < CONTADOR; i++) {
            if (alumnos[i].getId() == id) return alumnos[i];
        }
        return null;
    }
}