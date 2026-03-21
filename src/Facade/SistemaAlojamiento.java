package Facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaAlojamiento {
    List<Alojamiento> listaAlojamientos = new ArrayList<>();

    public void agregarAlojamiento(Alojamiento a) { 
        listaAlojamientos.add(a); 
    }

    public List<Alojamiento> buscarHoteles(String ciudad, LocalDate f_inicio, LocalDate f_fin) {
        List<Alojamiento> resultados = new ArrayList<>();
        for (Alojamiento a : listaAlojamientos) {
            if (a.ciudad.equalsIgnoreCase(ciudad) && a.disponibilidad > 0) {
                resultados.add(a);
            }
        }
        return resultados;
    }
}