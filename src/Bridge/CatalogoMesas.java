package Bridge;

import java.util.ArrayList;
import java.util.List;

public class CatalogoMesas extends CatalogoBase {

    public List<Producto> buscarPorDimensiones(String dimensiones) {
        List<Producto> resultados = new ArrayList<>();

        System.out.println("Buscando mesas con dimensiones: " + dimensiones);

        for (Proveedor p : proveedores) {
            for (Producto prod : p.getProductos()) {
                if (prod.getTipo().equalsIgnoreCase("mesa") && prod.getStock() > 0) {
                    resultados.add(prod);
                }
            }
        }
        return resultados;
    }
}