package Facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaTransporte {
    List<Transporte> listaTransportes = new ArrayList<>();

    public void agregarTransporte(Transporte t) { 
        listaTransportes.add(t); 
    }

    public List<Transporte> buscarVuelos(String ciudadOrigen, String ciudadDestino, LocalDate f_inicio, LocalDate f_fin) {
        List<Transporte> resultados = new ArrayList<>();
        for (Transporte t : listaTransportes) {
            if (t.ciudadOrigen.equalsIgnoreCase(ciudadOrigen) && t.ciudadDestino.equalsIgnoreCase(ciudadDestino)) {
                resultados.add(t);
            }
        }
        return resultados;
    }
}