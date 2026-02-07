public class GradeService {
    public static double califFinal = 0;
    public double calcularPromedio(double calificacion1, double calificacion2, double calificacion3) {
        return (calificacion1 + calificacion2 + calificacion3) / 3.0;
    }
    public double calcularFinal(double promedio, int asistencia) {

        califFinal =(promedio * 0.7) + (asistencia * 0.3);
        return califFinal;
    }
    public String determinarEstado(double calificacionFinal, int asistencia, boolean entregoProyecto) {
        if (asistencia < 80) {
            return "REPROBADO por asistencia";
        }
        if (!entregoProyecto) {
            return "REPROBADO por proyecto";
        }
        if (califFinal >= 70) {
            return "APROBADO";
        } else {
            return "REPROBADO por calificación";
        }
    }
}