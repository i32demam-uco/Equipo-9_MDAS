package Facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        SistemaTransporte sysTransporte = new SistemaTransporte();
        SistemaAlojamiento sysAlojamiento = new SistemaAlojamiento();
        
        sysTransporte.agregarTransporte(new Transporte("Madrid", "Córdoba", 45.0));
        sysTransporte.agregarTransporte(new Transporte("Barcelona", "Lugo", 60.0));
        
        sysAlojamiento.agregarAlojamiento(new Alojamiento("Córdoba", 80.0, 5));
        sysAlojamiento.agregarAlojamiento(new Alojamiento("Lugo", 65.0, 2));

        OficinaCordoba ofiCordoba = new OficinaCordoba();
        ofiCordoba.agregarActividad(new Actividad("Córdoba", "Visita Mezquita", LocalDate.of(2026, 4, 15), "Cultural"));
        ofiCordoba.agregarActividad(new Actividad("Córdoba", "Ruta de Patios", LocalDate.of(2026, 4, 16), "Ocio"));

        OficinaLugo ofiLugo = new OficinaLugo();
        ofiLugo.agregarActividad(new Actividad("Lugo", "Paseo Muralla Romana", LocalDate.of(2026, 5, 10), "Histórico"));

        List<OficinaTurismo> oficinas = new ArrayList<>();
        oficinas.add(ofiCordoba);
        oficinas.add(ofiLugo);

        AgenciaViajes agencia = new AgenciaViajes(sysTransporte, sysAlojamiento, oficinas);

        LocalDate inicio1 = LocalDate.of(2026, 4, 14);
        LocalDate fin1 = LocalDate.of(2026, 4, 20);
        agencia.buscarViajeCompleto(inicio1, fin1, "Madrid", "Córdoba");

        LocalDate inicio2 = LocalDate.of(2026, 5, 9);
        LocalDate fin2 = LocalDate.of(2026, 5, 12);
        agencia.buscarViajeCompleto(inicio2, fin2, "Barcelona", "Lugo");
    }
}