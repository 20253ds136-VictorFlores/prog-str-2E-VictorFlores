import java.util.Scanner;
public class Main{
    public static int CONTADOR = 0;
    public static int INTERVALO_CONTADOR = 1;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int valorContador = pedirEntero(sc, "Ingresa el numero para hacer la secuencia: ");
        int resultadoSecuencia = sumarHastaN(valorContador);
        System.out.println("El resultado es: "+resultadoSecuencia);
    }

    /**
     * Se muestran los mensajes y se registran los valores ingresados
     * @param sc -> declarado en el main
     * @param mensaje -> es un parametro
     * @return -> double
     */
    public static int pedirEntero(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt() ;
    }

    /**
     * Este metodo calcula la secuencia del numero ingresado
     * @param valorContador -> Parametro que acepta un int com entrada
     * @return -> resultado del calculo de la secuencia
     */
    public static int sumarHastaN(int valorContador){
        for (INTERVALO_CONTADOR=1; INTERVALO_CONTADOR<=valorContador; INTERVALO_CONTADOR++){
            CONTADOR += INTERVALO_CONTADOR;
        }
        return CONTADOR;
    }
}