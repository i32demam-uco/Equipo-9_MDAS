package Facade;

import java.time.LocalDate;
import java.util.List;

public class AgenciaViajes {
    private SistemaTransporte servicioTransporte;
    private SistemaAlojamiento servicioAlojamiento;
    private List<OficinaTurismo> oficinasTurismo;

    public AgenciaViajes(SistemaTransporte t, SistemaAlojamiento a, List<OficinaTurismo> o) {
        this.servicioTransporte = t;
        this.servicioAlojamiento = a;
        this.oficinasTurismo = o;
    }

    public void buscarViajeCompleto(LocalDate f_inicio, LocalDate f_fin, String origen, String destino) {
        System.out.println("=== BÚSQUEDA DE VIAJE: " + origen + " -> " + destino + " ===");
        System.out.println("Fechas: " + f_inicio + " a " + f_fin);
        System.out.println("--------------------------------------------------");

        System.out.println("-> Vuelos disponibles:");
        List<Transporte> vuelos = servicioTransporte.buscarVuelos(origen, destino, f_inicio, f_fin);
        for (Transporte t : vuelos) { System.out.println(t); }

        System.out.println("\n-> Hoteles disponibles:");
        List<Alojamiento> hoteles = servicioAlojamiento.buscarHoteles(destino, f_inicio, f_fin);
        for (Alojamiento h : hoteles) { System.out.println(h); }

        System.out.println("\n-> Actividades disponibles:");
        boolean oficinaEncontrada = false;
        for (OficinaTurismo oficina : oficinasTurismo) {
            if (oficina.ciudadAsignada.equalsIgnoreCase(destino)) {
                oficinaEncontrada = true;
                List<Actividad> actividades = oficina.buscarActividades(f_inicio, f_fin);
                for (Actividad act : actividades) { System.out.println(act); }
                break;
            }
        }
        if (!oficinaEncontrada) {
            System.out.println("No hay oficina de turismo registrada para " + destino);
        }
        System.out.println("==================================================\n");
    }
}