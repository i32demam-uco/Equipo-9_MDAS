package Adapter;

public interface InterfazRequerida {
    void unirFicheros(String rutaFichero1, String rutaFichero2);
    
    void combinarContenidos(String rutaFichero1, String rutaFichero2, 
                              int[] iniciosF1, int[] finesF1, 
                              int[] iniciosF2, int[] finesF2, 
                              String rutaDestino);
                              
    void separarFicheros(String rutaOrigen, int[] lineasCorte, String[] rutasDestino);
}