package Facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OficinaLugo extends OficinaTurismo {
    public OficinaLugo() { 
        super("Lugo"); 
    }

    public List<Actividad> buscarPorFecha(LocalDate fecha) {
        List<Actividad> resultados = new ArrayList<>();
        for (Actividad a : listaActividades) {
            if (a.fecha.equals(fecha)) resultados.add(a);
        }
        return resultados;
    }

    @Override
    public List<Actividad> buscarActividades(LocalDate f_inicio, LocalDate f_fin) {
        List<Actividad> filtradas = new ArrayList<>();
        LocalDate current = f_inicio;
        while (!current.isAfter(f_fin)) {
            filtradas.addAll(buscarPorFecha(current));
            current = current.plusDays(1);
        }
        return filtradas;
    }
}