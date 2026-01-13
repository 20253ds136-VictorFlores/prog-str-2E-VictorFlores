public class Main {

}
import java.util.Scanner;

public class Main {
    public static double IVA=0.16;
    public static double UMBRAL_DESCUENTO=1000;
    public static double DESCUENTO;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double subtotal=obtenerDouble(sc, "Dame el subtotal");
        double total=calculadoraTotal(subtotal);

        System.out.println("Total: "+total);
    }

    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    public static double calculadoraTotal (double subtotal) {
        double totalConIVA=subtotal+(subtotal*IVA);
        return calcularDescuento(totalConIVA);
    }

    public static double calcularDescuento(double total){
        if (total>UMBRAL_DESCUENTO){
            total=total-(total*DESCUENTO);
        }
        return total;
    }
}
