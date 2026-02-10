import java.util.Scanner;

public class personasCrud {
    static Persona[] personas = new Persona[20];
    public static int CONTADOR = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--Menu Personas CRUD simple--");
            System.out.println("1.-Darse de alta \n2.-Buscar por ID \n3.-Baja logica por ID \n4.-Listar activas \n5.-Actualizar nombre por ID (solo activas) \n0.-Salir");
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
                    baja(sc);
                    break;
                case 4:
                    listarPersonas();
                    break;
                case 5:
                    actualizarLista(sc);
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
        if (CONTADOR >= personas.length) {
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
            System.out.println("Nombre invalido, no exite algun dato.");
            return;
        }
        personas[CONTADOR++] = new Persona(id, nombre);
        System.out.println("Persona registrada con exito.");
    }

    static void buscar(Scanner sc) {
        System.out.print("Ingresa el ID a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Persona personaA = obtenerPersona(id);
        if (personaA != null && personaA.isActive()) {
            System.out.println("Encontrada: " + personaA);
        } else {
            System.out.println("No encontrada o inactiva.");
        }
    }

    static void baja(Scanner sc) {
        System.out.print("Ingrese ID a dar de baja: ");
        int id = sc.nextInt();
        sc.nextLine();
        Persona personaA = obtenerPersona(id);
        if (personaA != null && personaA.isActive()) {
            personaA.setActive(false);
            System.out.println("Persona dada de baja.");
        } else {
            System.out.println("No encontrada o ya inactiva.");
        }
    }

    static void listarPersonas() {
        System.out.println("---Personas activas---");
        for (int iniciadorContador = 0; iniciadorContador < CONTADOR; iniciadorContador++) {
            if (personas[iniciadorContador].isActive()) {
                System.out.println(personas[iniciadorContador]);
            }
        }
    }

    static void actualizarLista(Scanner sc) {
        System.out.print("Ingrese ID a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Persona personaA = obtenerPersona(id);
        if (personaA != null && personaA.isActive()) {
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("Nombre invalido.");
                return;
            }
            personaA.setName(nombre);
            System.out.println("Nombre actualizado.");
        } else {
            System.out.println("No encontrada o inactiva.");
        }
    }

    static boolean idExistente(int id) {
        for (int iniciadorContador = 0; iniciadorContador < CONTADOR; iniciadorContador++) {
            if (personas[iniciadorContador].getId() == id) return true;
        }
        return false;
    }

    static Persona obtenerPersona(int id) {
        for (int iniciadorContador = 0; iniciadorContador < CONTADOR; iniciadorContador++) {
            if (personas[iniciadorContador].getId() == id) return personas[iniciadorContador];
        }
        return null;
    }
}