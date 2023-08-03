package cl.Awakelab.Restaurante.CalculadoraDescuentos;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDescuentos {
    private CalculadoraDescuento calculadoraCantidad;
    private CalculadoraDescuento calculadoraCapacidad;

    public CalculadoraDescuentos() {
        calculadoraCantidad = new CalculoCantidad();
        calculadoraCapacidad = new CalculoCapacidad();
    }

    public List<Double> calcularPorcentajesDescuento(List<Detalle> detalles) {
        List<Double> porcentajesDescuento = new ArrayList<>();

        for (Detalle detalle : detalles) {
            double porcentajeCantidad = calculadoraCantidad.descuento(detalle);
            double porcentajeCapacidad = calculadoraCapacidad.descuento(detalle);
            double porcentajeDescuentoTotal = porcentajeCantidad + porcentajeCapacidad;

            porcentajesDescuento.add(porcentajeDescuentoTotal);
        }

        return porcentajesDescuento;
    }
}