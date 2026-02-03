public class ShippingCalculator {

    private static final double BASE_ESTANDAR = 50.0;
    private static final double BASE_EXPRESS = 90.0;
    private static final double COSTO_POR_KG = 12.0;
    private static final double RECARGO_REMOTO = 0.10;
    private static final double TASA_IVA = 0.16;

    /**
     * Calcula el costo total de un envio sumando la tarifa base, el peso y la distancia.
     * También aplica un cargo extra si el destino es una zona de dificil acceso.
     *
     * @param pesoKg -> El peso del paquete en kilogramos.
     * @param distanciaKm -> La distancia del viaje en kilómetros.
     * @param tipoServicio -> El tipo de envío: usa 1 para servicio Estándar y cualquier otro numero para Express.
     * @param zonaRemota -> Ponlo en true si el destino es una zona remota (aplica un recargo final).
     * @return -> El precio final calculado (subtotal) del envío.
     */
    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
        double acumulado = 0.0;
        if (tipoServicio == 1) {
            acumulado += BASE_ESTANDAR;
        } else {
            acumulado += BASE_EXPRESS;
        }
        acumulado += (pesoKg * COSTO_POR_KG);
        if (distanciaKm <= 50) {
            acumulado += 20.0;
        } else if (distanciaKm <= 200) {
            acumulado += 60.0;
        } else {
            acumulado += 120.0;
        }
        if (zonaRemota) {
            acumulado = acumulado * (1 + RECARGO_REMOTO);
        }
        return acumulado;
    }
    public double calcularIVA(double subtotal) {
        return subtotal * TASA_IVA;
    }
    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}