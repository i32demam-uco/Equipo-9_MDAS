package Facade;

public class Transporte{
    String ciudadOrigen;
    String ciudadDestino;
    double precio;

    public Transporte(String ciudadOrigen, String ciudadDestino, double precio) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vuelo: " + ciudadOrigen + " -> " + ciudadDestino + " (" + precio + "€)";
    }
}