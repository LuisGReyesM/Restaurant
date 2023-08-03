package cl.Awakelab.Restaurante.CalculadoraDescuentos;

public class Detalle {
    private int numPlatos;
    private int capacidadMesa;

    public Detalle(int numPlatos, int capacidadMesa) {
        this.numPlatos = numPlatos;
        this.capacidadMesa = capacidadMesa;
    }

    public int getNumPlatos() {
        return numPlatos;
    }

    public int getCapacidadMesa() {
        return capacidadMesa;
    }
}