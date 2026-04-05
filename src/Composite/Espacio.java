package Composite;

import java.util.ArrayList;
import java.util.List;

public class Espacio implements Componente {
    private String nombre;
    private List<Componente> hijos = new ArrayList<>(); 

    public Espacio(String nombre) {
        this.nombre = nombre;
    }

    public void add(Componente componente) {
        hijos.add(componente);
    }

    public void remove(Componente componente) {
        hijos.remove(componente);
    }

    @Override
    public double calcularConsumo() {
        double total = 0;
        for (Componente c : hijos) {
            total += c.calcularConsumo();
        }
        return total;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}