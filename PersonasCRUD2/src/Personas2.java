import java.util.Scanner;

public class Personas2 {
    static PersonaCRUD[] alumnos = new PersonaCRUD[25];

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
                    alta(alumnos,sc);
                    break;
                case 2:
                    buscar(alumnos,sc);
                    break;
                case 3:
                    actualizarPromedio(alumnos,sc);
                    break;
                case 4:
                    baja(alumnos,sc);
                    break;
                case 5:
                    listarActivos(alumnos);
                    break;
                case 6:
                    reportes(alumnos);
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

    /**
     * Metodo para validar el promedio
     * @param sc -> Declarado en Main
     * @param mensaje -> Envia mensaje a terminal
     * @return -> double
     */
    public static double validarDouble(Scanner sc, String mensaje){
        double input;
        while (true){
            System.out.println(mensaje);
            if (sc.hasNextDouble()){
                input=sc.nextDouble();
                if (input>=0 && input<=10){
                    return input;
                }else {
                    System.out.println("Promedio fuera de rango");
                }
            }else {
                System.out.println("Valor ingresado no valido");
                sc.next();
            }
        }
    }

    /**
     * Metodo para validar el ID
     * @param sc -> declarado en Main
     * @param mensaje -> es un parámetro (Envía mensaje a terminal)
     * @return -> int
     */
    public static int validarID(Scanner sc, String mensaje){
        int input;
        while (true){
            System.out.println(mensaje);
            if (sc.hasNextInt()){
                input=sc.nextInt();
                return input;
            }else {
                System.out.println("Valor no numerico");
                sc.next();
            }
        }
    }

    /**
     * Metodo para dar de alta y llenar el arreglo
     * @param alumnos -> arreglo
     * @param sc -> Declarado en Main
     */
    public static void alta(PersonaCRUD[] alumnos, Scanner sc){
        String nombre="";
        int id=validarID(sc,"Ingresa el ID de la persona: ");
        if (id<=0){
            System.out.println("No se admiten valor menores o iguales a 0");
            return;
        } else if (verificarID(id, alumnos)) {
            System.out.println("ID no valido, ya existe");
            return;
        } else {
            System.out.println("Ingresa el nombre de la persona: ");
            nombre=sc.next();
            if (nombre.isBlank()){
                System.out.println("No se admite un nombre vacio");
                sc.next();
            }
        }
        double promedio=validarDouble(sc, "Ingresa el promedio del alumno: ");
        int indiceInsercion=obtenerIndice(alumnos);
        if (indiceInsercion==-1){
            System.out.println("El arreglo esta lleno");
            return;
        }
        PersonaCRUD alumno1=new PersonaCRUD(id,nombre ,promedio);
        alumnos[indiceInsercion]=alumno1;
        System.out.println("\n"+alumno1.toString());
    }


    /**
     * Metodo para verificar que un valor dentro del arreglo no exista
     * @param id -> int
     * @param alumnos -> arreglo
     * @return -> boolean
     */
    public static boolean verificarID(int id, PersonaCRUD[] alumnos){
        for (PersonaCRUD alumno : alumnos) {
            if(alumno!=null && alumno.getId()==id) {
                return true;
            }
        }
        return false;
    }


    /**
     * Metodo para verificar que un espacio en el arreglo este vacio, o que no este lleno
     * @param alumnos -> arreglo
     * @return -> index (int)
     */
    public static int obtenerIndice(PersonaCRUD[] alumnos){
        for (int i = 0; i < alumnos.length; i++) {
            if(alumnos[i]==null){
                return i;
            }
        }
        return -1;
    }


    /**
     * Metodo para buscar un ID e imprimir
     * @param alumnos -> arreglo
     * @param sc -> declarado en Main
     */
    public static void buscar(PersonaCRUD[] alumnos, Scanner sc){
        int id=validarID(sc,"Ingresa el ID a buscar:");
        boolean idValida=verificarID(id,alumnos);
        if(idValida) {
            for (PersonaCRUD alumno : alumnos) {
                if (alumno != null) {
                    if(alumno.isActivo()) {
                        if (alumno.getId() == id) {
                            System.out.println(alumno.toString());
                        }
                    }else {
                        System.out.println("ID dado de baja");
                    }
                }
            }
        }else {
            System.out.println("ID no encontrado");
        }
    }

    /**
     * Metodo para cambiar si es activo
     * @param alumnos -> arreglo
     * @param sc -> declarado en Main
     */
    public static void baja(PersonaCRUD [] alumnos,Scanner sc){
        int id=validarID(sc,"Ingresa el ID para dar de baja:");
        boolean IDValida=verificarID(id,alumnos);
        if(IDValida) {
            for (PersonaCRUD alumno : alumnos) {
                if (alumno != null ) {
                    if(alumno.isActivo()) {
                        if (alumno.getId() == id) {
                            alumno.setActivo(false);
                            System.out.println(alumno.toString());
                        }
                    }else {
                        System.out.println("ID dado de baja");
                    }
                }
            }
        }else {
            System.out.println("ID no encontrado");
        }
    }


    /**
     * Metodo para imprimir los datos que están dentro del arreglo, solo si un parametro boolean es (true)
     *
     * @param alumnos -> arreglo
     */
    public static void listarActivos(PersonaCRUD[] alumnos){
        for (PersonaCRUD alumno : alumnos){
            if (alumno!=null && alumno.isActivo() ){
                System.out.println(alumno.toString());
            }
        }
    }


    /**
     * Metodo para cambiar el valor de una variable double dentro del arreglo
     * @param alumnos -> arreglo
     * @param sc -> declarado en Main
     */
    public static void actualizarPromedio(PersonaCRUD[] alumnos, Scanner sc){
        int id=validarID(sc,"Ingresa el ID del alumno a cambiar el promedio:");
        boolean validateID=verificarID(id, alumnos);
        if (validateID){
            for(PersonaCRUD alumno : alumnos){
                if (alumno!=null){
                    if (alumno.isActivo()){
                        if (alumno.getId() == id) {
                            double  prom=validarDouble(sc,"Ingresa el nuevo promedio: ");
                            alumno.setPromedio(prom);
                            System.out.println(alumno.toString());
                        }
                    }else {
                        System.out.println("ID dado de baja");
                    }
                }
            }
        }else {
            System.out.println("ID no encontrado");
        }
    }

    /**
     * Metodo para imprimir el reporte
     * @param alumnos -> arreglo
     */
    public static void reportes(PersonaCRUD[] alumnos){
        double sumProm = 0;
        int count = 0;
        int countMayor8 = 0;
        PersonaCRUD menor = null;
        PersonaCRUD mayor = null;
        for(PersonaCRUD alumno : alumnos ){
            if(alumno!=null && alumno.isActivo()){
                sumProm+=alumno.getPromedio();
                count++;
                if(mayor==null || alumno.getPromedio()> mayor.getPromedio()) {
                    mayor=alumno;
                }
                if(menor==null || alumno.getPromedio()<menor.getPromedio()){
                    menor=alumno;
                }
                if (alumno.getPromedio()>=8){
                    countMayor8++;
                }
            }
        }
        if(count>0){
            double averageGeneral=sumProm/count;
            System.out.println("\nPromedio General de Alumnos Activos: "+averageGeneral);
            System.out.println("\nAlumno con el promedio mas alto"+mayor.toString());
            System.out.println("\nAlumno con el promedio mas bajo"+menor.toString());
            System.out.println("\nNumero de alumnos con promedio mayor o igual que 8: "+countMayor8);
        }else {
            System.out.println("No hay alumnos activos");
        }
    }
}