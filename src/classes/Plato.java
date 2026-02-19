package classes;

public class Plato {

    private String nombre;
    private float precio;
    private TipoPlato tipo;
    private TipoAcompanamiento acompanamiento;

    public void setPrecio(float nuevoPrecio) {
        precio = nuevoPrecio;
    }

    public void setPrecio(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

}