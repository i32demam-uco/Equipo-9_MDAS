package Composite;

import java.util.ArrayList;
import java.util.List;

// ClaseComposite: Representa salas, edificios o el campus [cite: 13, 23]
public class Espacio implements Componente {
    private String nombre;
    private List<Componente> hijos = new ArrayList<>(); // Agregación [cite: 8]

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
        // Calcula el gasto acumulado de todos los elementos internos [cite: 23]
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