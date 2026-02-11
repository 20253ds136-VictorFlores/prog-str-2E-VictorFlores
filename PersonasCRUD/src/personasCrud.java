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

    /**
     * Busca una persona por su ID y muestra el resultado.
     *
     * Pide al usuario que ingrese un ID, lo busca en la lista de personas
     * y verifica si está activa. Si la encuentra, imprime su información.
     * Si no existe o está inactiva, muestra un mensaje de aviso.
     *
     * @param sc objeto Scanner para leer los datos ingresados por el usuario
     */
    static void buscar(Scanner sc) {
        System.out.print("Ingresa el ID a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Persona personaA = obtenerPersona(id);
        if (personaA != null && personaA.ACTIVAS()) {
            System.out.println("Encontrada: " + personaA);
        } else {
            System.out.println("No encontrada o inactiva.");
        }
    }

    /**
     * Da de baja a una persona usando su ID.
     *
     * Pide al usuario el ID de la persona y la busca en la lista.
     * Si la encuentra y está activa, la marca como inactiva.
     * Si no existe o ya estaba inactiva, muestra un mensaje de aviso.
     *
     * @param sc objeto Scanner para leer los datos ingresados por el usuario
     */
    static void baja(Scanner sc) {
        System.out.print("Ingrese ID a dar de baja: ");
        int id = sc.nextInt();
        sc.nextLine();
        Persona personaA = obtenerPersona(id);
        if (personaA != null && personaA.ACTIVAS()) {
            personaA.setActive(false);
            System.out.println("Persona dada de baja.");
        } else {
            System.out.println("No encontrada o ya inactiva.");
        }
    }

    /**
     * Muestra en pantalla todas las personas que están activas.
     *
     * Recorre la lista de personas registradas y, por cada una que
     * siga activa, imprime su información en la consola.
     */
    static void listarPersonas() {
        System.out.println("---Personas activas---");
        for (int iniciadorContador = 0; iniciadorContador < CONTADOR; iniciadorContador++) {
            if (personas[iniciadorContador].ACTIVAS()) {
                System.out.println(personas[iniciadorContador]);
            }
        }
    }

    /**
     * Permite cambiar el nombre de una persona usando su ID.
     *
     * Pide al usuario el ID de la persona y busca si está registrada y activa.
     * Si la encuentra, solicita un nuevo nombre y lo actualiza.
     * Si el nombre es inválido o la persona no existe/está inactiva,
     * muestra un mensaje de error.
     *
     * @param sc objeto Scanner para leer los datos ingresados por el usuario
     */
    static void actualizarLista(Scanner sc) {
        System.out.print("Ingrese ID a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Persona personaA = obtenerPersona(id);
        if (personaA != null && personaA.ACTIVAS()) {
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

    /**
     * Revisa si ya existe una persona con el ID indicado.
     *
     * Recorre la lista de personas registradas y compara cada ID.
     * Si encuentra uno igual, devuelve true. Si no hay coincidencias,
     * devuelve false.
     *
     * @param id número que identifica a la persona
     * @return true si el ID ya está registrado, false en caso contrario
     */
    static boolean idExistente(int id) {
        for (int iniciadorContador = 0; iniciadorContador < CONTADOR; iniciadorContador++) {
            if (personas[iniciadorContador].getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca una persona en la lista usando su ID.
     *
     * Recorre todas las personas registradas y devuelve la que tenga
     * el mismo ID que se indicó. Si no encuentra ninguna, devuelve null.
     *
     * @param id número que identifica a la persona
     * @return la persona encontrada o null si no existe
     */
    static Persona obtenerPersona(int id) {
        for (int iniciadorContador = 0; iniciadorContador < CONTADOR; iniciadorContador++) {
            if (personas[iniciadorContador].getId() == id) {
                return personas[iniciadorContador];
            }
        }
        return null;
    }
}