package Adapter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MaquetacionBasica {

    public void anadirTexto(String rutaFichero, String texto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFichero, true))) {
            bw.write(texto);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public String extraerParrafo(String rutaFichero, int lineaInicio, int lineaFin) {
        StringBuilder resultado = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            int numeroLinea = 1;
            
            while ((linea = br.readLine()) != null) {
                if (numeroLinea >= lineaInicio && numeroLinea <= lineaFin) {
                    resultado.append(linea).append(System.lineSeparator());
                }
                if (numeroLinea > lineaFin) {
                    break;
                }
                numeroLinea++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return resultado.toString();
    }

    public void dividirFichero(String rutaOrigen, int lineaCorte, String rutaDestino1, String rutaDestino2) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaOrigen));
             BufferedWriter bw1 = new BufferedWriter(new FileWriter(rutaDestino1));
             BufferedWriter bw2 = new BufferedWriter(new FileWriter(rutaDestino2))) {
            
            String linea;
            int numeroLinea = 1;
            
            while ((linea = br.readLine()) != null) {
                if (numeroLinea < lineaCorte) {
                    bw1.write(linea);
                    bw1.newLine();
                } else {
                    bw2.write(linea);
                    bw2.newLine();
                }
                numeroLinea++;
            }
        } catch (IOException e) {
            System.err.println("Error al procesar los archivos: " + e.getMessage());
        }
    }
}