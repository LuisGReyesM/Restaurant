package cl.Awakelab.Restaurante.CalculadoraDescuentos;

public class CalculoCantidad implements CalculadoraDescuento {
    @Override
    public double descuento(Detalle detalle) {
        int numPlatos = detalle.getNumPlatos();
        double porcentajeDescuento = 0;

        // Cálculo según la edad
        if (numPlatos > 5 && numPlatos < 10) {
            porcentajeDescuento += 0.03;
        } else if (numPlatos >= 10 && numPlatos <= 15) {
            porcentajeDescuento += 0.05;
        } else if (numPlatos > 15) {
            porcentajeDescuento += 0.30;
        }

        return porcentajeDescuento;
    }
}