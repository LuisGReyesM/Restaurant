package cl.Awakelab.Restaurante.CalculadoraDescuentos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de detalles y llenarla con instancias de Detalle
        List<Detalle> detalles = new ArrayList<>();
        detalles.add(new Detalle(8, 5));
        detalles.add(new Detalle(12, 6));
        detalles.add(new Detalle(20, 8));

        // Crear una instancia de la clase CalculadoraDescuentos
        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();

        // Calcular los porcentajes de descuento y obtener el resultado
        List<Double> porcentajesDescuento = calculadora.calcularPorcentajesDescuento(detalles);

        // Mostrar los resultados
        for (int i = 0; i < detalles.size(); i++) {
            Detalle detalle = detalles.get(i);
            double porcentajeDescuento = porcentajesDescuento.get(i);
            System.out.println("Para " + detalle.getNumPlatos() + " platos y capacidad de mesa " + detalle.getCapacidadMesa() + ", el descuento es del " + (porcentajeDescuento * 100) + "%.");
        }
    }
}