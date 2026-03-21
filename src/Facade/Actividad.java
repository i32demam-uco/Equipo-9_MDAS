package Facade;

import java.time.LocalDate;

public class Actividad {
    String ciudad;
    String nombre;
    LocalDate fecha;
    String tipo;

    public Actividad(String ciudad, String nombre, LocalDate fecha, String tipo) {
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Actividad: " + nombre + " en " + ciudad + " el " + fecha + " [" + tipo + "]";
    }
}