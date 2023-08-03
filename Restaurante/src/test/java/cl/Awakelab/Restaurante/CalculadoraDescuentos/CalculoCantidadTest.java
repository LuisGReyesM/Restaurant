package cl.Awakelab.Restaurante.CalculadoraDescuentos;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculoCantidadTest {

    @Test
    public void testCalculoDescuentosPorCantidadCondicionesNormales() {
        List<Detalle> detalles = Arrays.asList(
                new Detalle(4, 4),  // Sin descuento (hasta 5 platos)
                new Detalle(8, 5),  // 3% de descuento
                new Detalle(12, 6), // 5% de descuento
                new Detalle(20, 8)  // 30% de descuento
        );

        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();
        List<Double> porcentajesDescuento = calculadora.calcularPorcentajesDescuento(detalles);

        assertEquals(0, porcentajesDescuento.get(0), 0.001);   // 0%
        assertEquals(0.03, porcentajesDescuento.get(1), 0.001); // 3%
        assertEquals(0.05, porcentajesDescuento.get(2), 0.001); // 5%
        assertEquals(0.30, porcentajesDescuento.get(3), 0.001); // 30%
    }

    @Test
    public void testCalculoDescuentosPorCantidadCondicionesDeBorde() {
        List<Detalle> detalles = Arrays.asList(
                new Detalle(5, 4),  // Sin descuento (hasta 5 platos)
                new Detalle(10, 5), // 5% de descuento
                new Detalle(15, 6), // 5% de descuento
                new Detalle(2, 4),  // Sin descuento (hasta 5 platos)
                new Detalle(16, 6)  // 30% de descuento
        );

        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();
        List<Double> porcentajesDescuento = calculadora.calcularPorcentajesDescuento(detalles);

        assertEquals(0, porcentajesDescuento.get(0), 0.001);   // 0%
        assertEquals(0.05, porcentajesDescuento.get(1), 0.001); // 5%
        assertEquals(0.05, porcentajesDescuento.get(2), 0.001); // 5%
        assertEquals(0, porcentajesDescuento.get(3), 0.001);   // 0%
        assertEquals(0.30, porcentajesDescuento.get(4), 0.001); // 30%
    }
}