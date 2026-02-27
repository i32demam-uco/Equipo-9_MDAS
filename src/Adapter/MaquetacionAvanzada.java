package Adapter;

import java.io.File;
import java.io.PrintWriter;

public class MaquetacionAvanzada implements InterfazRequerida {

    // Referencia a la clase existente (Adaptee)
    private MaquetacionBasica maquetadorBasico;

    public MaquetacionAvanzada() {
        this.maquetadorBasico = new MaquetacionBasica();
    }

    @Override
    public void unirFicheros(String rutaFichero1, String rutaFichero2) {
        // Utilizamos extraerParrafo para leer todo el Fichero 2 (poniendo un límite muy alto)
        String contenidoFichero2 = maquetadorBasico.extraerParrafo(rutaFichero2, 1, Integer.MAX_VALUE);
        
        // Usamos anadirTexto para concatenarlo al final del Fichero 1
        maquetadorBasico.anadirTexto(rutaFichero1, contenidoFichero2);
    }

    @Override
    public void combinarContenidos(String rutaFichero1, String rutaFichero2, 
                                     int[] iniciosF1, int[] finesF1, 
                                     int[] iniciosF2, int[] finesF2, 
                                     String rutaDestino) {
        
        // Limpiamos o creamos el archivo destino vacío
        try {
            new PrintWriter(new File(rutaDestino)).close();
        } catch (Exception e) {
            System.err.println("Error al preparar archivo destino: " + e.getMessage());
        }

        int maxParrafos = Math.max(iniciosF1.length, iniciosF2.length);

        // Extraemos e intercalamos utilizando los métodos básicos
        for (int i = 0; i < maxParrafos; i++) {
            if (i < iniciosF1.length) {
                String parrafo1 = maquetadorBasico.extraerParrafo(rutaFichero1, iniciosF1[i], finesF1[i]);
                if (!parrafo1.isEmpty()) maquetadorBasico.anadirTexto(rutaDestino, parrafo1);
            }
            if (i < iniciosF2.length) {
                String parrafo2 = maquetadorBasico.extraerParrafo(rutaFichero2, iniciosF2[i], finesF2[i]);
                if (!parrafo2.isEmpty()) maquetadorBasico.anadirTexto(rutaDestino, parrafo2);
            }
        }
    }

    @Override
    public void separarFicheros(String rutaOrigen, int[] lineasCorte, String[] rutasDestino) {
        // Validamos que haya suficientes rutas destino (una más que cortes)
        if (rutasDestino.length != lineasCorte.length + 1) {
            System.err.println("Error: Se necesitan " + (lineasCorte.length + 1) + " rutas destino para " + lineasCorte.length + " cortes.");
            return;
        }

        int lineaActual = 1;
        
        for (int i = 0; i < lineasCorte.length; i++) {
            String fragmento = maquetadorBasico.extraerParrafo(rutaOrigen, lineaActual, lineasCorte[i] - 1);
            maquetadorBasico.anadirTexto(rutasDestino[i], fragmento);
            lineaActual = lineasCorte[i];
        }
        
        String fragmentoFinal = maquetadorBasico.extraerParrafo(rutaOrigen, lineaActual, Integer.MAX_VALUE);
        maquetadorBasico.anadirTexto(rutasDestino[rutasDestino.length - 1], fragmentoFinal);
    }
}