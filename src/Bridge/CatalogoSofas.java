package Bridge;

import java.util.ArrayList;
import java.util.List;

public class CatalogoSofas extends CatalogoBase {

    public List<Producto> buscarPorPlazas(int plazas) {
        List<Producto> resultados = new ArrayList<>();

        System.out.println("Buscando sofás con número de plazas: " + plazas);

        for (IUProveedor p : proveedores) {
            for (Producto prod : p.getProductos()) {
                if (prod.getTipo().equalsIgnoreCase("sofa") && prod.getStock() > 0) {
                    resultados.add(prod);
                }
            }
        }
        return resultados;
    }
}