package cl.Awakelab.Restaurante.CalculadoraDescuentos;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculoCapacidadTest {

    @Test
    public void testCalculoDescuentosPorCapacidadCondicionesNormales() {
        List<Detalle> detalles = Arrays.asList(
                new Detalle(8, 3),  // 15% de descuento
                new Detalle(12, 4), // 20% de descuento
                new Detalle(20, 8)  // 30% de descuento
        );

        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();
        List<Double> porcentajesDescuento = calculadora.calcularPorcentajesDescuento(detalles);

        assertEquals(0.15, porcentajesDescuento.get(0), 0.001); // 15%
        assertEquals(0.20, porcentajesDescuento.get(1), 0.001); // 20%
        assertEquals(0.30, porcentajesDescuento.get(2), 0.001); // 30%
    }

    @Test
    public void testCalculoDescuentosPorCapacidadCondicionesDeBorde() {
        List<Detalle> detalles = Arrays.asList(
                new Detalle(5, 3),  // Sin descuento (menos de 5 platos)
                new Detalle(10, 6), // 20% de descuento
                new Detalle(15, 4), // 20% de descuento
                new Detalle(6, 2),  // 15% de descuento
                new Detalle(16, 7)  // 30% de descuento
        );

        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();
        List<Double> porcentajesDescuento = calculadora.calcularPorcentajesDescuento(detalles);

        assertEquals(0, porcentajesDescuento.get(0), 0.001);   // 0%
        assertEquals(0.20, porcentajesDescuento.get(1), 0.001); // 20%
        assertEquals(0.20, porcentajesDescuento.get(2), 0.001); // 20%
        assertEquals(0.15, porcentajesDescuento.get(3), 0.001); // 15%
        assertEquals(0.30, porcentajesDescuento.get(4), 0.001); // 30%
    }
}