import java.util.Random;
import java.util.Scanner;



public class AdivinaNumero {
    static Random random= new Random();
    public static int MIN=1;
    public static int MAX=100;
    public static int INTENTOS=0;
    public static int LIMITE_INTENTOS=7;
    public static int SECRETO = random.nextInt(MAX)+MIN;
    public static boolean GANO = false;
    public static int valorIncorrecto = 0;
    public static int numeroFuera = 0;
    public static void main(String[] args) throws Exception {
        Scanner scanner= new Scanner(System.in);

        System.out.println(SECRETO);
        System.out.println("Adivina el numero entre (1-100) tienes: "+LIMITE_INTENTOS);

        while(INTENTOS<LIMITE_INTENTOS && !GANO){
            int valor=obtenerNumeroValido(MIN, MAX, scanner, "Intento: "+(INTENTOS+1));
            INTENTOS++;
            if(valor == SECRETO){
                System.out.println("¡Ganaste!");
                System.out.println("Ingresaste "+valorIncorrecto+" valores incorrectos.");
                System.out.println("Ingresaste "+numeroFuera+" numeros fuera del rango.");
                GANO=true;
            }else if(valor>SECRETO){
                System.out.println("El numero es menor");
            }else{
                System.out.println("El numero es mayor");
            }
        }
        if(!GANO){
            System.out.println("Perdiste, el numero SECRETO era: "+SECRETO);
            System.out.println("Ingresaste "+valorIncorrecto+" valores incorrectos.");
            System.out.println("Ingresaste "+numeroFuera+" numeros fuera del rango.");
        }
        scanner.close();
    }

    /**
     * Pide al usuario un número entero dentro de un rango.
     *
     * Muestra un mensaje, valida que la entrada sea un número y que esté
     * entre MIN y MAX. Si el dato no es válido, vuelve a pedirlo hasta
     * que se ingrese correctamente.
     *
     * @param MIN     límite inferior permitido.
     * @param MAX     límite superior permitido.
     * @param scanner objeto Scanner para leer la entrada.
     * @param mensaje texto que se muestra al usuario.
     * @return        número entero válido dentro del rango.
     */
    public static int obtenerNumeroValido(int MIN, int MAX, Scanner scanner, String mensaje){
        int valor;
        while(true){
            System.out.println(mensaje);
            if(scanner.hasNextInt()){
                valor = scanner.nextInt();
                if(valor>=MIN && valor<=MAX){
                    return valor;
                }else {
                    System.out.println("Numero fuera de rango debe de ser entre " + MIN + " y" + MAX);
                    numeroFuera++;
                }
            }else{
                valorIncorrecto++;
                System.out.println("El dato que ingresaste no es un numero");
                scanner.next();
            }
        }

    }
}