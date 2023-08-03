package cl.Awakelab.Restaurante.CalculadoraDescuentos;

public class CalculoCapacidad implements CalculadoraDescuento {
    @Override
    public double descuento(Detalle detalle) {
        int numPlatos = detalle.getNumPlatos();
        int capacidadMesa = detalle.getCapacidadMesa();
        double porcentajeDescuento = 0;

        // Cálculo según la cantidad de platos y capacidad de la mesa
        if (numPlatos >= 5 && numPlatos <= 15 && capacidadMesa < 4) {
            porcentajeDescuento = 0.15;
        } else if (numPlatos >= 5 && numPlatos <= 15 && capacidadMesa >= 4 && capacidadMesa <= 6) {
            porcentajeDescuento = 0.20;
        } else if (numPlatos > 15 && capacidadMesa > 6) {
            porcentajeDescuento = 0.30;
        }

        // Aplicar el 15% de descuento adicional para mesa de 2 personas y más de 5 platos
        if (capacidadMesa == 2 && numPlatos > 5) {
            porcentajeDescuento += 0.15;
        }

        return porcentajeDescuento;
    }
}