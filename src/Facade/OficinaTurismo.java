package Facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class OficinaTurismo {
    String ciudadAsignada;
    List<Actividad> listaActividades = new ArrayList<>();

    public OficinaTurismo(String ciudadAsignada) {
        this.ciudadAsignada = ciudadAsignada;
    }

    public void agregarActividad(Actividad a) { 
        listaActividades.add(a); 
    }

    // Método que implementarán las clases hijas
    public abstract List<Actividad> buscarActividades(LocalDate f_inicio, LocalDate f_fin);
}
