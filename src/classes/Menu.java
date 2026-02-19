package classes;

import java.util.List;

public class Menu {

    private List<Plato> platos;

    public Menu(){}

    public float calcularPrecio() {

        float precioMenu = 0;
        for (Plato plato : platos) {
            precioMenu += plato.getPrecio();
        }
        return precioMenu;

    }

    public List<Plato> obtenerPlatos() {

        return platos;

    }

    public void asignarPlato(Plato plato) {

        platos.add(plato);

    }

}
