import java.util.Scanner;


public class Main {
    public static double CLASIFICACION_BAJA=18.5;
    public static double CLASIFICACION_MEDIA=25;
    public static double CLASIFICACION_ALTA=30;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double pesoKg= obtenerDouble(sc,"Ingresa el peso en KG");
        double alturaM= obtenerDouble(sc,"Ingresa la altura en M -> 1.80");
        double IMC= calcularIMC(pesoKg,alturaM);
        System.out.println("IMC: "+IMC);

        String clasificacion= obtenerClasificicacionIMC(IMC);
        System.out.println("Clasificación"+ clasificacion);

    }

    /** * Metodo que retorna un valor capturado por terminal * @param sc -> previamente declarado en main * @param mensaje -> es un parametro * @return -> double */ public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /** * Metodo que devuelve el IMC con formula -> peso/altura² * @param pesoKg -> expresado en Kilos * @param alturaM -> expresado en Metros * @return -> double de IMC */ public static double calcularIMC(double pesoKg, double alturaM){
        return pesoKg/(alturaM*alturaM);
    }

    /** * Metodo que clasifica IMC segun reglas de negocio establecidas * Bajo-> IMC<18.5 * @param IMC -> Previamente calculado por el sistema * @return -> String de clasficacion */ public static String obtenerClasificicacionIMC(double IMC){
        if(IMC<CLASIFICACION_BAJA) return "Peso Bajo";
        else if(IMC<CLASIFICACION_MEDIA) return "Medio";
        else if(IMC<CLASIFICACION_ALTA) return "Sobre peseo";
        else return "Obesidad";
    }

}