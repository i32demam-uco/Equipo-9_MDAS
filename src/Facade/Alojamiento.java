package Facade;

public class Alojamiento {
    String ciudad;
    double precio;
    int disponibilidad;

    public Alojamiento(String ciudad, double precio, int disponibilidad) {
        this.ciudad = ciudad;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Hotel en " + ciudad + " (" + precio + "€/noche, Disp: " + disponibilidad + ")";
    }
}

