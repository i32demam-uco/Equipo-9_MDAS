package Facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OficinaCordoba extends OficinaTurismo {
    public OficinaCordoba() { 
        super("Córdoba"); 
    }

    public List<Actividad> buscarPorTipo(String tipo) {
        List<Actividad> resultados = new ArrayList<>();
        for (Actividad a : listaActividades) {
            if (a.tipo.equalsIgnoreCase(tipo)) resultados.add(a);
        }
        return resultados;
    }

    @Override
    public List<Actividad> buscarActividades(LocalDate f_inicio, LocalDate f_fin) {
        List<Actividad> filtradas = new ArrayList<>();
        // Filtramos por las culturales que caigan en la fecha
        for(Actividad a : buscarPorTipo("Cultural")) {
            if(!a.fecha.isBefore(f_inicio) && !a.fecha.isAfter(f_fin)) {
                filtradas.add(a);
            }
        }
        return filtradas;
    }
}